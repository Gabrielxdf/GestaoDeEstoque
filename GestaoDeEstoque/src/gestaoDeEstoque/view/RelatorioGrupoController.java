package gestaoDeEstoque.view;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import gestaoDeEstoque.MainApp;
import gestaoDeEstoque.model.estoque.Grupos;
import gestaoDeEstoque.model.estoque.Produtos;
import gestaoDeEstoque.util.Limpa;
import gestaoDeEstoque.util.pesquisa.Pesquisa;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;

/**
 * Controlador da view ViewGrupo
 * 
 * @author Gabriel Henrique
 *
 */
public class RelatorioGrupoController implements Initializable {

	@FXML
	private ComboBox<Grupos> grupoComboBox;

	@FXML
	private TextField pesquisaTextField;

	@FXML
	private TableView<Produtos> produtosTable;

	@FXML
	private TableColumn<Produtos, String> codigoColumn;

	@FXML
	private TableColumn<Produtos, String> nomeColumn;

	@FXML
	private TableColumn<Produtos, String> valorColumn;

	@FXML
	private TableColumn<Produtos, String> codigoBarrasColumn;

	@FXML
	private TableColumn<Produtos, String> minimoColumn;

	@FXML
	private TableColumn<Produtos, String> idealColumn;

	@FXML
	private TableColumn<Produtos, String> atualColumn;

	@FXML
	private TableColumn<Produtos, String> fornecedorColumn;

	@FXML
	private TableColumn<Produtos, String> classificacaoColumn;

	@FXML
	private TextField quantidadeTextField;

	@FXML
	private TextField valorTextField;

	@FXML
	private ToggleButton pesquisaPorNomeToggleButton;

	@FXML
	private ToggleButton pesquisaPorCodigoToggleButton;

	@FXML
	private CheckBox grupoCheckBox;

	@FXML
	private Button gerarButton;

	private MainApp mainApp;

	/**
	 * Inicializa o controlador ViewGrupoController.
	 * 
	 * @param URL            location
	 * @param ResourceBundle resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		codigoColumn.setCellValueFactory(cellData -> cellData.getValue().getCodigoProperty());
		nomeColumn.setCellValueFactory(cellData -> cellData.getValue().getNomeProperty());
		valorColumn.setCellValueFactory(cellData -> cellData.getValue().getValorProperty());
		codigoBarrasColumn.setCellValueFactory(cellData -> cellData.getValue().getCodigoBarrasProperty());
		minimoColumn.setCellValueFactory(cellData -> cellData.getValue().getEstoqueMinimoProperty());
		idealColumn.setCellValueFactory(cellData -> cellData.getValue().getEstoqueIdealProperty());
		atualColumn.setCellValueFactory(cellData -> cellData.getValue().getEstoqueAtualProperty());
		fornecedorColumn.setCellValueFactory(cellData -> cellData.getValue().getFornecedor().getFornecedorProperty());
		classificacaoColumn.setCellValueFactory(cellData -> cellData.getValue().getClassificacaoProperty());

//Abre uma janela só deste produto específico selecionado, ao dar doubleclick no mouse.
		produtosTable.setOnMousePressed(new EventHandler<MouseEvent>() {
			@SuppressWarnings("unchecked")
			@Override
			public void handle(MouseEvent event) {
				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					Node node = ((Node) event.getTarget()).getParent();
					TableRow<Produtos> row;
					if (node instanceof TableRow) {
						row = (TableRow<Produtos>) node;
					} else {
						// clicking on text part
						row = (TableRow<Produtos>) node.getParent();
					}
					mainApp.showViewProduto(row.getItem());
				}
			}
		});
	}

	/**
	 * Método que popula os campos relevantes a partir do Grupo selecionado na
	 * ComboBox.
	 */
	@FXML
	private void selecionaGrupo() {
		Grupos grupo = grupoComboBox.getSelectionModel().getSelectedItem();
		if (grupo != null) {
			produtosTable.getItems().clear();
			quantidadeTextField.setText(grupo.getQuantidadeProdutos());
			valorTextField.setText(grupo.getValorTotal());
			produtosTable.getItems().addAll(grupo.getListaProdutos());
		}
	}

	/**
	 * Verifica se a CheckBox {@link RelatorioGrupoController#grupoCheckBox} está
	 * marcada. Se estiver, desabilita a ComboBox e apaga os TextField.
	 */
	@FXML
	private void verificaCheckBox() {
		if (grupoCheckBox.isSelected()) {
			Limpa.limpaComboBox(grupoComboBox);
			Limpa.limpaTextField(quantidadeTextField, valorTextField);
			produtosTable.getItems().clear();
			grupoComboBox.setDisable(true);
		} else {
			grupoComboBox.setDisable(false);
		}
	}

	/**
	 * Gera o relatório em PDF de acordo com as escolhas do usuário.
	 */
	@FXML
	private void gerar() {
		Document document = new Document();
		

		if (grupoCheckBox.isSelected()) {
			try {
				PdfWriter.getInstance(document, new FileOutputStream("GestaoDeEstoque/src/Relatorios/Grupos/"
						+ new SimpleDateFormat("dd-MM-yyyy").format(new Date()) + "_" + "todos" + ".pdf"));
				document.open();
				
				document.addCreationDate();
				document.addAuthor("MyStock");
				document.addSubject("Entrada");
				document.addKeywords("MyStock");

				Paragraph p = new Paragraph("Grupo - Todos");
				p.setAlignment(1);
				document.add(p);
				p = new Paragraph(" ");
				document.add(p);
				
				
				for (Grupos g : grupoComboBox.getItems()) {
					
					PdfPTable table = new PdfPTable(9);
					table.setWidthPercentage(100);
					PdfPCell cell = new PdfPCell(new Paragraph("Código"));
					PdfPCell cell1 = new PdfPCell(new Paragraph("Nome"));
					PdfPCell cell2 = new PdfPCell(new Paragraph("Valor"));
					PdfPCell cell3 = new PdfPCell(new Paragraph("Cód. Barras"));
					PdfPCell cell4 = new PdfPCell(new Paragraph("Mínimo"));
					PdfPCell cell5 = new PdfPCell(new Paragraph("Ideal"));
					PdfPCell cell6 = new PdfPCell(new Paragraph("Atual"));
					PdfPCell cell7 = new PdfPCell(new Paragraph("Fornecedor"));
					PdfPCell cell8 = new PdfPCell(new Paragraph("Class."));
					
					table.addCell(cell);
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
					table.addCell(cell5);
					table.addCell(cell6);
					table.addCell(cell7);
					table.addCell(cell8);
					
					for (Produtos x : g.getListaProdutos()) {

						cell = new PdfPCell(new Paragraph(x.getCodigo()));
						cell1 = new PdfPCell(new Paragraph(x.getNome()));
						cell2 = new PdfPCell(new Paragraph("R$ " + x.getValor()));
						cell3 = new PdfPCell(new Paragraph(x.getCodigoBarras()));
						cell4 = new PdfPCell(new Paragraph(x.getEstoqueMinimo()));
						cell5 = new PdfPCell(new Paragraph(x.getEstoqueIdeal()));
						cell6 = new PdfPCell(new Paragraph(x.getEstoqueAtual()));
						cell7 = new PdfPCell(new Paragraph(x.getFornecedor().getNome()));
						cell8 = new PdfPCell(new Paragraph(x.getClassificacao()));

						table.addCell(cell);
						table.addCell(cell1);
						table.addCell(cell2);
						table.addCell(cell3);
						table.addCell(cell4);
						table.addCell(cell5);
						table.addCell(cell6);
						table.addCell(cell7);
						table.addCell(cell8);
					}

					Phrase f = new Phrase("Gerado pelo MyStock");
					document.add(f);
					p = new Paragraph("Grupo: " + g.getNome());
					document.add(p);
					p = new Paragraph("Quantidade de Produtos: " + g.getQuantidadeProdutos());
					document.add(p);
					p = new Paragraph("Valor total deste Grupo: R$ " + g.getValorTotal());
					document.add(p);
					p = new Paragraph("Data: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
					document.add(p);
					p = new Paragraph(" ");
					document.add(p);
					document.add(p);
					document.add(table);
					document.add(p);
					document.add(p);
					document.add(p);

				}
			} catch (DocumentException | IOException e) {
				System.err.println(e.getMessage());
			}
			document.close();
			try {
				Desktop.getDesktop().open(
						new File("GestaoDeEstoque/src/Relatorios/Grupos/" + new SimpleDateFormat("dd-MM-yyyy").format(new Date())
								+ "_" + "todos" + ".pdf"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("GestaoDeEstoque/src/Relatorios/Grupos/"
						+ new SimpleDateFormat("dd-MM-yyyy").format(new Date()) + "_" +
						grupoComboBox.getSelectionModel().getSelectedItem().getNome() + ".pdf"));
				document.open();

				document.addCreationDate();
				document.addAuthor("MyStock");
				document.addSubject("Entrada");
				document.addKeywords("MyStock");
				
				PdfContentByte canvas = writer.getDirectContent();
		        CMYKColor blackColor = new CMYKColor(0.f, 0.f, 0.f, 100.f);
		        canvas.setColorStroke(blackColor);
		        canvas.moveTo(35, 800);
		        canvas.lineTo(560, 800);
		        canvas.moveTo(35, 677);
		        canvas.lineTo(560, 677);
		        canvas.closePathStroke();

				Paragraph p = new Paragraph("Grupo - " + grupoComboBox.getSelectionModel().getSelectedItem().getNome());
				p.setAlignment(1);
				document.add(p);
				p = new Paragraph(" ");
				document.add(p);
					
					PdfPTable table = new PdfPTable(9);
					table.setWidthPercentage(100);
					PdfPCell cell = new PdfPCell(new Paragraph("Código"));
					PdfPCell cell1 = new PdfPCell(new Paragraph("Nome"));
					PdfPCell cell2 = new PdfPCell(new Paragraph("Valor"));
					PdfPCell cell3 = new PdfPCell(new Paragraph("Cód. Barras"));
					PdfPCell cell4 = new PdfPCell(new Paragraph("Mínimo"));
					PdfPCell cell5 = new PdfPCell(new Paragraph("Ideal"));
					PdfPCell cell6 = new PdfPCell(new Paragraph("Atual"));
					PdfPCell cell7 = new PdfPCell(new Paragraph("Fornecedor"));
					PdfPCell cell8 = new PdfPCell(new Paragraph("Classificação"));
					
					table.addCell(cell);
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
					table.addCell(cell5);
					table.addCell(cell6);
					table.addCell(cell7);
					table.addCell(cell8);
					
					for (Produtos x : grupoComboBox.getSelectionModel().getSelectedItem().getListaProdutos()) {

						cell = new PdfPCell(new Paragraph(x.getCodigo()));
						cell1 = new PdfPCell(new Paragraph(x.getNome()));
						cell2 = new PdfPCell(new Paragraph("R$ " + x.getValor()));
						cell3 = new PdfPCell(new Paragraph(x.getCodigoBarras()));
						cell4 = new PdfPCell(new Paragraph(x.getEstoqueMinimo()));
						cell5 = new PdfPCell(new Paragraph(x.getEstoqueIdeal()));
						cell6 = new PdfPCell(new Paragraph(x.getEstoqueAtual()));
						cell7 = new PdfPCell(new Paragraph(x.getFornecedor().getNome()));
						cell8 = new PdfPCell(new Paragraph(x.getClassificacao()));

						table.addCell(cell);
						table.addCell(cell1);
						table.addCell(cell2);
						table.addCell(cell3);
						table.addCell(cell4);
						table.addCell(cell5);
						table.addCell(cell6);
						table.addCell(cell7);
						table.addCell(cell8);
					}

					Phrase f = new Phrase("Gerado pelo MyStock");
					document.add(f);
					p = new Paragraph("Grupo: " + grupoComboBox.getSelectionModel().getSelectedItem().getNome());
					document.add(p);
					p = new Paragraph("Quantidade de Produtos: " + grupoComboBox.getSelectionModel().getSelectedItem().getQuantidadeProdutos());
					document.add(p);
					p = new Paragraph("Valor total deste Grupo: R$ " + grupoComboBox.getSelectionModel().getSelectedItem().getValorTotal());
					document.add(p);
					p = new Paragraph("Data: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
					document.add(p);
					p = new Paragraph(" ");
					document.add(p);
					document.add(p);
					document.add(table);
					document.add(p);
					document.add(p);
					document.add(p);

			} catch (DocumentException | IOException e) {
				System.err.println(e.getMessage());
			}
			document.close();
			/**try {
				Desktop.getDesktop().open(
						new File("GestaoDeEstoque/src/Relatorios/Grupos/" + new SimpleDateFormat("dd-MM-yyyy").format(new Date())
								+ "_" + grupoComboBox.getSelectionModel().getSelectedItem().getNome()+ ".pdf"));
			} catch (IOException e) {
				e.printStackTrace();
		}**/
		}
	}

	/**
	 * Uma instância do MainApp para o Controller poder usar os métodos do MainApp
	 * 
	 * @param {@link EditGruposController#mainApp} uma referência à Aplicação
	 *               principal.
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		grupoComboBox.setItems(mainApp.getGruposData());
	}

	/**
	 * Método de pesquisar na tabela pelo nome, ou código do Grupo, atualizando a
	 * tabela apenas com os Grupo que contém a String passada no campo de texto no
	 * nome ou código.
	 */
	@FXML
	private void pesquisar() {
		ObservableList<Produtos> pesquisa;
		if (pesquisaPorNomeToggleButton.isSelected()) {
			pesquisa = Pesquisa.pesquisarPorNome(mainApp.getProdutosData(), pesquisaTextField.getText());
			produtosTable.setItems(pesquisa);
		}
		if (pesquisaPorCodigoToggleButton.isSelected()) {
			pesquisa = Pesquisa.pesquisarPorCodigo(mainApp.getProdutosData(), pesquisaTextField.getText());
			produtosTable.setItems(pesquisa);
		}
	}
}

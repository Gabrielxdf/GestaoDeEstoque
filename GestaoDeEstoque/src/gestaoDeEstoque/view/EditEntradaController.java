package gestaoDeEstoque.view;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import gestaoDeEstoque.MainApp;
import gestaoDeEstoque.model.estoque.Fornecedor;
import gestaoDeEstoque.model.estoque.Produtos;
import gestaoDeEstoque.util.AlertUtil;
import gestaoDeEstoque.util.pesquisa.Pesquisa;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Controlador da view EditEntrada.
 * 
 * @author Gabriel Henrique
 *
 */
public class EditEntradaController implements Initializable {

	@FXML
	private TextField atualTextField;

	@FXML
	private TextField minimoTextField;

	@FXML
	private TextField idealTextField;

	@FXML
	private TextField observacoesTextField;

	@FXML
	private Button okButton;

	@FXML
	private TextField valorUnitarioTextField;

	@FXML
	private Button cancelarButton;

	@FXML
	private Button helpButton;

	@FXML
	private TableView<Produtos> entradaTable;

	@FXML
	private TableColumn<Produtos, String> codigoColumn;

	@FXML
	private TableColumn<Produtos, String> nomeColumn;

	@FXML
	private TableColumn<String, String> quantidadeColumn;

	@FXML
	private TableColumn<Produtos, String> valorColumn;

	@FXML
	private TableColumn<Double, Double> valorTotalColumn;

	@FXML
	private Button excluirButton;

	@FXML
	private ComboBox<Produtos> produtoComboBox;

	@FXML
	private TextField pesquisaTextField;

	@FXML
	private ToggleButton pesquisaPorNomeToggleButton;

	@FXML
	private ToggleButton pesquisaPorCodigoToggleButton;

	@FXML
	private ComboBox<Fornecedor> fornecedorComboBox;

	@FXML
	private TextField quantidadeTextField;

	@FXML
	private TextField valorTotalTextField;

	@FXML
	private Button addButton;

	private MainApp mainApp;

	private Stage dialogStage;

	/**
	 * Inicializa o controlador EditEntradaController.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		codigoColumn.setCellValueFactory(cellData -> cellData.getValue().getCodigoProperty());
		nomeColumn.setCellValueFactory(cellData -> cellData.getValue().getNomeProperty());
		valorColumn.setCellValueFactory(cellData -> cellData.getValue().getValorProperty());
		quantidadeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(quantidadeTextField.getText()));
		valorTotalColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<Double>(foo()));

		// Abre uma janela só deste produto específico selecionado, ao dar doubleclick
		// no mouse.
		entradaTable.setOnMousePressed(new EventHandler<MouseEvent>() {
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
	 * Preenche todos os dados do Produto selecionado na ComboBox
	 * {@link EditEntradaController#produtoComboBox}
	 * 
	 * @param produto
	 */
	private void showProduto(Produtos produto) {
		fornecedorComboBox.setPromptText(produto.getFornecedor().getNome());
		atualTextField.setText(produto.getEstoqueAtual());
		minimoTextField.setText(produto.getEstoqueMinimo());
		idealTextField.setText(produto.getEstoqueIdeal());
		valorUnitarioTextField.setText(produto.getValor());
		valorTotalTextField.setText(foo().toString());
	}

	/**
	 * Método que atualiza o TextField do valor total entre outros.
	 * 
	 * @return valorTotal
	 */
	@FXML
	private Double foo() {
		try {
			if (quantidadeTextField.getText().length() <= 0) {
				return null;
			} else {
				int qtd = Integer.parseInt(quantidadeTextField.getText());
				Double valor = Double.parseDouble(valorUnitarioTextField.getText());
				Double valorTotal = qtd * valor;
				valorTotalTextField.setText(valorTotal.toString());
				return valorTotal;
			}
		} catch (NumberFormatException e) {
			AlertUtil.criaUmAlert("Erro", "Digite apenas números na quantidade",
					"Digite apenas números inteiros no campo quantidade", "ERROR");
			quantidadeTextField.setText("");
			return null;
		}
	}

	/**
	 * Adiciona um produto à entrada.
	 */
	@FXML
	private void handleAdicionar() {
		if (produtoComboBox.getSelectionModel().getSelectedIndex() >= 0) {

			entradaTable.getItems().add(produtoComboBox.getSelectionModel().getSelectedItem());
		} else {
			AlertUtil.criaUmAlert("Nenhuma seleção", "Nenhum Produto Selecionado",
					"Por favor, Selecione um Produto na tabela.", "ERROR");
		}

	}

	/**
	 * Seleciona um Produto na ComboBox e chama o método
	 * {@link EditEntradaController#showProduto(Produtos)}
	 */
	@FXML
	private void selecionaProduto() {
		if (produtoComboBox.getSelectionModel().getSelectedIndex() >= 0) {
			showProduto(produtoComboBox.getSelectionModel().getSelectedItem());
		}
	}

	/**
	 * Efetua a entrada.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@FXML
	private void handleOk() {
		if (entradaTable.getItems().isEmpty()) {
			AlertUtil.criaUmAlert("Nenhum produto", "Nenhum Produto na entrada",
					"Por favor, Adicione um Produto na entrada.", "ERROR");
		} else {
			int i = 0;
			
			Document document = new Document();
			try {

				PdfWriter.getInstance(document, new FileOutputStream("GestaoDeEstoque/src/Entradas/Teste.pdf"));
				document.open();
				
				// adicionando um parágrafo no documento
				document.addCreationDate();
				document.addAuthor("MyStock");
				document.addSubject("Entradas");
				document.addKeywords("MyStock");
				Paragraph p = new Paragraph("Entradas");
				p.setAlignment(1);
				document.add(new Paragraph(p));
				p = new Paragraph(" ");
				document.add(new Paragraph(p));
				
				PdfPTable table = new PdfPTable(4);
				table.setWidthPercentage(100);
				PdfPCell cell = new PdfPCell(new Paragraph("Código"));
				PdfPCell cell1 = new PdfPCell(new Paragraph("Nome do Produto"));
				PdfPCell cell2 = new PdfPCell(new Paragraph("Quantidade"));
				PdfPCell cell3 = new PdfPCell(new Paragraph("Valor Total"));

				table.addCell(cell);
				table.addCell(cell1);
				table.addCell(cell2);
				table.addCell(cell3);
				
				for (Produtos x : entradaTable.getItems()) {
					int estoqueAtual = Integer.parseInt(x.getEstoqueAtual());
					Produtos item = entradaTable.getItems().get(i);
					TableColumn col = entradaTable.getColumns().get(2);
					String data = (String) col.getCellObservableValue(item).getValue();
					estoqueAtual += Integer.parseInt(data);
					String novoEstoqueAtual = Integer.toString(estoqueAtual);
					x.setEstoqueAtual(new SimpleStringProperty(novoEstoqueAtual));
					i++;
					
					cell = new PdfPCell(new Paragraph(x.getCodigo()));
					cell1 = new PdfPCell(new Paragraph(x.getNome()));
					cell2 = new PdfPCell(new Paragraph(data));
					cell3 = new PdfPCell(new Paragraph(""));

					table.addCell(cell);
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
				}
				
				document.add(table);

			} catch (DocumentException | IOException e) {
				System.err.println(e.getMessage());
			}finally {
				document.close();
			}
			
			/*try {
				Desktop.getDesktop().open(new File("GestaoDeEstoque/src/Entradas/Teste.pdf"));
			} catch (IOException e) {
				e.printStackTrace();
			}*/
			
			
			
			this.dialogStage.close();
		}
	}

	/**
	 * Chamado quando o usuário clica em "Cancelar".
	 */
	@FXML
	private void handleCancel() {
		this.dialogStage.close();
	}

	/**
	 * Cria um Alert com as informações de ajuda da tela.
	 */
	@FXML
	private void helpButton() {
		String content = "CAMPO PRODUTO - Seleciona o Produto para a entrada.\n";
		content += "\n";
		content += "CAMPO FORNECEDOR - Seleciona o Fornecedor para a entrada.\n";
		content += "\n";
		content += "CAMPO QUANTIDADE - Quantidade de Produtos para a Entrada.\n";
		content += "\n";
		content += "CAMPO OBSERVAÇÃO - Obsservação para a Entrada.\n";
		content += "\n";

		AlertUtil.criaUmAlert("Ajuda", "Ajuda - Fornecedores", content, "INFORMATION");
	}

	/**
	 * Método para deletar algum item da Tabela por meio do botão "Excluir".
	 */
	@FXML
	private void handleDelete() {
		int selectedIndex;
		selectedIndex = entradaTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			if (AlertUtil.criaUmAlert("Confirmação", "Você deseja mesmo fazer essa exclusão ?",
					"Excluir o Produto: " + "'" + mainApp.getProdutosData().get(selectedIndex).getNome() + "'" + " ?",
					"CONFIRMATION")) {
				entradaTable.getItems().remove(selectedIndex);
			}
		} else {
			AlertUtil.criaUmAlert("Nenhuma seleção", "Nenhum Produto Selecionado",
					"Por favor, Selecione um Produto na tabela.", "ERROR");
		}
	}

	/**
	 * Método de pesquisar na tabela pelo nome, ou código do Produto, atualizando a
	 * tabela apenas com os Produtos que contém a String passada no campo de texto
	 * do nome ou código.
	 */
	@FXML
	private void pesquisar() {
		ObservableList<Produtos> pesquisa;
		if (pesquisaPorNomeToggleButton.isSelected()) {
			pesquisa = Pesquisa.pesquisarPorNome(mainApp.getProdutosData(), pesquisaTextField.getText());
			entradaTable.setItems(pesquisa);
		}
		if (pesquisaPorCodigoToggleButton.isSelected()) {
			pesquisa = Pesquisa.pesquisarPorCodigo(mainApp.getProdutosData(), pesquisaTextField.getText());
			entradaTable.setItems(pesquisa);
		}
	}

	/**
	 * Define o Stage para este dialogo.
	 * 
	 * @param dialogStage
	 */
	public void setStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	/**
	 * Uma instância do MainApp para o Controller poder usar os métodos do MainApp
	 * 
	 * @param {@link EditFornecedorController#mainApp} uma referência à Aplicação
	 *               principal.
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		produtoComboBox.setItems(mainApp.getProdutosData());
		fornecedorComboBox.setItems(mainApp.getFornecedoresData());
	}

}

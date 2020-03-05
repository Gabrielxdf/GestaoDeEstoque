package gestaoDeEstoque.view;

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
import gestaoDeEstoque.model.estoque.Fornecedor;
import gestaoDeEstoque.model.estoque.Produtos;
import gestaoDeEstoque.model.estoque.entradaOuSaida.Entradas;
import gestaoDeEstoque.model.estoque.entradaOuSaida.ProdutosEntrada;
import gestaoDeEstoque.util.AbrePdf;
import gestaoDeEstoque.util.AlertUtil;
import gestaoDeEstoque.util.BarraDeProgresso;
import gestaoDeEstoque.util.Limpa;
import gestaoDeEstoque.util.Verifica;
import gestaoDeEstoque.util.exception.DadosInvalidosException;
import gestaoDeEstoque.util.factory.FactoryProdutosEntrada;
import gestaoDeEstoque.util.pesquisa.Pesquisa;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
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
	private TextField descricaoTextField;

	@FXML
	private Button okButton;

	@FXML
	private TextField valorUnitarioTextField;

	@FXML
	private Button cancelarButton;

	@FXML
	private Button helpButton;

	@FXML
	private TableView<ProdutosEntrada> entradaTable;

	@FXML
	private TableColumn<ProdutosEntrada, String> codigoColumn;

	@FXML
	private TableColumn<ProdutosEntrada, String> nomeColumn;

	@FXML
	private TableColumn<ProdutosEntrada, String> quantidadeColumn;

	@FXML
	private TableColumn<ProdutosEntrada, String> valorColumn;

	@FXML
	private TableColumn<ProdutosEntrada, String> valorTotalColumn;

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

	@FXML
	private TextField numeroDocumentoTextField;

	@FXML
	private ProgressBar barraDeProgresso;

	@FXML
	private Label progressLabel;

	private MainApp mainApp;

	private Stage dialogStage;

	private ObservableList<ProdutosEntrada> produtos = FXCollections.observableArrayList();

	/**
	 * Inicializa o controlador EditEntradaController.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		codigoColumn.setCellValueFactory(cellData -> cellData.getValue().getProduto().getCodigoProperty());
		nomeColumn.setCellValueFactory(cellData -> cellData.getValue().getProduto().getNomeProperty());
		valorColumn.setCellValueFactory(cellData -> cellData.getValue().getProduto().getValorProperty());
		quantidadeColumn.setCellValueFactory(cellData -> cellData.getValue().getQuantidadeProperty());
		valorTotalColumn.setCellValueFactory(cellData -> cellData.getValue().getValorTotalProperty());

		entradaTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showProduto(newValue.getProduto()));

		// Abre uma janela só deste produto específico selecionado, ao dar doubleclick
		// no mouse.
		entradaTable.setOnMousePressed(new EventHandler<MouseEvent>() {
			@SuppressWarnings("unchecked")
			@Override
			public void handle(MouseEvent event) {
				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					Node node = ((Node) event.getTarget()).getParent();
					TableRow<ProdutosEntrada> row;
					if (node instanceof TableRow) {
						row = (TableRow<ProdutosEntrada>) node;
					} else {
						// clicking on text part
						row = (TableRow<ProdutosEntrada>) node.getParent();
					}
					mainApp.showViewProduto(row.getItem().getProduto());
				}
			}
		});
	}
	
	@FXML
	private void geraBarra() {
		if (this.barraDeProgresso.isVisible()) {
			barraDeProgresso.setVisible(false);
			progressLabel.setVisible(false);
		} else {
			BarraDeProgresso barraProgresso = new BarraDeProgresso(barraDeProgresso);
			Thread t = new Thread(barraProgresso);
			t.start();
			
		}
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
		atualizaValorTotal();
	}

	/**
	 * Método que atualiza o TextField do valor total de acordo com o TextField da
	 * quantidade.
	 */
	@FXML
	private void atualizaValorTotal() {
		try {
			if (quantidadeTextField.getText().length() > 0 && !Verifica.comboBoxSemSeleção(produtoComboBox)) {
				int qtd = Integer.parseInt(quantidadeTextField.getText());
				Double valor = Double.parseDouble(valorUnitarioTextField.getText());
				Double valorTotal = qtd * valor;
				valorTotalTextField.setText(valorTotal.toString());
			} else {
				valorTotalTextField.setText("");
			}
		} catch (NumberFormatException e) {
			AlertUtil.criaUmAlert("Erro", "Digite apenas números na quantidade",
					"Digite apenas números inteiros no campo quantidade", "ERROR");
			Limpa.limpaTextField(quantidadeTextField, valorTotalTextField);
		}
	}

	/**
	 * Adiciona um produto tabela à entrada.
	 */
	@FXML
	private void handleAdicionar() {
		if (produtoComboBox.getSelectionModel().getSelectedIndex() >= 0) {

			try {
				produtos.add(FactoryProdutosEntrada.getProdutosEntrada(
						produtoComboBox.getSelectionModel().getSelectedItem(), quantidadeTextField.getText(),
						valorTotalTextField.getText(), numeroDocumentoTextField.getText()));
			} catch (DadosInvalidosException e) {
				AlertUtil.criaUmAlert("Dados inválidos", "Alguns dados obrigatórios estão inválidos e/ou vazios.",
						e.getMessage(), "ERROR");
			}

			entradaTable.setItems(produtos);

		} else {
			AlertUtil.criaUmAlert("Nenhuma seleção", "Nenhum Produto Selecionado", "Por favor, Selecione um Produto.",
					"ERROR");
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
	 * Efetua a entrada e gera o seu PDF.
	 */
	@FXML
	private void handleOk() {
		if (entradaTable.getItems().isEmpty()) {
			AlertUtil.criaUmAlert("Nenhum produto", "Nenhum Produto na entrada",
					"Por favor, Adicione um Produto na entrada.", "ERROR");
		} else {
			mainApp.getEntradasData().add(new Entradas(entradaTable.getItems(), descricaoTextField.getText(),
					numeroDocumentoTextField.getText()));
			int i = 0;
			Double totalDaEntrada = 0.0;
			Document document = new Document();
			try {
				PdfWriter writer = PdfWriter.getInstance(document,
						new FileOutputStream("GestaoDeEstoque/src/Relatorios/Entradas/"
								+ new SimpleDateFormat("dd-MM-yyyy").format(new Date()) + "_"
								+ numeroDocumentoTextField.getText() + ".pdf"));
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
				Paragraph p = new Paragraph("Entrada - " + descricaoTextField.getText());
				p.setAlignment(1);
				document.add(p);
				p = new Paragraph(" ");
				document.add(p);

				PdfPTable table = new PdfPTable(5);
				table.setWidthPercentage(100);
				PdfPCell cell = new PdfPCell(new Paragraph("Código do Produto"));
				PdfPCell cell1 = new PdfPCell(new Paragraph("Nome do Produto"));
				PdfPCell cell2 = new PdfPCell(new Paragraph("Quantidade"));
				PdfPCell cell3 = new PdfPCell(new Paragraph("Valor Unitário"));
				PdfPCell cell4 = new PdfPCell(new Paragraph("Valor Total"));

				table.addCell(cell);
				table.addCell(cell1);
				table.addCell(cell2);
				table.addCell(cell3);
				table.addCell(cell4);

				for (ProdutosEntrada x : entradaTable.getItems()) {
					// Atualiza o estoque dos produtos.
					int estoqueAtual = Integer.parseInt(x.getProduto().getEstoqueAtual());
					ProdutosEntrada item = entradaTable.getItems().get(i);
					TableColumn<ProdutosEntrada, ?> col = entradaTable.getColumns().get(2);
					String dado = (String) col.getCellObservableValue(item).getValue();
					estoqueAtual += Integer.parseInt(dado);
					String novoEstoqueAtual = Integer.toString(estoqueAtual);
					x.getProduto().setEstoqueAtual(new SimpleStringProperty(novoEstoqueAtual));
					totalDaEntrada += Double.parseDouble(x.getValorTotalProperty().get());
					i++;

					cell = new PdfPCell(new Paragraph(x.getProduto().getCodigo()));
					cell1 = new PdfPCell(new Paragraph(x.getProduto().getNome()));
					cell2 = new PdfPCell(new Paragraph(x.getQuantidadeProperty().get()));
					cell3 = new PdfPCell(new Paragraph(x.getProduto().getValor()));
					cell4 = new PdfPCell(new Paragraph(x.getValorTotalProperty().get()));

					table.addCell(cell);
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
				}
				Phrase f = new Phrase("Gerado pelo MyStock");
				document.add(f);
				p = new Paragraph("Documento de Número: " + numeroDocumentoTextField.getText());
				document.add(p);
				p = new Paragraph("Valor total desta entrada: R$ " + totalDaEntrada);
				document.add(p);
				p = new Paragraph("Data: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
				document.add(p);
				p = new Paragraph("Fornecedor: "
						+ produtoComboBox.getSelectionModel().getSelectedItem().getFornecedor().getNome());
				document.add(p);
				p = new Paragraph(" ");
				document.add(p);
				document.add(p);
				document.add(table);

			} catch (DocumentException | IOException e) {
				System.err.println(e.getMessage());
			} finally {
				document.close();
			}
			document.close();
			AbrePdf pdf = new AbrePdf(new File(
					"GestaoDeEstoque/src/Relatorios/Entradas/" + new SimpleDateFormat("dd-MM-yyyy").format(new Date())
							+ "_" + numeroDocumentoTextField.getText() + ".pdf"));
			Thread threadAbrePdf = new Thread(pdf);
			threadAbrePdf.start();
			this.dialogStage.close();
		}
	}

	/**
	 * Chamado quando o usuário clica em "Cancelar".
	 */
	@FXML
	private void handleCancel() {
		//geraBarra();
		new Thread(() -> {
			if (this.barraDeProgresso.isVisible()) {
				barraDeProgresso.setVisible(false);
				progressLabel.setVisible(false);
			} else {
				BarraDeProgresso barraProgresso = new BarraDeProgresso(barraDeProgresso);
				Thread t = new Thread(barraProgresso);
				t.start();	
			}
        }).start();
		// this.dialogStage.close();
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
		ProdutosEntrada selectedProdutosEntrada = entradaTable.getSelectionModel().getSelectedItem();
		if (selectedIndex >= 0) {
			if (AlertUtil.criaUmAlert("Confirmação", "Você deseja mesmo fazer essa exclusão ?",
					"Excluir o Produto: " + "'" + selectedProdutosEntrada.getProduto().getNome() + "'" + " ?",
					"CONFIRMATION")) {
				entradaTable.getItems().remove(selectedProdutosEntrada);
			}
		} else {
			AlertUtil.criaUmAlert("Nenhuma seleção", "Nenhum Produto Selecionado",
					"Por favor, Selecione um Produto na tabela de entrada.", "ERROR");
		}
	}

	/**
	 * Método de pesquisar na tabela pelo nome, ou código do Produto, atualizando a
	 * tabela apenas com os Produtos que contém a String passada no campo de texto
	 * do nome ou código.
	 */
	@FXML
	private void pesquisar() {
		ObservableList<ProdutosEntrada> pesquisa;
		if (pesquisaPorNomeToggleButton.isSelected()) {
			pesquisa = Pesquisa.pesquisarPorNome(produtos, pesquisaTextField.getText());
			entradaTable.setItems(pesquisa);
		}
		if (pesquisaPorCodigoToggleButton.isSelected()) {
			pesquisa = Pesquisa.pesquisarPorCodigo(produtos, pesquisaTextField.getText());
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
	}

}

package gestaoDeEstoque.view;

import java.net.URL;
import java.util.ResourceBundle;
import gestaoDeEstoque.MainApp;
import gestaoDeEstoque.model.estoque.Produtos;
import gestaoDeEstoque.model.pessoa.Cliente;
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

public class EditSaidaController implements Initializable {

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
	private TableView<Produtos> saidaTable;

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
	private ComboBox<Cliente> clienteComboBox;

	@FXML
	private TextField quantidadeTextField;

	@FXML
	private TextField valorTotalTextField;

	@FXML
	private Button addButton;

	private MainApp mainApp;

	private Stage dialogStage;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		codigoColumn.setCellValueFactory(cellData -> cellData.getValue().getCodigoProperty());
		nomeColumn.setCellValueFactory(cellData -> cellData.getValue().getNomeProperty());
		valorColumn.setCellValueFactory(cellData -> cellData.getValue().getValorProperty());
		quantidadeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(quantidadeTextField.getText()));
		valorTotalColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<Double>(foo()));

		// Abre uma janela só deste produto específico selecionado, ao dar doubleclick
		// no mouse.
		saidaTable.setOnMousePressed(new EventHandler<MouseEvent>() {
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

	private void showProduto(Produtos produto) {
		atualTextField.setText(produto.getEstoqueAtual());
		minimoTextField.setText(produto.getEstoqueMinimo());
		idealTextField.setText(produto.getEstoqueIdeal());
		valorUnitarioTextField.setText(produto.getValor());
		valorTotalTextField.setText(foo().toString());
	}
	
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
			AlertUtil.criaUmAlert("Eroo", "Digite apenas números na quantidade",
					"Digite apenas números inteiros no campo quantidade", "ERROR");
			quantidadeTextField.setText("");
			return null;
		}
	}

	@FXML
	private void handleAdicionar() {
		if(produtoComboBox.getSelectionModel().getSelectedIndex()>=0) {
			
		saidaTable.getItems().add(produtoComboBox.getSelectionModel().getSelectedItem());
		}else {
			AlertUtil.criaUmAlert("Nenhuma seleção", "Nenhum Produto Selecionado",
					"Por favor, Selecione um Produto na tabela.", "ERROR");
		}
		
	}

	@FXML
	private void selecionaProduto() {
		if (produtoComboBox.getSelectionModel().getSelectedIndex() >= 0) {
			showProduto(produtoComboBox.getSelectionModel().getSelectedItem());
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@FXML 
	private void handleOk() {
		if(saidaTable.getItems().isEmpty()) {
			AlertUtil.criaUmAlert("Nenhum produto", "Nenhum Produto na entrada",
					"Por favor, Adicione um Produto na entrada.", "ERROR");
		}else {
			int i = 0;
			for(Produtos x: saidaTable.getItems()) {
				int estoqueAtual = Integer.parseInt(x.getEstoqueAtual());
			    Produtos item = saidaTable.getItems().get(i);
			    TableColumn col = saidaTable.getColumns().get(2);
			    String data = (String) col.getCellObservableValue(item).getValue();
			    estoqueAtual -= Integer.parseInt(data);
			    String novoEstoqueAtual = Integer.toString(estoqueAtual);
			    x.setEstoqueAtual(new SimpleStringProperty(novoEstoqueAtual));
			    i++;
			}
			this.dialogStage.close();
		}
	}
	@FXML
	private void handleCancel() {
		this.dialogStage.close();
	}
	@FXML
	private void helpButton() {
		String content = "CAMPO PRODUTO - Seleciona o Produto para a saída.\n";
		content += "\n";
		content += "CAMPO CLIENTE - Seleciona o Cliente para a saída.\n";
		content += "\n";
		content += "CAMPO QUANTIDADE - Quantidade de Produtos para a saída.\n";
		content += "\n";
		content += "CAMPO OBSERVAÇÃO - Obsservação para a saída.\n";
		content += "\n";

		AlertUtil.criaUmAlert("Ajuda", "Ajuda - Fornecedores", content, "INFORMATION");
	}
	@FXML
	private void handleDelete() {
		int selectedIndex;
		selectedIndex =saidaTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			if (AlertUtil.criaUmAlert("Confirmação", "Você deseja mesmo fazer essa exclusão ?",
					"Excluir o Produto: " + "'" + mainApp.getProdutosData().get(selectedIndex).getNome() + "'" + " ?",
					"CONFIRMATION")) {
				saidaTable.getItems().remove(selectedIndex);
			}
		} else {
			AlertUtil.criaUmAlert("Nenhuma seleção", "Nenhum Produto Selecionado",
					"Por favor, Selecione um Produto na tabela.", "ERROR");
		}
	}

	/**
	 * Método de pesquisar na tabela pelo nome, ou código do Produto, atualizando a tabela apenas
	 * com os Produtos que contém a String passada no campo de texto no nome ou código.
	 */
	@FXML
	private void pesquisar() {
		ObservableList<Produtos> pesquisa;
			if (pesquisaPorNomeToggleButton.isSelected()) {
				pesquisa = Pesquisa.pesquisarPorNome(mainApp.getProdutosData(), pesquisaTextField.getText());
				saidaTable.setItems(pesquisa);
			}
			if (pesquisaPorCodigoToggleButton.isSelected()) {
				pesquisa = Pesquisa.pesquisarPorCodigo(mainApp.getProdutosData(), pesquisaTextField.getText());
				saidaTable.setItems(pesquisa);
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
		clienteComboBox.setItems(mainApp.getClientesData());
	}

}

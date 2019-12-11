package gestaoDeEstoque.view;

import java.net.URL;
import java.util.ResourceBundle;

import gestaoDeEstoque.MainApp;
import gestaoDeEstoque.model.estoque.Fornecedor;
import gestaoDeEstoque.model.estoque.Produtos;
import gestaoDeEstoque.util.pesquisa.Pesquisa;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;

public class ViewFornecedorController implements Initializable{

    @FXML
    private TextField fornecedorTextField;

    @FXML
    private TextField cnpjTextField;

    @FXML
    private TextField codigoTextField;

    @FXML
    private TextField razaoTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField tel1TextField;

    @FXML
    private TextField tel2TextField;

    @FXML
    private TextField cepTextField;

    @FXML
    private TextField pesquisaTextField;

    @FXML
    private TextField enderecoTextField;

    @FXML
    private TextField cidadeTextField;

    @FXML
    private TextField bairroTextField;

    @FXML
    private TextField estadoTextField;

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
    private TableColumn<Produtos, String> grupoColumn;

    @FXML
    private TableColumn<Produtos, String> classificacaoColumn;

    @FXML
    private ToggleButton pesquisaPorNomeToggleButton;

    @FXML
    private ToggleButton pesquisaPorCodigoToggleButton;
    private Fornecedor fornecedor;
    private MainApp mainApp;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		codigoColumn.setCellValueFactory(cellData -> cellData.getValue().getCodigoProperty());
		nomeColumn.setCellValueFactory(cellData -> cellData.getValue().getNomeProperty());
		valorColumn.setCellValueFactory(cellData -> cellData.getValue().getValorProperty());
		codigoBarrasColumn.setCellValueFactory(cellData -> cellData.getValue().getCodigoBarrasProperty());
		minimoColumn.setCellValueFactory(cellData -> cellData.getValue().getEstoqueMinimoProperty());
		idealColumn.setCellValueFactory(cellData -> cellData.getValue().getEstoqueIdealProperty());
		atualColumn.setCellValueFactory(cellData -> cellData.getValue().getEstoqueAtualProperty());
		grupoColumn.setCellValueFactory(cellData -> cellData.getValue().getGrupo().getNomeProperty());
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
	 * Uma instância do MainApp para o Controller poder usar os métodos do MainApp
	 * 
	 * @param {@link EditGruposController#mainApp} uma referência à Aplicação
	 *               principal.
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		produtosTable.setItems(this.fornecedor.getListaProdutos());
		fornecedorTextField.setText(fornecedor.getNome());
		codigoTextField.setText(fornecedor.getCodigo());
		cnpjTextField.setText(fornecedor.getCnpjProperty().get());
		razaoTextField.setText(fornecedor.getRazaoSocialProperty().get());
		emailTextField.setText(fornecedor.getEmailProperty().get());
		tel1TextField.setText(fornecedor.getTelefone().getTelefonesFornecedoresProperty().get(0).get());
		tel2TextField.setText(fornecedor.getTelefone().getTelefonesFornecedoresProperty().get(1).get());
		cepTextField.setText(fornecedor.getEndereco().getCepProperty().get());
		enderecoTextField.setText(fornecedor.getEndereco().getEnderecoProperty().get());
		bairroTextField.setText(fornecedor.getEndereco().getBairroProperty().get());
		cidadeTextField.setText(fornecedor.getEndereco().getCidadeProperty().get());
		estadoTextField.setText(fornecedor.getEndereco().getEstadoProperty().get());
	}

	/**
	 * Seta o Fornecedor dessa view.
	 * 
	 * @param fornecedor	
	 */
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	/**
	 * Método de pesquisar na tabela pelo nome, ou código do Fornecedor, atualizando
	 * a tabela apenas com os Fornecedor que contém a String passada no campo de
	 * texto no nome ou código.
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

package gestaoDeEstoque.view;

import java.net.URL;
import java.util.ResourceBundle;

import gestaoDeEstoque.MainApp;
import gestaoDeEstoque.model.estoque.Grupos;
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

/**
 * Controlador da view ViewGrupo
 * 
 * @author Gabriel Henrique
 *
 */
public class ViewGrupoController implements Initializable {

	@FXML
	private TextField nomeTextField;

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

	private MainApp mainApp;
	private Grupos grupo;

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
	 * Uma instância do MainApp para o Controller poder usar os métodos do MainApp
	 * 
	 * @param {@link EditGruposController#mainApp} uma referência à Aplicação
	 *               principal.
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		produtosTable.setItems((ObservableList<Produtos>) this.grupo.getListaProdutos());
		nomeTextField.setText(grupo.getNome());
		quantidadeTextField.setText(grupo.getQuantidadeProdutosProperty().get());
		valorTextField.setText(grupo.getValorTotalProperty().get());
	}

	/**
	 * Seta o Grupo dessa view.
	 * 
	 * @param grupo
	 */
	public void setGrupo(Grupos grupo) {
		this.grupo = grupo;
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

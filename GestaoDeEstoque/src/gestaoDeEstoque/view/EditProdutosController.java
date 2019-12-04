package gestaoDeEstoque.view;

import java.net.URL;
import java.util.ResourceBundle;
import gestaoDeEstoque.MainApp;
import gestaoDeEstoque.model.estoque.Grupos;
import gestaoDeEstoque.model.estoque.Produtos;
import gestaoDeEstoque.util.Estados;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

public class EditProdutosController implements Initializable {
	@FXML
	private TextField nomeTextField;
	@FXML
	private TextField codigoTextField;
	@FXML
	private TextField valorTextField;
	@FXML
	private TextField codigoBarrasTextField;
	@FXML
	private TextField minimoTextField;
	@FXML
	private TextField idealTextField;
	@FXML
	private TextField codigoFornecedorTextField;
	@FXML
	private TextField descricaoTextField;
	@FXML
	private Button okButton;
	@FXML
	private Button cancelarButton;
	@FXML
	private Button helpButton;
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
	private TableColumn<Produtos, String> codigoFornecedorColumn;
	@FXML
	private TableColumn<Produtos, String> classificacaoColumn;
	@FXML
	private ToggleButton cadastrarToggleButton;
	@FXML
	private ToggleButton alterarToggleButton;
	@FXML
	private Button excluirButton;
	@FXML
	private ComboBox<Grupos> grupoComboBox;
	@FXML
	private ComboBox<String> classificacaoComboBox;
	@FXML
	private TextField pesquisaTextField;
	@FXML
	private ToggleButton pesquisaPorNomeToggleButton;
	@FXML
	private ToggleButton pesquisaPorCodigoToggleButton;

	private MainApp mainApp;
	private Stage dialogStage;

	/**
	 * Inicializa o controlador EditProdutosController.
	 * 
	 * @param URL            location
	 * @param ResourceBundle resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarClassificacaoComboBox();
	}
	

	/**
	 * Carrega a ComboBox dos Grupos
	 */
	private void carregarGrupoComboBox() {
		grupoComboBox.setItems(mainApp.getGruposData());
		
	}

	/**
	 * Carrega a ComboBox das Classificações
	 */
	private void carregarClassificacaoComboBox() {
		classificacaoComboBox.getItems().add("A");
		classificacaoComboBox.getItems().add("B");
		classificacaoComboBox.getItems().add("C");
	}

	/**
	 * Uma inst�ncia do MainApp para o Controller poder usar os m�todos do
	 * MainApp
	 * 
	 * @param {@link EditProdutosController#mainApp} uma refer�ncia �
	 *               Aplica��o principal.
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		produtosTable.setItems(mainApp.getProdutosData());
		carregarGrupoComboBox();
	}

	/**
	 * Define o Stage para este dialogo.
	 * 
	 * @param dialogStage
	 */
	public void setStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

}

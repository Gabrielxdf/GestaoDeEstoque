package gestaoDeEstoque.view;

import java.net.URL;
import java.util.ResourceBundle;
import gestaoDeEstoque.MainApp;
import gestaoDeEstoque.model.estoque.Fornecedor;
import gestaoDeEstoque.util.Estados;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
/**
 * Controlador da view EditFornecedor
 * @author Gabriel Henrique
 *
 */
public class EditFornecedorController implements Initializable{
	@FXML
	private Tab principal;
	@FXML
	private AnchorPane tel2TextField;
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
	private TableView<Fornecedor> principalFornecedorTable;
	@FXML
	private TableColumn<Fornecedor, String> principalCodigoColumn;
	@FXML
	private TableColumn<Fornecedor, String> principalNomeColumn;
	@FXML
	private TableColumn<Fornecedor, String> principalCnpjColumn;
	@FXML
	private TableColumn<Fornecedor, String> principalRazaoColumn;
	@FXML
	private TableColumn<Fornecedor, String> principalEmailColumn;
	@FXML
	private TableColumn<Fornecedor, String> principalTelefonesColumn;
	@FXML
	private TableColumn<Fornecedor, String> principalTel1Column;
	@FXML
	private TableColumn<Fornecedor, String> principalTel2Column;
	@FXML
	private TextField principalPesquisaTextField;
	@FXML
	private ToggleButton principalPesquisaPorNomeToggleButton;
	@FXML
	private ToggleButton principalPesquisaPorCodigoToggleButton;
	@FXML
	private Tab endereco;
	@FXML
	private TextField cepTextField;
	@FXML
	private TextField enderecoTextField;
	@FXML
	private ComboBox <Estados> estadosComboBox;
	@FXML
	private TextField bairroTextField;
	@FXML
	private TextField cidadeTextField;
	@FXML
	private TableView <Fornecedor>enderecoFornecedorTable;
	@FXML
	private TableColumn<Fornecedor, String> enderecoCodigoColumn;
	@FXML
	private TableColumn<Fornecedor, String> enderecoNomeColumn;
	@FXML
	private TableColumn<Fornecedor, String> enderecoCepColumn;
	@FXML
	private TableColumn<Fornecedor, String> enderecoEnderecoColumn;
	@FXML
	private TableColumn<Fornecedor, String> enderecoBairroColumn;
	@FXML
	private TableColumn<Fornecedor, String> enderecoCidadeColumn;
	@FXML
	private TableColumn<Fornecedor, String> enderecoEstadoColumn;
	@FXML
	private TextField enderecoPesquisaTextField;
	@FXML
	private ToggleButton enderecoPesquisaPorNomeToggleButton;
	@FXML
	private ToggleButton enderecoPesquisaPorCodigoToggleButton;
	@FXML
	private Button cancelarButton;
	@FXML
	private Button okButton;
	@FXML
	private Button helpButton;
	@FXML
	private ToggleButton cadastrarToggleButton;
	@FXML
	private ToggleButton alterarToggleButton;
	@FXML
	private Button excluirButton;
	
	private MainApp mainApp;
	private Stage dialogStage;
	
	
	/**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	carregarEstadosComboBox();
    }
    
    /**
	 * Carrega a ComboBox dos Estados
	 */
	private void carregarEstadosComboBox() {
		for (Estados x : Estados.values()){
    		estadosComboBox.getItems().add(x);
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
	 * Uma inst�ncia do MainApp para o Controller poder usar os m�todos do MainApp
	 * 
	 * @param {@link EditFornecedorController#mainApp} uma refer�ncia � Aplica��o
	 *               principal.
	 */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}

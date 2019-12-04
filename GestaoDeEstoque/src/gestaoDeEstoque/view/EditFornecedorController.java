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
	private TextField tel2TextField;
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
	private TableView<Fornecedor> fornecedorTable;
	@FXML
	private TableColumn<Fornecedor, String> codigoColumn;
	@FXML
	private TableColumn<Fornecedor, String> nomeColumn;
	@FXML
	private TableColumn<Fornecedor, String> cnpjColumn;
	@FXML
	private TableColumn<Fornecedor, String> razaoColumn;
	@FXML
	private TableColumn<Fornecedor, String> emailColumn;
	@FXML
	private TableColumn<Fornecedor, String> telefonesColumn;
	@FXML
	private TableColumn<Fornecedor, String> tel1Column;
	@FXML
	private TableColumn<Fornecedor, String> tel2Column;
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
	private TableColumn<Fornecedor, String> cepColumn;
	@FXML
	private TableColumn<Fornecedor, String> enderecoColumn;
	@FXML
	private TableColumn<Fornecedor, String> bairroColumn;
	@FXML
	private TableColumn<Fornecedor, String> cidadeColumn;
	@FXML
	private TableColumn<Fornecedor, String> estadoColumn;
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
    	//inicializa as colunas da tabela
    	codigoColumn.setCellValueFactory(cellData -> cellData.getValue().getFornecedorProperty());
		nomeColumn.setCellValueFactory(cellData -> cellData.getValue().getCodigoProperty());
		cnpjColumn.setCellValueFactory(cellData -> cellData.getValue().getCnpjProperty());
		razaoColumn.setCellValueFactory(cellData -> cellData.getValue().getRazaoSocialProperty());
		emailColumn.setCellValueFactory(cellData -> cellData.getValue().getEmailProperty());
		tel1Column.setCellValueFactory(cellData -> cellData.getValue().getTelefone().getTelefonesFornecedoresProperty().get(0));
		tel2Column.setCellValueFactory(cellData -> cellData.getValue().getTelefone().getTelefonesFornecedoresProperty().get(1));
		enderecoCodigoColumn.setCellValueFactory(cellData -> cellData.getValue().getCodigoProperty());
		enderecoNomeColumn.setCellValueFactory(cellData -> cellData.getValue().getFornecedorProperty());
		cepColumn.setCellValueFactory(cellData -> cellData.getValue().getEndereco().getCepProperty());
		enderecoColumn.setCellValueFactory(cellData -> cellData.getValue().getEndereco().getEnderecoProperty());
		bairroColumn.setCellValueFactory(cellData -> cellData.getValue().getEndereco().getBairroProperty());
		cidadeColumn.setCellValueFactory(cellData -> cellData.getValue().getEndereco().getCidadeProperty());
		estadoColumn.setCellValueFactory(cellData -> cellData.getValue().getEndereco().getEstadoProperty());
		
		showFornecedores(null);
		
		fornecedorTable.getSelectionModel().selectedItemProperty()
		.addListener((observable, oldValue, newValue) -> showFornecedores(newValue));
		
    }
    /**
	 * Preenche todos os campos de texto com o os dados do Fornecedor selecionado. Se o
	 * grupo especificado for null, limpa todos os campos de texto.
	 * 
	 * @param fornecedor ou null
	 */
    private void showFornecedores(Fornecedor fornecedor) {
    	if(fornecedor != null) {
    		fornecedorTextField.setText(fornecedor.getFornecedorProperty().getName());
    		cnpjTextField.setText(fornecedor.getCnpjProperty().getName());
    		codigoTextField.setText(fornecedor.getCodigoProperty().getName());
    		razaoTextField.setText(fornecedor.getRazaoSocialProperty().getName());
    		emailTextField.setText(fornecedor.getEmailProperty().getName());
    		tel1TextField.setText(fornecedor.getTelefone().getTelefonesFornecedoresProperty().get(0).getName());
    		tel2TextField.setText(fornecedor.getTelefone().getTelefonesFornecedoresProperty().get(1).getName());
    		cepTextField.setText(fornecedor.getEndereco().getCepProperty().getName());
    		enderecoTextField.setText(fornecedor.getEndereco().getEnderecoProperty().getName());
    		bairroTextField.setText(fornecedor.getEndereco().getBairroProperty().getName());
    		cidadeTextField.setText(fornecedor.getEndereco().getCidadeProperty().getName());
    	}else {
    		fornecedorTextField.setText("");
    		cnpjTextField.setText("");
    		codigoTextField.setText("");
    		razaoTextField.setText("");
    		emailTextField.setText("");
    		tel1TextField.setText("");
    		tel2TextField.setText("");
    		cepTextField.setText("");
    		enderecoTextField.setText("");
    		bairroTextField.setText("");
    		cidadeTextField.setText("");
    	}
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

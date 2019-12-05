package gestaoDeEstoque.view;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.parg.viacep.ViaCEP;
import gestaoDeEstoque.MainApp;
import gestaoDeEstoque.model.estoque.Fornecedor;
import gestaoDeEstoque.util.Enderecos;
import gestaoDeEstoque.util.Estados;
import gestaoDeEstoque.util.Telefones;
import gestaoDeEstoque.util.Verifica;
import gestaoDeEstoque.util.factory.FactoryFornecedores;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
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
	@FXML
	private Label cepLabel;
	
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
    	codigoColumn.setCellValueFactory(cellData -> cellData.getValue().getCodigoProperty());
		nomeColumn.setCellValueFactory(cellData -> cellData.getValue().getFornecedorProperty());
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
		enderecoFornecedorTable.getSelectionModel().selectedItemProperty()
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
    		fornecedorTextField.setText(fornecedor.getFornecedorProperty().get());
    		cnpjTextField.setText(fornecedor.getCnpjProperty().get());
    		codigoTextField.setText(fornecedor.getCodigoProperty().get());
    		razaoTextField.setText(fornecedor.getRazaoSocialProperty().get());
    		emailTextField.setText(fornecedor.getEmailProperty().get());
    		tel1TextField.setText(fornecedor.getTelefone().getTelefonesFornecedoresProperty().get(0).get());
    		tel2TextField.setText(fornecedor.getTelefone().getTelefonesFornecedoresProperty().get(1).get());
    		cepTextField.setText(fornecedor.getEndereco().getCepProperty().get());
    		enderecoTextField.setText(fornecedor.getEndereco().getEnderecoProperty().get());
    		bairroTextField.setText(fornecedor.getEndereco().getBairroProperty().get());
    		cidadeTextField.setText(fornecedor.getEndereco().getCidadeProperty().get());
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
	 * Chamado quando o usuário clica em "Ok". De acordo com o que ele está
	 * selecionando no ToggleButton, o método adiciona um novo Fornecedor, ou edita um
	 * Fornecedor selecionado.
	 */
	@FXML
	private void handleOk() {
		if (cadastrarToggleButton.isSelected()) {
			String errorMessage = "";
			if(!Verifica.validaCnpj(cnpjTextField.getText())) {
				errorMessage += "CNPJ Inválido!\n";
			}
			if(!verificaCep()) {
				errorMessage += "CEP não encontrado ou inválido.";
			}
			Fornecedor tempFornecedor = FactoryFornecedores.getFornecedor(fornecedorTextField.getText(), cnpjTextField.getText(),
			codigoTextField.getText(), emailTextField.getText(), new Telefones(tel1TextField.getText(), tel2TextField.getText()),
			new Enderecos(cepTextField.getText(), bairroTextField.getText(), cidadeTextField.getText(), enderecoTextField.getText(),
					estadosComboBox.getSelectionModel().getSelectedItem().toString()), razaoTextField.getText());
			
			if(tempFornecedor != null) {
				mainApp.getFornecedoresData().add(tempFornecedor);
				fornecedorTable.setItems(mainApp.getFornecedoresData());
				enderecoFornecedorTable.setItems(mainApp.getFornecedoresData());
			}else {
				errorMessage += "Alguns dados obrigatórios estão inválidos e/ou vazios.";
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Dados inválidos");
				alert.setHeaderText("Alguns dados obrigatórios estão inválidos e/ou vazios.");
				alert.setContentText(errorMessage);
				alert.showAndWait();
			}
			}
		}
		
		@FXML
		private boolean verificaCep() {
			if(cepTextField.getText().length() >= 8) {
			Verifica cep = new Verifica();
			cep.validaCep(cepTextField.getText());
			ViaCEP cepObjeto = cep.getCep();
			if(cepObjeto != null) {
				enderecoTextField.setText(cepObjeto.getLogradouro() + " " + cepObjeto.getComplemento());
				bairroTextField.setText(cepObjeto.getBairro());
				cidadeTextField.setText(cepObjeto.getLocalidade());
				cepLabel.setText("");
				return true;
			}else {
				cepLabel.setText("CEP não encontrado ou inválido.");
				return false;
			}
			}else {
				return false;
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
        fornecedorTable.setItems(mainApp.getFornecedoresData());
		enderecoFornecedorTable.setItems(mainApp.getFornecedoresData());
    }
}

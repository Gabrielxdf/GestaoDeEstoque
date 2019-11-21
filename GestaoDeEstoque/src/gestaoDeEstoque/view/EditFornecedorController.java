package gestaoDeEstoque.view;

import java.net.URL;
import java.util.ResourceBundle;

import gestaoDeEstoque.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.ToggleButton;

import javafx.scene.control.ComboBox;

import javafx.scene.control.Tab;

import javafx.scene.layout.AnchorPane;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

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
	private TableView principalFornecedorTable;
	@FXML
	private TableColumn principalCodigoColumn;
	@FXML
	private TableColumn principalNomeColumn;
	@FXML
	private TableColumn principalCnpjColumn;
	@FXML
	private TableColumn principalRazaoColumn;
	@FXML
	private TableColumn principalEmailColumn;
	@FXML
	private TableColumn principalTelefonesColumn;
	@FXML
	private TableColumn principalTel1Column;
	@FXML
	private TableColumn principalTel2Column;
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
	private ComboBox estadoComboBox;
	@FXML
	private TextField bairroTextField;
	@FXML
	private TextField cidadeTextField;
	@FXML
	private TableView enderecoFornecedorTable;
	@FXML
	private TableColumn enderecoCodigoCOlumn;
	@FXML
	private TableColumn enderecoNomeColumn;
	@FXML
	private TableColumn enderecoCepColumn;
	@FXML
	private TableColumn enderecoEnderecoColumn;
	@FXML
	private TableColumn enderecoBairroColumn;
	@FXML
	private TableColumn enderecoCidadeColumn;
	@FXML
	private TableColumn enderecoEstadoColumn;
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
	
	
	/**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        estadoComboBox.getItems().addAll("AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO");

    }

    /**
     * É chamado pela aplicação principal para dar uma referência de volta a si
     * mesmo.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}

package gestaoDeEstoque.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.ToggleButton;

import javafx.scene.control.ComboBox;

import javafx.scene.control.Tab;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class EditClienteController implements Initializable{
	@FXML
	private Tab principal;
	@FXML
	private TextField nomeTextField;
	@FXML
	private TextField cpfTextField;
	@FXML
	private TextField codigoTextField;
	@FXML
	private TextField dataTextField;
	@FXML
	private TextField emailTextField;
	@FXML
	private TextField telCelularTextField;
	@FXML
	private TextField telResidencialTextField;
	@FXML
	private TableView principalClienteTable;
	@FXML
	private TableColumn principalCodigoColumn;
	@FXML
	private TableColumn principalNomeColumn;
	@FXML
	private TableColumn cpfColumn;
	@FXML
	private TableColumn DataColumn;
	@FXML
	private TableColumn emailColumn;
	@FXML
	private TableColumn telefonesColumn;
	@FXML
	private TableColumn celularColumn;
	@FXML
	private TableColumn residencialColumn;
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
	private TableView enderecoClienteTable;
	@FXML
	private TableColumn enderecoCodigoColumn;
	@FXML
	private TableColumn enderecoNomeColumn;
	@FXML
	private TableColumn cepColumn;
	@FXML
	private TableColumn enderecoColumn;
	@FXML
	private TableColumn bairroColumn;
	@FXML
	private TableColumn cidadeColumn;
	@FXML
	private TableColumn estadoColumn;
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
	
	@Override
	public void initialize(URL location, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}

}

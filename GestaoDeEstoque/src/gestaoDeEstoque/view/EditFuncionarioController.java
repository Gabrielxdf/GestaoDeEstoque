package gestaoDeEstoque.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.ToggleButton;

import javafx.scene.image.ImageView;

import javafx.scene.control.PasswordField;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class EditFuncionarioController implements Initializable{
	@FXML
	private TextField nomeTextField;
	@FXML
	private TextField codigoTextField;
	@FXML
	private TextField usuarioTextField;
	@FXML
	private TextField emailTextField;
	@FXML
	private PasswordField senhaPasswordField;
	@FXML
	private PasswordField confirmarSenhaPasswordField;
	@FXML
	private Button cancelarButton;
	@FXML
	private Button okButton;
	@FXML
	private TableView funcionarioTable;
	@FXML
	private TableColumn codigoColumn;
	@FXML
	private TableColumn nomeColumn;
	@FXML
	private TableColumn usuarioColumn;
	@FXML
	private TableColumn emailColumn;
	@FXML
	private Button helpButton;
	@FXML
	private ToggleButton cadastrarToggleButton;
	@FXML
	private ToggleButton alterarToggleButton;
	@FXML
	private ImageView excluirButton;
	@FXML
	private TextField pesquisaTextField;
	@FXML
	private ToggleButton pesquisaPorNomeToggleButton;
	@FXML
	private ToggleButton pesquisaPorCodigoToggleButton;

	@Override
	public void initialize(URL location, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}
}

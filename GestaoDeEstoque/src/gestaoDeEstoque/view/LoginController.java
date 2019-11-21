package gestaoDeEstoque.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.Label;

import javafx.scene.control.PasswordField;

public class LoginController implements Initializable{
	@FXML
	private TextField usuarioTextField;
	@FXML
	private PasswordField senhaPasswordField;
	@FXML
	private Button acessarButton;
	@FXML
	private Label esqueceuSenhaLabel;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}

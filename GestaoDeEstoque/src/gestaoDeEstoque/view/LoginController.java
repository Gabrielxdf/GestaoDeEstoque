package gestaoDeEstoque.view;

import java.net.URL;
import java.util.ResourceBundle;

import gestaoDeEstoque.MainApp;
import gestaoDeEstoque.model.pessoa.Funcionarios;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
	@FXML
	private Label messageLabel;
	
	private MainApp mainApp;
	private Stage dialogStage;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		acessarButton.setOnKeyPressed((KeyEvent e)->{
			if(e.getCode() == KeyCode.ENTER) {
				login();
			}
		});
		
	}
	@FXML
	private void login() {
		for(Funcionarios x: mainApp.getFuncionariosData()) {
			if(usuarioTextField.getText().equals(x.getUsuario().get())) {
				if(senhaPasswordField.getText().equals(x.getSenha().get())) {
					mainApp.initRootLayout();
					this.dialogStage.close();
				}else {
					messageLabel.setText("Senha inválida!");
				}
			}else {
				messageLabel.setText("Usuário inválido!");
			}
		}
		
	}
	/**
	 * Uma instância do MainApp para o Controller poder usar os métodos do
	 * MainApp
	 * 
	 * @param {@link LoginController#mainApp} uma referência à
	 *               Aplicação principal.
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	/**
	 * Define o Stage para este dialogo.
	 * 
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

}

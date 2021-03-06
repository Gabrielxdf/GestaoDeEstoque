package gestaoDeEstoque.view;

import java.net.URL;
import java.util.ResourceBundle;
import gestaoDeEstoque.model.pessoa.Funcionarios;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * Controlador da view ViewFuncionario
 * 
 * @author Gabriel Henrique
 *
 */
public class ViewFuncionarioController implements Initializable {

	@FXML
	private TextField nomeTextField;

	@FXML
	private TextField codigoTextField;

	@FXML
	private TextField usuarioTextField;

	@FXML
	private TextField emailTextField;

	/**
	 * Inicializa o controlador ViewFuncionarioController.
	 * 
	 * @param URL            location
	 * @param ResourceBundle resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	/**
	 * Seta o Funcionário dessa view.
	 * 
	 * @param funcionario
	 */
	public void setFuncionario(Funcionarios funcionario) {
		nomeTextField.setText(funcionario.getNome());
		codigoTextField.setText(funcionario.getCodigo());
		emailTextField.setText(funcionario.getEmailProperty().get());
		usuarioTextField.setText(funcionario.getUsuario().get());
	}
}

package gestaoDeEstoque.view;

import java.net.URL;
import java.util.ResourceBundle;
import gestaoDeEstoque.model.pessoa.Cliente;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * Controlador da view ViewCliente
 * 
 * @author Gabriel Henrique
 *
 */
public class ViewClienteController implements Initializable {

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
	private TextField celularTextField;

	@FXML
	private TextField residencialTextField;

	@FXML
	private TextField cepTextField;

	@FXML
	private TextField enderecoTextField;

	@FXML
	private TextField cidadeTextField;

	@FXML
	private TextField bairroTextField;

	@FXML
	private TextField estadoTextField;

	/**
	 * Inicializa o controlador ViewClienteController.
	 * 
	 * @param URL            location
	 * @param ResourceBundle resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	/**
	 * Seta o Cliente dessa view.
	 * 
	 * @param cliente
	 */
	public void setCliente(Cliente cliente) {
		nomeTextField.setText(cliente.getNome());
		codigoTextField.setText(cliente.getCodigo());
		cpfTextField.setText(cliente.getCpfProperty().get());
		dataTextField.setText(cliente.getDataNascimentoStringProperty().get());
		emailTextField.setText(cliente.getEmailProperty().get());
		celularTextField.setText(cliente.getTelefone().getCelularProperty().get());
		residencialTextField.setText(cliente.getTelefone().getResidencialProperty().get());
		cepTextField.setText(cliente.getEndereco().getCepProperty().get());
		enderecoTextField.setText(cliente.getEndereco().getEnderecoProperty().get());
		bairroTextField.setText(cliente.getEndereco().getBairroProperty().get());
		cidadeTextField.setText(cliente.getEndereco().getCidadeProperty().get());
		estadoTextField.setText(cliente.getEndereco().getEstadoProperty().get());
	}

}

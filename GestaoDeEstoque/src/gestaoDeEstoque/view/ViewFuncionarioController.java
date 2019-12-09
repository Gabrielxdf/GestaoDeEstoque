package gestaoDeEstoque.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class ViewFuncionarioController implements Initializable{

    @FXML
    private TextField nomeTextField;

    @FXML
    private TextField codigoTextField;

    @FXML
    private TextField usuarioTextField;

    @FXML
    private TextField emailTextField;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}

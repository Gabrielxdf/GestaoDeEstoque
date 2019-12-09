package gestaoDeEstoque.view;

import java.net.URL;
import java.util.ResourceBundle;

import gestaoDeEstoque.model.estoque.Fornecedor;
import gestaoDeEstoque.model.estoque.Grupos;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ViewProdutoController implements Initializable{

    @FXML
    private TextField nomeTextField;

    @FXML
    private TextField codigoTextField;

    @FXML
    private TextField valorTextField;

    @FXML
    private TextField codigoBarrasTextField;

    @FXML
    private TextField minimoTextField;

    @FXML
    private TextField idealTextField;

    @FXML
    private TextField descricaoTextField;

    @FXML
    private ComboBox<Grupos> grupoComboBox;

    @FXML
    private ComboBox<String> classificacaoComboBox;

    @FXML
    private ComboBox<Fornecedor> fornecedorComboBox;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}

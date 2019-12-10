package gestaoDeEstoque.view;

import java.net.URL;
import java.util.ResourceBundle;

import gestaoDeEstoque.model.estoque.Produtos;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

public class ViewFornecedorController implements Initializable{

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
    private TextField cepTextField;

    @FXML
    private TextField pesquisaTextField;

    @FXML
    private TextField enderecoTextField;

    @FXML
    private TextField cidadeTextField;

    @FXML
    private TextField bairroTextField;

    @FXML
    private TextField estadoTextField;

    @FXML
    private TableView<Produtos> produtosTable;

    @FXML
    private TableColumn<Produtos, String> codigoColumn;

    @FXML
    private TableColumn<Produtos, String>nomeColumn;

    @FXML
    private TableColumn<Produtos, String>valorColumn;

    @FXML
    private TableColumn<Produtos, String> codigoBarrasColumn;

    @FXML
    private TableColumn<Produtos, String> minimoColumn;

    @FXML
    private TableColumn<Produtos, String> idealColumn;

    @FXML
    private TableColumn<Produtos, String> atualColumn;

    @FXML
    private TableColumn<Produtos, String>grupoColumn;

    @FXML
    private TableColumn<Produtos, String> classificacaoColumn;

    @FXML
    private ToggleButton pesquisaPorNomeToggleButton;

    @FXML
    private ToggleButton pesquisaPorCodigoToggleButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}


}

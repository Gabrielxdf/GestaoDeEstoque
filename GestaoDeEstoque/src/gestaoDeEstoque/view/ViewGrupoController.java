package gestaoDeEstoque.view;

import java.net.URL;
import java.util.ResourceBundle;

import gestaoDeEstoque.model.estoque.Produtos;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

public class ViewGrupoController implements Initializable{

	    @FXML
	    private TextField nomeTextField;

	    @FXML
	    private Button helpButton;

	    @FXML
	    private TextField pesquisaTextField;

	    @FXML
	    private TableView<Produtos> produtosTable;

	    @FXML
	    private TableColumn<Produtos, String> codigoColumn;

	    @FXML
	    private TableColumn<Produtos, String> nomeColumn;

	    @FXML
	    private TableColumn<Produtos, String> valorColumn;

	    @FXML
	    private TableColumn<Produtos, String> codigoBarrasColumn;

	    @FXML
	    private TableColumn<Produtos, String> minimoColumn;

	    @FXML
	    private TableColumn<Produtos, String> idealColumn;

	    @FXML
	    private TableColumn<Produtos, String> atualColumn;

	    @FXML
	    private TableColumn<Produtos, String> fornecedorColumn;

	    @FXML
	    private TableColumn<Produtos, String> classificacaoColumn;

	    @FXML
	    private TextField quantidadeTextField;

	    @FXML
	    private TextField valorTextField;

	    @FXML
	    private ToggleButton pesquisaPorNomeToggleButton;

	    @FXML
	    private ToggleButton pesquisaPorCodigoToggleButton;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}

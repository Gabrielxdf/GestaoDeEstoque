package gestaoDeEstoque.view;

import java.net.URL;
import java.util.ResourceBundle;

import gestaoDeEstoque.MainApp;
import gestaoDeEstoque.model.estoque.Grupos;
import gestaoDeEstoque.model.estoque.Produtos;
import gestaoDeEstoque.util.Estados;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class EditProdutosController implements Initializable{
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
	private TextField codigoFornecedorTextField;
	@FXML
	private TextField descricaoTextField;
	@FXML
	private Button okButton;
	@FXML
	private Button cancelarButton;
	@FXML
	private Button helpButton;
	@FXML
	private TableView produtosTable;
	@FXML
	private TableColumn codigoColumn;
	@FXML
	private TableColumn nomeColumn;
	@FXML
	private TableColumn valorColumn;
	@FXML
	private TableColumn codigoBarrasColumn;
	@FXML
	private TableColumn minimoColumn;
	@FXML
	private TableColumn idealColumn;
	@FXML
	private TableColumn atualColumn;
	@FXML
	private TableColumn codigoFornecedorColumn;
	@FXML
	private TableColumn classificacaoColumn;
	@FXML
	private ToggleButton cadastrarToggleButton;
	@FXML
	private ToggleButton alterarToggleButton;
	@FXML
	private Button excluirButton;
	@FXML
	private ComboBox<Grupos> grupoComboBox;
	@FXML
	private ComboBox<String> classificacaoComboBox;
	@FXML
	private TextField pesquisaTextField;
	@FXML
	private ToggleButton pesquisaPorNomeToggleButton;
	@FXML
	private ToggleButton pesquisaPorCodigoToggleButton;
	
	private MainApp mainApp;
	private Stage dialogStage;
	private Produtos produto;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/*for (Grupos x : mainApp.getGruposData()){
			grupoComboBox.getItems().add(x);
    	}*/
		
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	public void setStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	public void setProduto(Produtos produto) {
		this.produto = produto;
	}
}

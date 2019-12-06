package gestaoDeEstoque.view;

import java.net.URL;
import java.util.ResourceBundle;
import gestaoDeEstoque.MainApp;
import gestaoDeEstoque.model.estoque.Fornecedor;
import gestaoDeEstoque.model.estoque.Grupos;
import gestaoDeEstoque.model.estoque.Produtos;
import gestaoDeEstoque.util.AlertUtil;
import gestaoDeEstoque.util.Estados;
import gestaoDeEstoque.util.Limpa;
import gestaoDeEstoque.util.pesquisa.Pesquisa;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

public class EditProdutosController implements Initializable {
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
	private Button okButton;
	@FXML
	private Button cancelarButton;
	@FXML
	private Button helpButton;
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
	@FXML
	private ComboBox <Fornecedor> fornecedorComboBox;
	
	private MainApp mainApp;
	private Stage dialogStage;

	/**
	 * Inicializa o controlador EditProdutosController.
	 * 
	 * @param URL            location
	 * @param ResourceBundle resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// inicializa as colunas da tabela
				codigoColumn.setCellValueFactory(cellData -> cellData.getValue().getCodigoProperty());
				nomeColumn.setCellValueFactory(cellData -> cellData.getValue().getNomeProperty());
				valorColumn.setCellValueFactory(cellData -> cellData.getValue().getValor());
				codigoBarrasColumn.setCellValueFactory(cellData -> cellData.getValue().getCodigoBarras());
				minimoColumn.setCellValueFactory(cellData -> cellData.getValue().getEstoqueMinimo());
				idealColumn.setCellValueFactory(cellData -> cellData.getValue().getEstoqueIdeal());
				atualColumn.setCellValueFactory(cellData -> cellData.getValue().getEstoqueAtual());
				fornecedorColumn.setCellValueFactory(cellData -> cellData.getValue().getFornecedor().getFornecedorProperty());
				classificacaoColumn.setCellValueFactory(cellData -> cellData.getValue().getClassificacao());
				
				showProdutos(null);

				produtosTable.getSelectionModel().selectedItemProperty()
						.addListener((observable, oldValue, newValue) -> showProdutos(newValue));

	}
	
	/**
	 * Preenche todos os campos de texto com o os dados do Produto selecionado.
	 * Se o Produto especificado for null, limpa todos os campos de texto.
	 * 
	 * @param produto ou null
	 */
	private void showProdutos(Produtos produto) {
		if (produto != null) {
			nomeTextField.setText(produto.getNome());
			codigoTextField.setText(produto.getCodigo());
			valorTextField.setText(produto.getValor().get());
			codigoBarrasTextField.setText(produto.getCodigoBarras().get());
			minimoTextField.setText(produto.getEstoqueMinimo().get());
			idealTextField.setText(produto.getEstoqueIdeal().get());
			descricaoTextField.setText(produto.getDescricao().get());
			grupoComboBox.setPromptText(produto.getGrupo().getNome());
			fornecedorComboBox.setPromptText(produto.getFornecedor().getNome());
			classificacaoComboBox.setPromptText(produto.getClassificacao().get());
			
		} else {
			Limpa.limpaTextField(nomeTextField, codigoTextField, valorTextField, codigoBarrasTextField,
					minimoTextField, idealTextField, descricaoTextField);
			grupoComboBox.setPromptText("");
			fornecedorComboBox.setPromptText("");
			classificacaoComboBox.setPromptText("");
		}
	}
	
	/**
	 * Carrega a ComboBox dos Grupos
	 */
	private void carregarGrupoComboBox() {
		grupoComboBox.setItems(mainApp.getGruposData());
	}
	
	/**
	 * Carrega a ComboBox dos Fornecedores
	 */
	private void carregarFornecedoresComboBox() {
		fornecedorComboBox.setItems(mainApp.getFornecedoresData());
	}

	/**
	 * Carrega a ComboBox das Classificações
	 */
	private void carregarClassificacaoComboBox() {
		classificacaoComboBox.getItems().add("A");
		classificacaoComboBox.getItems().add("B");
		classificacaoComboBox.getItems().add("C");
	}

	/**
	 * Cria um Alert com as informações de ajuda da tela.
	 */
	@FXML
	private void helpButton() {
		String content = "CAMPO NOME DO PRODUTO - Nome do Produto.\n";
		content += "\n";
		content += "CAMPO NOME DO GRUPO - Nome do Grupo.\n";
		content += "\n";
		content += "CAMPO CÓDIGO - Código do Produto.\n";
		content += "\n";
		content += "CAMPO VALOR - Valor do Produto.\n";
		content += "\n";
		content += "CAMPO CÓD. BARRAS - Código de Barras do Produto.\n";
		content += "\n";
		content += "CAMPO ESTOQUE MÍNIMO - Estoque mínimo do Produto.\n";
		content += "\n";
		content += "CAMPO ESTOQUE IDEAL - Estoque ideal do Produto.\n";
		content += "\n";
		content += "CAMPO FORNECEDOR - Nome do Fornecedor.\n";
		content += "\n";
		content += "CAMPO CLASSIFICAÇÃO - Classificação do Produto.\n";
		content += "\n";
		content += "CAMPO DESCRIÇÃO - Descrição do Produto.\n";
		AlertUtil.criaUmAlert("Ajuda", "Ajuda - Fornecedores", content, "INFORMATION");
	}

	/**
	 * Método de pesquisar na tabela pelo nome, ou código do Fornecedor, atualizando a tabela apenas
	 * com os Fornecedor que contém a String passada no campo de texto no nome ou código.
	 */
	@FXML
	private void pesquisar() {
		ObservableList<Produtos> pesquisa;
			if (pesquisaPorNomeToggleButton.isSelected()) {
				pesquisa = Pesquisa.pesquisarPorNome(mainApp.getProdutosData(), pesquisaTextField.getText());
				produtosTable.setItems(pesquisa);
			}
			if (pesquisaPorCodigoToggleButton.isSelected()) {
				pesquisa = Pesquisa.pesquisarPorCodigo(mainApp.getProdutosData(), pesquisaTextField.getText());
				produtosTable.setItems(pesquisa);
			}
	}
	
	/**
	 * Uma instância do MainApp para o Controller poder usar os métodos do
	 * MainApp
	 * 
	 * @param {@link EditProdutosController#mainApp} uma referência à
	 *               Aplicação principal.
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		produtosTable.setItems(mainApp.getProdutosData());
		carregarGrupoComboBox();
		carregarFornecedoresComboBox();
		carregarClassificacaoComboBox();
	}

	/**
	 * Define o Stage para este dialogo.
	 * 
	 * @param dialogStage
	 */
	public void setStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

}

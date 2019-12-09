package gestaoDeEstoque.view;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.parg.viacep.ViaCEP;
import gestaoDeEstoque.MainApp;
import gestaoDeEstoque.model.estoque.Fornecedor;
import gestaoDeEstoque.util.AlertUtil;
import gestaoDeEstoque.util.Estados;
import gestaoDeEstoque.util.Limpa;
import gestaoDeEstoque.util.Telefones;
import gestaoDeEstoque.util.Verifica;
import gestaoDeEstoque.util.factory.FactoryFornecedores;
import gestaoDeEstoque.util.pesquisa.Pesquisa;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

/**
 * Controlador da view EditFornecedor
 * 
 * @author Gabriel Henrique
 *
 */
public class EditFornecedorController implements Initializable {
	@FXML
	private Tab principal;
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
	private TableView<Fornecedor> fornecedorTable;
	@FXML
	private TableColumn<Fornecedor, String> codigoColumn;
	@FXML
	private TableColumn<Fornecedor, String> nomeColumn;
	@FXML
	private TableColumn<Fornecedor, String> cnpjColumn;
	@FXML
	private TableColumn<Fornecedor, String> razaoColumn;
	@FXML
	private TableColumn<Fornecedor, String> emailColumn;
	@FXML
	private TableColumn<Fornecedor, String> telefonesColumn;
	@FXML
	private TableColumn<Fornecedor, String> tel1Column;
	@FXML
	private TableColumn<Fornecedor, String> tel2Column;
	@FXML
	private ToggleButton pesquisaPorNomeToggleButton;
	@FXML
	private ToggleButton pesquisaPorCodigoToggleButton;
	@FXML
	private Tab endereco;
	@FXML
	private TextField cepTextField;
	@FXML
	private TextField enderecoTextField;
	@FXML
	private ComboBox<Estados> estadosComboBox;
	@FXML
	private TextField bairroTextField;
	@FXML
	private TextField cidadeTextField;
	@FXML
	private TableView<Fornecedor> enderecoFornecedorTable;
	@FXML
	private TableColumn<Fornecedor, String> enderecoCodigoColumn;
	@FXML
	private TableColumn<Fornecedor, String> enderecoNomeColumn;
	@FXML
	private TableColumn<Fornecedor, String> cepColumn;
	@FXML
	private TableColumn<Fornecedor, String> enderecoColumn;
	@FXML
	private TableColumn<Fornecedor, String> bairroColumn;
	@FXML
	private TableColumn<Fornecedor, String> cidadeColumn;
	@FXML
	private TableColumn<Fornecedor, String> estadoColumn;
	@FXML
	private TextField enderecoPesquisaTextField;
	@FXML
	private ToggleButton enderecoPesquisaPorNomeToggleButton;
	@FXML
	private ToggleButton enderecoPesquisaPorCodigoToggleButton;
	@FXML
	private Button cancelarButton;
	@FXML
	private Button okButton;
	@FXML
	private Button helpButton;
	@FXML
	private ToggleButton cadastrarToggleButton;
	@FXML
	private ToggleButton alterarToggleButton;
	@FXML
	private Button excluirButton;
	@FXML
	private Label cepLabel;
	@FXML
	private TextField pesquisaTextField;

	private MainApp mainApp;
	private Stage dialogStage;

	/**
	 * Inicializa o controlador EditFornecedorController.
	 * 
	 * @param URL            location
	 * @param ResourceBundle resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarEstadosComboBox();

		// inicializa as colunas da tabela
		codigoColumn.setCellValueFactory(cellData -> cellData.getValue().getCodigoProperty());
		nomeColumn.setCellValueFactory(cellData -> cellData.getValue().getFornecedorProperty());
		cnpjColumn.setCellValueFactory(cellData -> cellData.getValue().getCnpjProperty());
		razaoColumn.setCellValueFactory(cellData -> cellData.getValue().getRazaoSocialProperty());
		emailColumn.setCellValueFactory(cellData -> cellData.getValue().getEmailProperty());
		tel1Column.setCellValueFactory(
				cellData -> cellData.getValue().getTelefone().getTelefonesFornecedoresProperty().get(0));
		tel2Column.setCellValueFactory(
				cellData -> cellData.getValue().getTelefone().getTelefonesFornecedoresProperty().get(1));
		enderecoCodigoColumn.setCellValueFactory(cellData -> cellData.getValue().getCodigoProperty());
		enderecoNomeColumn.setCellValueFactory(cellData -> cellData.getValue().getFornecedorProperty());
		cepColumn.setCellValueFactory(cellData -> cellData.getValue().getEndereco().getCepProperty());
		enderecoColumn.setCellValueFactory(cellData -> cellData.getValue().getEndereco().getEnderecoProperty());
		bairroColumn.setCellValueFactory(cellData -> cellData.getValue().getEndereco().getBairroProperty());
		cidadeColumn.setCellValueFactory(cellData -> cellData.getValue().getEndereco().getCidadeProperty());
		estadoColumn.setCellValueFactory(cellData -> cellData.getValue().getEndereco().getEstadoProperty());

		showFornecedores(null);

		fornecedorTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showFornecedores(newValue));
		enderecoFornecedorTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showFornecedores(newValue));

	}

	/**
	 * Preenche todos os campos de texto com o os dados do Fornecedor selecionado.
	 * Se o Fornecedor especificado for null, limpa todos os campos de texto.
	 * 
	 * @param fornecedor ou null
	 */
	private void showFornecedores(Fornecedor fornecedor) {
		if (fornecedor != null) {
			fornecedorTextField.setText(fornecedor.getFornecedorProperty().get());
			cnpjTextField.setText(fornecedor.getCnpjProperty().get());
			codigoTextField.setText(fornecedor.getCodigoProperty().get());
			razaoTextField.setText(fornecedor.getRazaoSocialProperty().get());
			emailTextField.setText(fornecedor.getEmailProperty().get());
			tel1TextField.setText(fornecedor.getTelefone().getTelefonesFornecedoresProperty().get(0).get());
			tel2TextField.setText(fornecedor.getTelefone().getTelefonesFornecedoresProperty().get(1).get());
			cepTextField.setText(fornecedor.getEndereco().getCepProperty().get());
			enderecoTextField.setText(fornecedor.getEndereco().getEnderecoProperty().get());
			bairroTextField.setText(fornecedor.getEndereco().getBairroProperty().get());
			cidadeTextField.setText(fornecedor.getEndereco().getCidadeProperty().get());
		} else {
			Limpa.limpaTextField(fornecedorTextField, cnpjTextField, codigoTextField, razaoTextField, emailTextField,
					tel1TextField, tel2TextField, cepTextField, enderecoTextField, bairroTextField, cidadeTextField);
			Limpa.limpaComboBox(estadosComboBox);
		}
	}

	/**
	 * Carrega a ComboBox dos Estados
	 */
	private void carregarEstadosComboBox() {
		for (Estados x : Estados.values()) {
			estadosComboBox.getItems().add(x);
		}

	}

	/**
	 * Chamado quando o usuário clica em "Ok". De acordo com o que ele está
	 * selecionando no ToggleButton, o método adiciona um novo Fornecedor, ou edita
	 * um Fornecedor selecionado.
	 */
	@FXML
	private void handleOk() {
		if (cadastrarToggleButton.isSelected()) {
			String errorMessage = "";
			if (!Verifica.validaCnpj(cnpjTextField.getText())) {
				errorMessage += "CNPJ Inválido!\n";
			}
			if (!verificaCep()) {
				errorMessage += "CEP não encontrado ou inválido.\n";
			}
			if (errorMessage.length() == 0) {
				adicionaOuAltera("Dados inválidos", "Alguns dados obrigatórios estão inválidos e/ou vazios.",
						errorMessage, "ERROR", -1);
			} else {
				AlertUtil.criaUmAlert("Dados inválidos", "Alguns dados obrigatórios estão inválidos e/ou vazios.",
						errorMessage, "ERROR");
			}
		}
		if (alterarToggleButton.isSelected()) {
			int selectedIndex;

			if (principal.isSelected()) {
				selectedIndex = fornecedorTable.getSelectionModel().getSelectedIndex();
			} else {
				selectedIndex = enderecoFornecedorTable.getSelectionModel().getSelectedIndex();
			}

			if (selectedIndex >= 0) {
				if (AlertUtil
						.criaUmAlert("Confirmação", "Você deseja mesmo fazer essa alteração ?",
								"Alteração no Fornecedor: " + "'"
										+ mainApp.getFornecedoresData().get(selectedIndex).getNome() + "'",
								"CONFIRMATION")) {
					adicionaOuAltera("Dados inválidos", "Alguns dados obrigatórios estão inválidos e/ou vazios.",
							"", "ERROR", selectedIndex);
				}
			} else {
				AlertUtil.criaUmAlert("Nenhuma seleção", "Nenhum Fornecedor Selecionado",
						"Por favor, Selecione um Fornecedor na tabela.", "WARNING");
			}
		}
	}

	/**
	 * Método para deletar algum item da Tabela por meio do botão "Excluir".
	 */
	@FXML
	private void handleDelete() {
		int selectedIndex;

		if (principal.isSelected()) {
			selectedIndex = fornecedorTable.getSelectionModel().getSelectedIndex();
		} else {
			selectedIndex = enderecoFornecedorTable.getSelectionModel().getSelectedIndex();
		}

		if (selectedIndex >= 0) {
			if (AlertUtil.criaUmAlert(
					"Confirmação", "Você deseja mesmo fazer essa exclusão ?", "Excluir o Fornecedor: " + "'"
							+ mainApp.getFornecedoresData().get(selectedIndex).getNome() + "'" + " ?",
					"CONFIRMATION")) {
				fornecedorTable.getItems().remove(selectedIndex);
			}
		} else {
			AlertUtil.criaUmAlert("Nenhuma seleção", "Nenhum Fornecedor Selecionado",
					"Por favor, Selecione um Fornecedor na tabela.", "WARNING");
		}
	}

	/**
	 * Chamado quando o usuário clica em "Cancelar".
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	/**
	 * Adiciona um novo Fornecedor na Tabela ou altera um existente.
	 * 
	 * @param title   o título para criar um Alert
	 * @param header  o header para criar um Alert
	 * @param content o content para criar um Alert
	 * @param type    o type para criar um Alert
	 */
	private void adicionaOuAltera(String title, String header, String content, String type, int index) {
		Fornecedor tempFornecedor = FactoryFornecedores.getFornecedor(fornecedorTextField.getText(),
				cnpjTextField.getText(), codigoTextField.getText(), emailTextField.getText(),
				new Telefones(tel1TextField.getText(), tel2TextField.getText()), razaoTextField.getText(),
				cepTextField.getText(), enderecoTextField.getText(), cidadeTextField.getText(), bairroTextField.getText(),
				estadosComboBox);
		if (tempFornecedor != null) {
			if (index >= 0) {
				mainApp.getFornecedoresData().set(index, tempFornecedor);
				fornecedorTable.setItems(mainApp.getFornecedoresData());
				Limpa.limpaTextField(fornecedorTextField, cnpjTextField, codigoTextField, razaoTextField,
						emailTextField, tel1TextField, tel2TextField, cepTextField, enderecoTextField, bairroTextField,
						cidadeTextField);
				Limpa.limpaComboBox(estadosComboBox);
			} else {
				mainApp.getFornecedoresData().add(tempFornecedor);
				fornecedorTable.setItems(mainApp.getFornecedoresData());
				Limpa.limpaTextField(fornecedorTextField, cnpjTextField, codigoTextField, razaoTextField,
						emailTextField, tel1TextField, tel2TextField, cepTextField, enderecoTextField, bairroTextField,
						cidadeTextField);
				Limpa.limpaComboBox(estadosComboBox);
			}
		} else {
			String errorMessage = content + "Alguns dados obrigatórios estão inválidos e/ou vazios.";
			AlertUtil.criaUmAlert(title, header, errorMessage, type);
		}
	}
	
	/**
	 * Verifica o CEP passado chamando o método {@link Verifica#validaCep}, e faz um Auto-Complete nos campos relevantes.
	 * @API <a href="https://viacep.com.br">ViaCep</a>
	 * @return true caso o CEP seja validado, false caso contrário.
	 */
	@FXML
	private boolean verificaCep() {
		if (cepTextField.getText().length() >= 8) {
			Verifica cep = new Verifica();
			cep.validaCep(cepTextField.getText());
			ViaCEP cepObjeto = cep.getCep();
			if (cepObjeto != null) {
				enderecoTextField.setText(cepObjeto.getLogradouro() + " " + cepObjeto.getComplemento());
				bairroTextField.setText(cepObjeto.getBairro());
				cidadeTextField.setText(cepObjeto.getLocalidade());
				cepLabel.setText("");
				return true;
			} else {
				cepLabel.setText("CEP não encontrado ou inválido.");
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Cria um Alert com as informações de ajuda da tela.
	 */
	@FXML
	private void helpButton() {
		String content = "CAMPO FORNECEDOR - Nome/Título do Fornecedor.\n";
		content += "\n";
		content += "CAMPO CNPJ - CNPJ do Fornecedor.\n";
		content += "\n";
		content += "CAMPO CÓDIGO - Código do Fornecedor.\n";
		content += "\n";
		content += "CAMPO RAZÃO SOCIAL - Razão Social do Fornecedor.\n";
		content += "\n";
		content += "CAMPO E-MAIL - E-mail de contato do Fornecedor.\n";
		content += "\n";
		content += "CAMPO TELEFONE 1 - Primeiro telefone de contato do Fornecedor.\n";
		content += "\n";
		content += "CAMPO TELEFONE 2 - Segundo telefone de contato do Fornecedor.\n";
		content += "\n";
		content += "CAMPO CEP - CEP do Fornecedor.\n";
		content += "\n";
		content += "CAMPO ENDEREÇO - Lougradouro e Complemento do Fornecedor.\n";
		content += "\n";
		content += "CAMPO BAIRRO - Bairro do Fornecedor.\n";
		content += "\n";
		content += "CAMPO CIDADE - Cidade do Fornecedor.\n";
		content += "\n";
		content += "CAMPO ESTADO - Estado do Fornecedor.\n";
		content += "\n";
		AlertUtil.criaUmAlert("Ajuda", "Ajuda - Fornecedores", content, "INFORMATION");
	}

	/**
	 * Método de pesquisar na tabela pelo nome, ou código do Fornecedor, atualizando
	 * a tabela apenas com os Fornecedor que contém a String passada no campo de
	 * texto no nome ou código.
	 */
	@FXML
	private void pesquisar() {
		ObservableList<Fornecedor> pesquisa;
		if (principal.isSelected()) {
			if (pesquisaPorNomeToggleButton.isSelected()) {
				pesquisa = Pesquisa.pesquisarPorNome(mainApp.getFornecedoresData(), pesquisaTextField.getText());
				fornecedorTable.setItems(pesquisa);
			}
			if (pesquisaPorCodigoToggleButton.isSelected()) {
				pesquisa = Pesquisa.pesquisarPorCodigo(mainApp.getFornecedoresData(), pesquisaTextField.getText());
				fornecedorTable.setItems(pesquisa);
			}

		}
		if (endereco.isSelected()) {
			if (pesquisaPorNomeToggleButton.isSelected()) {
				pesquisa = Pesquisa.pesquisarPorNome(mainApp.getFornecedoresData(),
						enderecoPesquisaTextField.getText());
				enderecoFornecedorTable.setItems(pesquisa);
			}
			if (pesquisaPorCodigoToggleButton.isSelected()) {
				pesquisa = Pesquisa.pesquisarPorCodigo(mainApp.getFornecedoresData(),
						enderecoPesquisaTextField.getText());
				enderecoFornecedorTable.setItems(pesquisa);
			}
		}
	}

	/**
	 * Define o Stage para este dialogo.
	 * 
	 * @param dialogStage
	 */
	public void setStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	/**
	 * Uma instância do MainApp para o Controller poder usar os métodos do MainApp
	 * 
	 * @param {@link EditFornecedorController#mainApp} uma referência à Aplicação
	 *               principal.
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		fornecedorTable.setItems(mainApp.getFornecedoresData());
		enderecoFornecedorTable.setItems(mainApp.getFornecedoresData());
	}
}

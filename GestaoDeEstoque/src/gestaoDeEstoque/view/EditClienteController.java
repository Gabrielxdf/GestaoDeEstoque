package gestaoDeEstoque.view;

import java.net.URL;
import java.util.ResourceBundle;
import br.com.parg.viacep.ViaCEP;
import gestaoDeEstoque.MainApp;
import gestaoDeEstoque.model.pessoa.Cliente;
import gestaoDeEstoque.util.AlertUtil;
import gestaoDeEstoque.util.DateUtil;
import gestaoDeEstoque.util.Estados;
import gestaoDeEstoque.util.Limpa;
import gestaoDeEstoque.util.Telefones;
import gestaoDeEstoque.util.Verifica;
import gestaoDeEstoque.util.factory.FactoryClientes;
import gestaoDeEstoque.util.pesquisa.Pesquisa;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

public class EditClienteController implements Initializable {
	@FXML
	private Tab principal;
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
	private TableView<Cliente> clienteTable;
	@FXML
	private TableColumn<Cliente, String> codigoColumn;
	@FXML
	private TableColumn<Cliente, String> nomeColumn;
	@FXML
	private TableColumn<Cliente, String> cpfColumn;
	@FXML
	private TableColumn<Cliente, String> dataColumn;
	@FXML
	private TableColumn<Cliente, String> emailColumn;
	@FXML
	private TableColumn<Cliente, String> telefonesColumn;
	@FXML
	private TableColumn<Cliente, String> celularColumn;
	@FXML
	private TableColumn<Cliente, String> residencialColumn;
	@FXML
	private TextField pesquisaTextField;
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
	private TableView<Cliente> enderecoClienteTable;
	@FXML
	private TableColumn<Cliente, String> enderecoCodigoColumn;
	@FXML
	private TableColumn<Cliente, String> enderecoNomeColumn;
	@FXML
	private TableColumn<Cliente, String> cepColumn;
	@FXML
	private TableColumn<Cliente, String> enderecoColumn;
	@FXML
	private TableColumn<Cliente, String> bairroColumn;
	@FXML
	private TableColumn<Cliente, String> cidadeColumn;
	@FXML
	private TableColumn<Cliente, String> estadoColumn;
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

	private MainApp mainApp;
	private Stage dialogStage;
	
	/**
	 * Inicializa o controlador EditClienteController.
	 * 
	 * @param URL            location
	 * @param ResourceBundle resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarEstadosComboBox();
		//inicializa as colunas da tabela
		codigoColumn.setCellValueFactory(cellData -> cellData.getValue().getCodigoProperty());
		nomeColumn.setCellValueFactory(cellData -> cellData.getValue().getNomeProperty());
		cpfColumn.setCellValueFactory(cellData -> cellData.getValue().getCpfProperty());
		dataColumn.setCellValueFactory(cellData -> cellData.getValue().getDataNascimentoStringProperty());
		emailColumn.setCellValueFactory(cellData -> cellData.getValue().getEmailProperty());
		celularColumn.setCellValueFactory(cellData -> cellData.getValue().getTelefone().getCelularProperty());
		residencialColumn.setCellValueFactory(cellData -> cellData.getValue().getTelefone().getResidencialProperty());
		enderecoCodigoColumn.setCellValueFactory(cellData -> cellData.getValue().getCodigoProperty());
		enderecoNomeColumn.setCellValueFactory(cellData -> cellData.getValue().getNomeProperty());
		cepColumn.setCellValueFactory(cellData -> cellData.getValue().getEndereco().getCepProperty());
		enderecoColumn.setCellValueFactory(cellData -> cellData.getValue().getEndereco().getEnderecoProperty());
		bairroColumn.setCellValueFactory(cellData -> cellData.getValue().getEndereco().getBairroProperty());
		cidadeColumn.setCellValueFactory(cellData -> cellData.getValue().getEndereco().getCidadeProperty());
		estadoColumn.setCellValueFactory(cellData -> cellData.getValue().getEndereco().getEstadoProperty());

		showClientes(null);

		clienteTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showClientes(newValue));
		enderecoClienteTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showClientes(newValue));
	}

	/**
	 * Preenche todos os campos de texto com o os dados do Cliente selecionado. Se o
	 * Cliente especificado for null, limpa todos os campos de texto.
	 * 
	 * @param fornecedor ou null
	 */
	private void showClientes(Cliente cliente) {
		if (cliente != null) {
			nomeTextField.setText(cliente.getNome());
			cpfTextField.setText(cliente.getCpfProperty().get());
			codigoTextField.setText(cliente.getCodigo());
			dataTextField.setText(cliente.getDataNascimentoStringProperty().get());
			emailTextField.setText(cliente.getEmailProperty().get());
			celularTextField.setText(cliente.getTelefone().getCelularProperty().get());
			residencialTextField.setText(cliente.getTelefone().getResidencialProperty().get());
			cepTextField.setText(cliente.getEndereco().getCepProperty().get());
			enderecoTextField.setText(cliente.getEndereco().getEnderecoProperty().get());
			bairroTextField.setText(cliente.getEndereco().getBairroProperty().get());
			cidadeTextField.setText(cliente.getEndereco().getCidadeProperty().get());
		} else {
			Limpa.limpaTextField(nomeTextField, cpfTextField, codigoTextField, dataTextField, emailTextField,
					celularTextField, residencialTextField, cepTextField, enderecoTextField, bairroTextField,
					cidadeTextField);
			Limpa.limpaComboBox(estadosComboBox);
		}
	}
	
	/**
	 * Chamado quando o usuário clica em "Ok". De acordo com o que ele está
	 * selecionando no ToggleButton, o método adiciona um novo Cliente, ou edita
	 * um Cliente selecionado.
	 */
	@FXML
	private void handleOk() {
		if (cadastrarToggleButton.isSelected()) {
			String errorMessage = "";
			if (!Verifica.validaCpf(cpfTextField.getText())) {
				errorMessage += "CPF Inválido!\n";
			}
			if (!verificaCep()) {
				errorMessage += "CEP não encontrado ou inválido.\n";
			}
			if (dataTextField.getText() == null || dataTextField.getText().length() == 0) {
	            errorMessage += "Data inválida!\n";
	        } else {
	            if (!DateUtil.validDate(dataTextField.getText())) {
	                errorMessage += "Data inválida. Use o formato dd/mm/aaaa!\n";
	            }
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
				selectedIndex = clienteTable.getSelectionModel().getSelectedIndex();
			} else {
				selectedIndex = enderecoClienteTable.getSelectionModel().getSelectedIndex();
			}

			if (selectedIndex >= 0) {
				if (AlertUtil
						.criaUmAlert("Confirmação", "Você deseja mesmo fazer essa alteração ?",
								"Alteração no Cliente: " + "'"
										+ mainApp.getClientesData().get(selectedIndex).getNome() + "'",
								"CONFIRMATION")) {
					adicionaOuAltera("Dados inválidos", "Alguns dados obrigatórios estão inválidos e/ou vazios.",
							"", "ERROR", selectedIndex);
				}
			} else {
				AlertUtil.criaUmAlert("Nenhuma seleção", "Nenhum Cliente Selecionado",
						"Por favor, Selecione um Cliente na tabela.", "WARNING");
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
			selectedIndex = clienteTable.getSelectionModel().getSelectedIndex();
		} else {
			selectedIndex = enderecoClienteTable.getSelectionModel().getSelectedIndex();
		}

		if (selectedIndex >= 0) {
			if (AlertUtil.criaUmAlert(
					"Confirmação", "Você deseja mesmo fazer essa exclusão ?", "Excluir o Cliente: " + "'"
							+ mainApp.getClientesData().get(selectedIndex).getNome() + "'" + " ?",
					"CONFIRMATION")) {
				clienteTable.getItems().remove(selectedIndex);
			}
		} else {
			AlertUtil.criaUmAlert("Nenhuma seleção", "Nenhum Cliente Selecionado",
					"Por favor, Selecione um Cliente na tabela.", "WARNING");
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
	 * Adiciona um novo Cliente na Tabela ou altera um existente.
	 * 
	 * @param title   o título para criar um Alert
	 * @param header  o header para criar um Alert
	 * @param content o content para criar um Alert
	 * @param type    o type para criar um Alert
	 */
	private void adicionaOuAltera(String title, String header, String content, String type, int index) {
		Cliente tempCliente = FactoryClientes.getCliente(
				nomeTextField.getText(), cpfTextField.getText(), codigoTextField.getText(), emailTextField.getText(),
				new Telefones(new SimpleStringProperty(celularTextField.getText()), residencialTextField.getText()),
				dataTextField.getText(), cepTextField.getText(), enderecoTextField.getText(), cidadeTextField.getText(),
				bairroTextField.getText(), estadosComboBox);
		if (tempCliente != null) {
			if (index >= 0) {
				mainApp.getClientesData().set(index, tempCliente);
				clienteTable.setItems(mainApp.getClientesData());
				Limpa.limpaTextField(nomeTextField, cpfTextField, codigoTextField, dataTextField, emailTextField,
						celularTextField, residencialTextField, cepTextField, enderecoTextField, bairroTextField,
						cidadeTextField);
				Limpa.limpaComboBox(estadosComboBox);
			} else {
				mainApp.getClientesData().add(tempCliente);
				clienteTable.setItems(mainApp.getClientesData());
				Limpa.limpaTextField(nomeTextField, cpfTextField, codigoTextField, dataTextField, emailTextField,
						celularTextField, residencialTextField, cepTextField, enderecoTextField, bairroTextField,
						cidadeTextField);
				Limpa.limpaComboBox(estadosComboBox);
			}
		} else {
			String errorMessage = content + "Alguns dados obrigatórios estão inválidos e/ou vazios.";
			AlertUtil.criaUmAlert(title, header, errorMessage, type);
		}
	}

	/**
	 * Verifica o CEP passado, e faz um Auto-Complete nos campos relevantes.
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
		String content = "CAMPO NOME - Nome/Título do Cliente.\n";
		content += "\n";
		content += "CAMPO CPF - CPF do Cliente.\n";
		content += "\n";
		content += "CAMPO CÓDIGO - Código do Cliente.\n";
		content += "\n";
		content += "CAMPO DATA DE NASCIMENTO - Data de nascimento do Cliente.\n";
		content += "\n";
		content += "CAMPO E-MAIL - E-mail de contato do Cliente.\n";
		content += "\n";
		content += "CAMPO TELEFONE CELULAR - Telefone celular do Cliente.\n";
		content += "\n";
		content += "CAMPO TELEFONE RESIDÊNCIAL - Telefone residêncial não-obrigatório do Cliente.\n";
		content += "\n";
		content += "CAMPO CEP - CEP do Cliente.\n";
		content += "\n";
		content += "CAMPO ENDEREÇO - Lougradouro e Complemento do Cliente.\n";
		content += "\n";
		content += "CAMPO BAIRRO - Bairro do Cliente.\n";
		content += "\n";
		content += "CAMPO CIDADE - Cidade do Cliente.\n";
		content += "\n";
		content += "CAMPO ESTADO - Estado do Cliente.\n";
		content += "\n";
		AlertUtil.criaUmAlert("Ajuda", "Ajuda - Clientes", content, "INFORMATION");
	}

	/**
	 * Método de pesquisar na tabela pelo nome, ou código do Fornecedor, atualizando
	 * a tabela apenas com os Fornecedor que contém a String passada no campo de
	 * texto no nome ou código.
	 */
	@FXML
	private void pesquisar() {
		ObservableList<Cliente> pesquisa;
		if (principal.isSelected()) {
			if (pesquisaPorNomeToggleButton.isSelected()) {
				pesquisa = Pesquisa.pesquisarPorNome(mainApp.getClientesData(), pesquisaTextField.getText());
				clienteTable.setItems(pesquisa);
			}
			if (pesquisaPorCodigoToggleButton.isSelected()) {
				pesquisa = Pesquisa.pesquisarPorCodigo(mainApp.getClientesData(), pesquisaTextField.getText());
				clienteTable.setItems(pesquisa);
			}

		}
		if (endereco.isSelected()) {
			if (pesquisaPorNomeToggleButton.isSelected()) {
				pesquisa = Pesquisa.pesquisarPorNome(mainApp.getClientesData(), enderecoPesquisaTextField.getText());
				enderecoClienteTable.setItems(pesquisa);
			}
			if (pesquisaPorCodigoToggleButton.isSelected()) {
				pesquisa = Pesquisa.pesquisarPorCodigo(mainApp.getClientesData(), enderecoPesquisaTextField.getText());
				enderecoClienteTable.setItems(pesquisa);
			}
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
	 * Uma instância do MainApp para o Controller poder usar os métodos do MainApp
	 * 
	 * @param {@link EditClienteController#mainApp} uma referência à Aplicação
	 *               principal.
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		clienteTable.setItems(mainApp.getClientesData());
		enderecoClienteTable.setItems(mainApp.getClientesData());
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

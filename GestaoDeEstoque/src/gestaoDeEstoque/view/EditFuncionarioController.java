package gestaoDeEstoque.view;

import java.net.URL;
import java.util.ResourceBundle;
import gestaoDeEstoque.MainApp;
import gestaoDeEstoque.model.pessoa.Funcionarios;
import gestaoDeEstoque.util.AlertUtil;
import gestaoDeEstoque.util.Limpa;
import gestaoDeEstoque.util.exception.DadosInvalidosException;
import gestaoDeEstoque.util.factory.FactoryPessoa;
import gestaoDeEstoque.util.pesquisa.Pesquisa;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;

/**
 * Controlador da view EditFuncionario.
 * 
 * @author Gabriel Henrique
 *
 */
public class EditFuncionarioController implements Initializable {
	@FXML
	private TextField nomeTextField;
	@FXML
	private TextField codigoTextField;
	@FXML
	private TextField usuarioTextField;
	@FXML
	private TextField emailTextField;
	@FXML
	private PasswordField senhaPasswordField;
	@FXML
	private PasswordField confirmarSenhaPasswordField;
	@FXML
	private Button cancelarButton;
	@FXML
	private Button okButton;
	@FXML
	private TableView<Funcionarios> funcionarioTable;
	@FXML
	private TableColumn<Funcionarios, String> codigoColumn;
	@FXML
	private TableColumn<Funcionarios, String> nomeColumn;
	@FXML
	private TableColumn<Funcionarios, String> usuarioColumn;
	@FXML
	private TableColumn<Funcionarios, String> emailColumn;
	@FXML
	private Button helpButton;
	@FXML
	private ToggleButton cadastrarToggleButton;
	@FXML
	private ToggleButton alterarToggleButton;
	@FXML
	private ImageView excluirButton;
	@FXML
	private TextField pesquisaTextField;
	@FXML
	private ToggleButton pesquisaPorNomeToggleButton;
	@FXML
	private ToggleButton pesquisaPorCodigoToggleButton;

	private MainApp mainApp;
	private Stage dialogStage;

	/**
	 * Inicializa o controlador EditFuncionariorController.
	 * 
	 * @param URL            location
	 * @param ResourceBundle resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resource) {
		// inicializa as colunas da tabela
		codigoColumn.setCellValueFactory(cellData -> cellData.getValue().getCodigoProperty());
		nomeColumn.setCellValueFactory(cellData -> cellData.getValue().getNomeProperty());
		usuarioColumn.setCellValueFactory(cellData -> cellData.getValue().getUsuario());
		emailColumn.setCellValueFactory(cellData -> cellData.getValue().getEmailProperty());

		showFuncionarios(null);

		funcionarioTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showFuncionarios(newValue));

		// Abre uma janela só deste funcionário específico selecionado, ao dar
		// doubleclick no mouse.
		funcionarioTable.setOnMousePressed(new EventHandler<MouseEvent>() {
			@SuppressWarnings("unchecked")
			@Override
			public void handle(MouseEvent event) {
				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					Node node = ((Node) event.getTarget()).getParent();
					TableRow<Funcionarios> row;
					if (node instanceof TableRow) {
						row = (TableRow<Funcionarios>) node;
					} else {
						// clicking on text part
						row = (TableRow<Funcionarios>) node.getParent();
					}
					mainApp.showViewFuncionario(row.getItem());
				}
			}
		});
	}

	/**
	 * Preenche todos os campos de texto com o os dados do Funcionário selecionado.
	 * Se o Funcionário especificado for null, limpa todos os campos de texto.
	 * 
	 * @param fornecedor ou null
	 */
	private void showFuncionarios(Funcionarios funcionario) {
		if (funcionario != null) {
			nomeTextField.setText(funcionario.getNome());
			codigoTextField.setText(funcionario.getCodigo());
			emailTextField.setText(funcionario.getEmailProperty().get());
			usuarioTextField.setText(funcionario.getUsuario().get());
			senhaPasswordField.setText(funcionario.getSenha().get());
			confirmarSenhaPasswordField.setText(funcionario.getConfirmaSenha().get());
		} else {
			Limpa.limpaTextField(nomeTextField, usuarioTextField, codigoTextField, emailTextField, senhaPasswordField,
					confirmarSenhaPasswordField);
		}
	}

	/**
	 * Chamado quando o usuário clica em "Ok". De acordo com o que ele está
	 * selecionando no ToggleButton, o método adiciona um novo Funcionário, ou edita
	 * um Funcionário selecionado.
	 */
	@FXML
	private void handleOk() {
		if (cadastrarToggleButton.isSelected()) {
			adicionaOuAltera("Dados inválidos", "Alguns dados obrigatórios estão inválidos e/ou vazios.", "", "ERROR",
					-1);
		}
		if (alterarToggleButton.isSelected()) {
			int selectedIndex = funcionarioTable.getSelectionModel().getSelectedIndex();
			if (selectedIndex >= 0) {
				if (AlertUtil
						.criaUmAlert("Confirmação", "Você deseja mesmo fazer essa alteração ?",
								"Alteração no Funcionário: " + "'"
										+ mainApp.getFuncionariosData().get(selectedIndex).getNome() + "'",
								"CONFIRMATION")) {
					adicionaOuAltera("Dados inválidos", "Alguns dados obrigatórios estão inválidos e/ou vazios.", "",
							"ERROR", selectedIndex);
				}
			} else {
				AlertUtil.criaUmAlert("Nenhuma seleção", "Nenhum Funcionário Selecionado",
						"Por favor, Selecione um Funcionário na tabela.", "WARNING");
			}
		}
	}

	/**
	 * Método para deletar algum item da Tabela por meio do botão "Excluir".
	 */
	@FXML
	private void handleDelete() {
		int selectedIndex = funcionarioTable.getSelectionModel().getSelectedIndex();

		if (selectedIndex >= 0) {
			if (AlertUtil.criaUmAlert(
					"Confirmação", "Você deseja mesmo fazer essa exclusão ?", "Excluir o Funcionário: " + "'"
							+ mainApp.getFuncionariosData().get(selectedIndex).getNome() + "'" + " ?",
					"CONFIRMATION")) {
				funcionarioTable.getItems().remove(selectedIndex);
			}
		} else {
			AlertUtil.criaUmAlert("Nenhuma seleção", "Nenhum Funcionário Selecionado",
					"Por favor, Selecione um Funcionário na tabela.", "WARNING");
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
	 * Adiciona um novo Funcionário na Tabela ou altera um existente.
	 * 
	 * @param title   o título para criar um Alert
	 * @param header  o header para criar um Alert
	 * @param content o content para criar um Alert
	 * @param type    o type para criar um Alert
	 * @param index   o index do Funcionário a ser alterado.
	 */
	private void adicionaOuAltera(String title, String header, String content, String type, int index) {
		Funcionarios tempFuncionario;
		try {
			tempFuncionario = (Funcionarios) FactoryPessoa.getPessoa("F", codigoTextField.getText(),
					nomeTextField.getText(), emailTextField.getText(), usuarioTextField.getText(),
					senhaPasswordField.getText(), confirmarSenhaPasswordField.getText(), "", "", "", "", "", "", "", "",
					null);

			if (index >= 0) {
				mainApp.getFuncionariosData().set(index, tempFuncionario);
				funcionarioTable.setItems(mainApp.getFuncionariosData());
				Limpa.limpaTextField(nomeTextField, usuarioTextField, codigoTextField, emailTextField,
						senhaPasswordField, confirmarSenhaPasswordField);
			} else {
				mainApp.getFuncionariosData().add(tempFuncionario);
				funcionarioTable.setItems(mainApp.getFuncionariosData());
				Limpa.limpaTextField(nomeTextField, usuarioTextField, codigoTextField, emailTextField,
						senhaPasswordField, confirmarSenhaPasswordField);
			}
		} catch (DadosInvalidosException e) {
			e.printStackTrace();
			String errorMessage = content + "\n" + e.getMessage();
			AlertUtil.criaUmAlert(title, header, errorMessage, type);
		}
	}

	/**
	 * Cria um Alert com as informações de ajuda da tela.
	 */
	@FXML
	private void helpButton() {
		String content = "CAMPO NOME - Nome/Título do Funcionário.\n";
		content += "\n";
		content += "CAMPO CÓDIGO - Código do Funcionário.\n";
		content += "\n";
		content += "CAMPO USUÁRIO - Usuário do Funcionário.\n";
		content += "\n";
		content += "CAMPO E-MAIL - E-mail de contato do Funcionário.\n";
		content += "\n";
		content += "CAMPO SENHA DE ACESSO - Senha de acesso do Funcionário.\n";
		content += "\n";
		content += "CAMPO CONFIRME A SENHA - Campo para confirmar a senha de acesso do Funcionário.\n";
		content += "\n";
		content += "CAMPO DE PESQUISA - Pesquisa um Funcionário na tabela, de acordo com o nome ou o código.\n";
		content += "\n";
		AlertUtil.criaUmAlert("Ajuda", "Ajuda - Funcionários", content, "INFORMATION");
	}

	/**
	 * Método de pesquisar na tabela pelo nome, ou código do Funcionário,
	 * atualizando a tabela apenas com os Funcionários que contém a String passada
	 * no campo de texto no nome ou código.
	 */
	@FXML
	private void pesquisar() {
		ObservableList<Funcionarios> pesquisa;

		if (pesquisaPorNomeToggleButton.isSelected()) {
			pesquisa = Pesquisa.pesquisarPorNome(mainApp.getFuncionariosData(), pesquisaTextField.getText());
			funcionarioTable.setItems(pesquisa);
		}
		if (pesquisaPorCodigoToggleButton.isSelected()) {
			pesquisa = Pesquisa.pesquisarPorCodigo(mainApp.getFuncionariosData(), pesquisaTextField.getText());
			funcionarioTable.setItems(pesquisa);
		}

	}

	/**
	 * Uma instância do MainApp para o Controller poder usar os métodos do MainApp
	 * 
	 * @param {@link EditFuncionarioController#mainApp} uma referência à Aplicação
	 *               principal.
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		funcionarioTable.setItems(mainApp.getFuncionariosData());
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

package gestaoDeEstoque.view;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import gestaoDeEstoque.MainApp;
import gestaoDeEstoque.model.estoque.Grupos;
import gestaoDeEstoque.model.estoque.Produtos;
import gestaoDeEstoque.util.AlertUtil;
import gestaoDeEstoque.util.factory.FactoryGrupos;
import gestaoDeEstoque.util.pesquisa.Pesquisa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

/**
 * Janela para adição, exclusão e edição de grupos.
 * 
 * @author Gabriel Henrique
 *
 */
public class EditGruposController implements Initializable {
	@FXML
	private TextField nomeTextField;
	@FXML
	private TableView<Grupos> gruposTable;
	@FXML
	private TableColumn<Grupos, String> nomeColumn;
	@FXML
	private TableColumn<Grupos, String> quantidadeColumn;
	@FXML
	private TableColumn<Grupos, String> valorColumn;
	@FXML
	private Button okButton;
	@FXML
	private Button cancelarButton;
	@FXML
	private Button helpButton;
	@FXML
	private ToggleButton cadastrarToggleButton;
	@FXML
	private ToggleButton alterarToggleButton;
	@FXML
	private Button excluirButton;
	@FXML
	private TextField pesquisaTextField;

	private MainApp mainApp;
	private Stage dialogStage;
	// private ObservableList<Produtos> produtos =
	// FXCollections.observableArrayList();

	/**
	 * Inicializa o controlador EditGruposController.
	 * 
	 * @param URL            location
	 * @param ResourceBundle resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		nomeColumn.setCellValueFactory(cellData -> cellData.getValue().getNomeProperty());
		quantidadeColumn.setCellValueFactory(cellData -> cellData.getValue().getQuantidadeProdutosProperty());
		valorColumn.setCellValueFactory(cellData -> cellData.getValue().getValorTotalProperty());

		showGrupos(null);

		gruposTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showGrupos(newValue));

		// helpButton.setStyle("-fx-background-image: url('./HelpButton-icon.png');");

	}

	/**
	 * Uma instância do MainApp para o Controller poder usar os métodos do MainApp
	 * 
	 * @param {@link EditGruposController#mainApp} uma referência à Aplicação
	 *               principal.
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		gruposTable.setItems(mainApp.getGruposData());
	}

	/**
	 * Preenche todos os campos de texto com o os dados do grupo selecionado. Se o
	 * grupo especificado for null, limpa todos os campos de texto.
	 * 
	 * @param grupo ou null
	 */
	private void showGrupos(Grupos grupo) {
		if (grupo != null) {
			nomeTextField.setText(grupo.getNome());
		} else {
			nomeTextField.setText("");
		}
	}

	/**
	 * Define o Stage para este dialogo.
	 * 
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;

	}

	/**
	 * Chamado quando o usuário clica em "Ok". De acordo com o que ele está
	 * selecionando nos ToggleButton, o método adiciona um novo Grupo, ou edita um
	 * Grupo selecionado.
	 */
	@FXML
	private void handleOk() {
		if (cadastrarToggleButton.isSelected()) {
			adicionaOuAltera("Dados inválidos", "Alguns dados obrigatórios estão inválidos e/ou vazios.",
					"O nome não pode estar vazio!", "ERROR", -1);
		}
		if (alterarToggleButton.isSelected()) {
			int selectedIndex = gruposTable.getSelectionModel().getSelectedIndex();
			if (selectedIndex >= 0) {
				if (AlertUtil.criaUmAlert("Confirmação", "Você deseja mesmo fazer essa alteração ?",
						"Alteração no Grupo: " + "'" + mainApp.getGruposData().get(selectedIndex).getNome() + "'",
						"CONFIRMATION")) {
					adicionaOuAltera("Dados inválidos", "Alguns dados obrigatórios estão inválidos e/ou vazios.",
							"O nome não pode estar vazio!", "ERROR", selectedIndex);
				}
			} else {
				AlertUtil.criaUmAlert("Nenhuma seleção", "Nenhum Grupo Selecionado",
						"Por favor, Selecione um grupo na tabela.", "WARNING");
			}
		}
		nomeTextField.setText("");
	}

	/**
	 * Chamado quando o usuário clica em "Cancelar".
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	/**
	 * Método para deletar algum item da Tabela.
	 */
	@FXML
	private void handleDelete() {
		int selectedIndex = gruposTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			if (AlertUtil.criaUmAlert("Confirmação", "Você deseja mesmo fazer essa exclusão ?",
					"Excluir o Grupo: " + "'" + mainApp.getGruposData().get(selectedIndex).getNome() + "'" + " ?",
					"CONFIRMATION")) {
				gruposTable.getItems().remove(selectedIndex);
			}
		} else {
			AlertUtil.criaUmAlert("Nenhuma seleção", "Nenhum Grupo Selecionado",
					"Por favor, Selecione um grupo na tabela.", "WARNING");
		}
	}

	/**
	 * Adiciona um novo grupo na Tabela ou altera um existente.
	 * 
	 * @param title   o título para criar um Alert
	 * @param header  o header para criar um Alert
	 * @param content o content para criar um Alert
	 * @param type    o type para criar um Alert
	 */
	private void adicionaOuAltera(String title, String header, String content, String type, int index) {
		Grupos tempGrupo = FactoryGrupos.getGrupo(nomeTextField.getText());
		if (tempGrupo != null) {
			if (index >= 0) {
				mainApp.getGruposData().set(index, tempGrupo);
				gruposTable.setItems(mainApp.getGruposData());
			} else {
				mainApp.getGruposData().add(tempGrupo);
				gruposTable.setItems(mainApp.getGruposData());
			}
		} else {
			AlertUtil.criaUmAlert(title, header, content, type);
		}
	}

	/**
	 * Método de pesquisar na tabela pelo nome do Grupo, atualizando a tabela apenas
	 * com os grupos que contém a String passada no campo de texto no nome.
	 */
	@FXML
	private void pesquisar() {
		ObservableList<Grupos> pesquisa = Pesquisa.pesquisarPorNome(mainApp.getGruposData(),
				pesquisaTextField.getText());
		gruposTable.setItems(pesquisa);
	}
}

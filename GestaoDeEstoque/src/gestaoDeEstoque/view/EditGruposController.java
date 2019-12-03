package gestaoDeEstoque.view;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import gestaoDeEstoque.MainApp;
import gestaoDeEstoque.model.estoque.Grupos;
import gestaoDeEstoque.util.FactoryGrupos;
import gestaoDeEstoque.util.Pesquisa;
import gestaoDeEstoque.util.Pesquisavel;
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
 * Janela para adi��o, exclus�o e edi��o de grupos.
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
	private Grupos grupos;

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
	 * Uma inst�ncia do MainApp para o Controller poder usar os m�todos do MainApp
	 * 
	 * @param {@link EditGruposController#mainApp} uma refer�ncia � Aplica��o
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
	 * Define o grupo a ser editado.
	 * 
	 * @param grupo
	 */
	public void setGrupo(Grupos grupos) {
		this.grupos = grupos;
		nomeTextField.setText(grupos.getNome());
	}


	/**
	 * Chamado quando o usuário clica em "Ok".
	 * De acordo com o que ele está selecionando nos ToggleButton, o método adiciona um novo Grupo, ou edita
	 * um Grupo selecionado.
	 */
	@FXML
	private void handleOk() {
		grupos.setNome(nomeTextField.getText());
		// TODO verificar se o campo está vazio.
		if (cadastrarToggleButton.isSelected()) {
			mainApp.getGruposData().add(FactoryGrupos.getGrupo(nomeTextField.getText()));
			gruposTable.setItems(mainApp.getGruposData());
		}
		if (alterarToggleButton.isSelected()) {
			int selectedIndex = gruposTable.getSelectionModel().getSelectedIndex();
			if (selectedIndex >= 0) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmação");
				alert.setHeaderText("Você deseja mesmo fazer essa alteração ?");
				alert.setContentText(
						"Alteração no Grupo: " + "'" + mainApp.getGruposData().get(selectedIndex).getNome() + "'");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					gruposTable.getItems().get(selectedIndex).setNome(nomeTextField.getText());
				} else {

				}

			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Nenhuma sele��o");
				alert.setHeaderText("Nenhuma Grupo Selecionado");
				alert.setContentText("Por favor, selecione um grupo na tabela.");
				alert.showAndWait();
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
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmação");
			alert.setHeaderText("Você deseja mesmo fazer essa exclusão ?");
			alert.setContentText(
					"Excluir o Grupo: " + "'" + mainApp.getGruposData().get(selectedIndex).getNome() + "'");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				gruposTable.getItems().remove(selectedIndex);
			} else {

			}

		} else {

			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Nenhuma sele��o");
			alert.setHeaderText("Nenhuma Grupo Selecionado");
			alert.setContentText("Por favor, selecione um grupo na tabela.");
			alert.showAndWait();
		}
	}

	@FXML
	private void pesquisar() {
		// CASO O M�TODO ESTIVESSE FUNCIONANDO
		// gruposTable.setItems( (ObservableList<Grupos>)
		// Pesquisa.pesquisarPorNome(mainApp.getGruposData(),
		// pesquisaTextField.getText()));

		ObservableList<Grupos> novaLista = FXCollections.observableArrayList();
		if (pesquisaTextField.getText().length() > 0) {
			for (int x = 0; x < mainApp.getGruposData().size(); x++) {
				if (mainApp.getGruposData().get(x).getNome().toLowerCase()
						.contains(pesquisaTextField.getText().toLowerCase())) {
					novaLista.add(mainApp.getGruposData().get(x));
				}
			}
			gruposTable.setItems(novaLista);
		} else {
			gruposTable.setItems(mainApp.getGruposData());
		}
	}
}

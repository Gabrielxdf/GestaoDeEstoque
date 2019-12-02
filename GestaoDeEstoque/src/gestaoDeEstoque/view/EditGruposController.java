package gestaoDeEstoque.view;

import java.net.URL;
import java.util.ResourceBundle;

import gestaoDeEstoque.MainApp;
import gestaoDeEstoque.model.estoque.Grupos;
import gestaoDeEstoque.util.FactoryGrupos;
import gestaoDeEstoque.util.Pesquisa;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

/**
 * Janela para adição, exclusão e edição de grupos.
 * 
 * @author Gabriel Henrique
 *
 */
public class EditGruposController implements Initializable{
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
	/*
	pesquisaTextField.setOnKeyReleased((KeyEvent e) ->){
		gruposTable.setItems(Pesquisa.pesquisar(mainApp.getGruposData(), "", pesquisaTextField));
	}*/

	private MainApp mainApp;
	private Stage dialogStage;
	private Grupos grupos;
	private boolean okClicked;

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
	 * Define o grupo a ser editado.
	 * 
	 * @param grupo
	 */
	public void setGrupo(Grupos grupos) {
		this.grupos = grupos;
		nomeTextField.setText(grupos.getNome());
	}

	/**
	 * Retorna true caso o usuário clicou em "OK", de outra forma, retorna falso.
	 * 
	 * @return okClicked
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * Chamado quando o usuário clica em "Ok".
	 * Cria um novo Grupo e adiciona a lista observavel, que é adicionada à tabela.
	 */
	@FXML
	private void handleOk() {
		grupos.setNome(nomeTextField.getText());
		if(cadastrarToggleButton.isSelected()) {
		mainApp.getGruposData().add(FactoryGrupos.getGrupo(nomeTextField.getText()));
		}
		if(alterarToggleButton.isSelected()) {
			int selectedIndex = gruposTable.getSelectionModel().getSelectedIndex();
			if (selectedIndex >= 0) {
		        gruposTable.getItems().get(selectedIndex).setNome(nomeTextField.getText());
		    }else {
		    	 Alert alert = new Alert(AlertType.WARNING);
		            alert.setTitle("Nenhuma seleção");
		            alert.setHeaderText("Nenhuma Grupo Selecionado");
		            alert.setContentText("Por favor, selecione um grupo na tabela.");
		            alert.showAndWait();
		    }
		}
		nomeTextField.setText("");
		
		okClicked = true;
	}

	/**
	 * Chamado quando o usuário clica em "Cancelar".
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}
	
	@FXML
	private void handleDelete() {
		   int selectedIndex = gruposTable.getSelectionModel().getSelectedIndex();
		    if (selectedIndex >= 0) {
		        gruposTable.getItems().remove(selectedIndex);
		    } else {
		      
		    Alert alert = new Alert(AlertType.WARNING);
		            alert.setTitle("Nenhuma seleção");
		            alert.setHeaderText("Nenhuma Grupo Selecionado");
		            alert.setContentText("Por favor, selecione um grupo na tabela.");
		            alert.showAndWait();
		    }
	}
}

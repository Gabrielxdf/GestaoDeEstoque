package gestaoDeEstoque.view;

import java.net.URL;
import java.util.ResourceBundle;

import gestaoDeEstoque.MainApp;
import gestaoDeEstoque.model.estoque.Grupos;
import gestaoDeEstoque.model.estoque.Produtos;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.Tab;

public class RootLayoutController implements Initializable {
	@FXML
	private Tab principal;
	@FXML
	private Button produtosButton;
	@FXML
	private Button fornecedoresButton;
	@FXML
	private Button clientesButton;
	@FXML
	private Button funcionariosButton;
	@FXML
	private Button principalGruposButton;
	@FXML
	private Button principalAjudaButton;
	@FXML
	private Tab acoes;
	@FXML
	private Button entradaButton;
	@FXML
	private Button saidaButton;
	@FXML
	private Button acoesAjudaButton;
	@FXML
	private Tab relatorios;
	@FXML
	private Button semanalButton;
	@FXML
	private Button mensalButton;
	@FXML
	private Button anualButton;
	@FXML
	private Button relatoriosGruposButton;
	@FXML
	private Button relatoriosAjudaButton;
	private MainApp mainApp;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	/**
	 * Uma inst�ncia do MainApp para o Controller poder usar os m�todos do MainApp
	 * 
	 * @param mainApp. uma refer�ncia � Aplica��o principal.
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	/**
	 * Chamado quando o usu�rio clica no bot�o "Grupos". Abre uma janela para criar,
	 * editar e excluir grupos.
	 */
	@FXML
	private void handleGrupo() {
		Grupos tempGrupo = new Grupos();
		mainApp.showEditGrupos(tempGrupo);
	}
	
	/**
	 * Chamado quando o usuário clica no botão "Produtos". Abre uma janela para criar, editar e excluir produtos.
	 */
	@FXML
	private void handleProdutos() {
		Produtos tempProduto = new Produtos();
		mainApp.showEditProdutos(tempProduto);
	}
}

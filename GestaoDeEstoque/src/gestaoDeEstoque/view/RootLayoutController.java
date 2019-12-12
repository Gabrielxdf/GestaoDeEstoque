package gestaoDeEstoque.view;

import java.net.URL;
import java.util.ResourceBundle;
import gestaoDeEstoque.MainApp;
import gestaoDeEstoque.util.AlertUtil;
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
	 * Uma instância do MainApp para o Controller poder usar os métodos do MainApp
	 * 
	 * @param mainApp. uma referência à Aplicação principal.
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	/**
	 * Chamado quando o usuário clica no botão "Grupos". Abre uma janela para criar,
	 * editar e excluir grupos.
	 */
	@FXML
	private void handleGrupo() {
		mainApp.showEditGrupos();
	}
	
	/**
	 * Chamado quando o usuário clica no botão "Fornecedores". Abre uma janela para criar, editar 
	 * e excluir fornecedores.
	 */
	@FXML
	private void handleFornecedores() {
		mainApp.showEditFornecedores();
	}
	
	/**
	 * Chamado quando o usuário clica no botão "Produtos". Abre uma janela para criar, editar e excluir produtos.
	 */
	@FXML
	private void handleProdutos() {
		mainApp.showEditProdutos();
	}
	
	/**
	 * Chamado quando o usuário clica no botão "Clientes". Abre uma janela para criar, editar e excluir clientes.
	 */
	@FXML
	private void handleClientes() {
		mainApp.showEditCliente();
	}
	
	/**
	 * Chamado quando o usuário clica no botão "Funcionários". Abre uma janela para criar, editar e excluir funcionários.
	 */
	@FXML
	private void handleFuncionarios() {
		mainApp.showEditFuncionario();
	}
	
	@FXML
	private void handleEntrada() {
		mainApp.showEditEntrada();
	}
	
	@FXML
	private void handleSaida() {
		mainApp.showEditSaida();
	}
	
	/**
	 * Chamado quando o usuário clica no botão "Ajuda". Abre uma janela com algumas informações de ajuda para o usuário.
	 */
	@FXML
	private void handleAjuda() {
		String content = "";
		if(principal.isSelected()) {
			content += "GRUPOS - Cria, deleta e edita Grupos de produtos.\n";
			content += "\n";
			content += "FORNECEDORES - Cria, deleta e edita Fornecedores de produtos.\n";
			content += "\n";
			content += "PRODUTOS - Cria, deleta e edita Produtos do sistema.\n";
			content += "\n";
			content += "CLIENTES - Cria, deleta e edita Clientes do sistema.\n";
			content += "\n";
			content += "FUNCIONÁRIOS - Cria, deleta e edita Funcionários que têm acesso ao sistema.\n";
			
			AlertUtil.criaUmAlert("Ajuda - Principal", "Ajuda na aba Principal", content, "INFORMATION");
		}
		if(acoes.isSelected()) {
			content += "ENTRADA - Abre uma Janela para fazer entradas no estoque.\n";
			content += "\n";
			content += "SAÍDA - Abre uma janela para fazer saídas no estoque.\n";
			content += "\n";
			AlertUtil.criaUmAlert("Ajuda - Ações", "Ajuda na aba Ações", content, "INFORMATION");
		}
		if(relatorios.isSelected()) {
			AlertUtil.criaUmAlert("Ajuda - Relatórios", "Ajuda na aba Relatórios", content, "INFORMATION");
		}
	}
}

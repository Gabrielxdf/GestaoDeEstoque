package gestaoDeEstoque.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.Tab;

public class RootLayoutController implements Initializable{
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
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}

package gestaoDeEstoque.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.ToggleButton;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class GruposController implements Initializable{
	@FXML
	private TextField nomeTextField;
	@FXML
	private TableView gruposTable;
	@FXML
	private TableColumn nomeColumn;
	@FXML
	private TableColumn quantidadeColumn;
	@FXML
	private TableColumn valorColumn;
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
	private Button exclurButton;
	@FXML
	private TextField pesquisaTextField;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}

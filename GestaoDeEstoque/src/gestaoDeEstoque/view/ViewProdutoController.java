package gestaoDeEstoque.view;

import java.net.URL;
import java.util.ResourceBundle;

import gestaoDeEstoque.model.estoque.Fornecedor;
import gestaoDeEstoque.model.estoque.Grupos;
import gestaoDeEstoque.model.estoque.Produtos;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ViewProdutoController implements Initializable{

    @FXML
    private TextField nomeTextField;

    @FXML
    private TextField codigoTextField;

    @FXML
    private TextField valorTextField;

    @FXML
    private TextField codigoBarrasTextField;

    @FXML
    private TextField minimoTextField;

    @FXML
    private TextField idealTextField;
    
    @FXML
    private TextField atualTextField;

    @FXML
    private TextField descricaoTextField;

    @FXML
    private ComboBox<Grupos> grupoComboBox;

    @FXML
    private ComboBox<String> classificacaoComboBox;

    @FXML
    private ComboBox<Fornecedor> fornecedorComboBox;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	/**
	 * Seta o Produto dessa view.
	 * 
	 * @param produto
	 */
	public void setProduto(Produtos produto) {
		nomeTextField.setText(produto.getNome());
		codigoTextField.setText(produto.getCodigo());
		valorTextField.setText(produto.getValorProperty().get());
		codigoBarrasTextField.setText(produto.getCodigoBarrasProperty().get());
		minimoTextField.setText(produto.getEstoqueMinimoProperty().get());
		idealTextField.setText(produto.getEstoqueIdealProperty().get());
		atualTextField.setText(produto.getEstoqueAtualProperty().get());
		descricaoTextField.setText(produto.getDescricaoProperty().get());
		grupoComboBox.setPromptText(produto.getGrupo().getNome());
		fornecedorComboBox.setPromptText(produto.getFornecedor().getNome());
		classificacaoComboBox.setPromptText(produto.getClassificacaoProperty().get());
	}

}

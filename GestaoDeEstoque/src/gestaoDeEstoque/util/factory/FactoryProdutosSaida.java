package gestaoDeEstoque.util.factory;

import gestaoDeEstoque.model.estoque.Produtos;
import gestaoDeEstoque.model.estoque.entradaOuSaida.ProdutosSaida;
import gestaoDeEstoque.model.pessoa.Cliente;
import gestaoDeEstoque.util.Verifica;
import gestaoDeEstoque.util.exception.DadosInvalidosException;
import javafx.scene.control.ComboBox;

public class FactoryProdutosSaida {

	public static ProdutosSaida getProdutosSaida(Produtos produto, String quantidade,
			String valorTotal, ComboBox<Cliente> cliente, String numeroDocumento) throws DadosInvalidosException{
		ProdutosSaida retorno = null;
		String errorMessage = "";
		
		if(Verifica.stringVazia(quantidade)) {
			errorMessage += "A quantidade não pode estar vazia!\n";
		}
		
		try {
			Integer.parseInt(numeroDocumento);
		} catch (NumberFormatException e) {
			errorMessage += "Erro! o número do documento deve conter apenas números!\n";
			errorMessage += "Exemplo: 040\n";
		}
		
		if(Verifica.stringVazia(numeroDocumento)) {
			errorMessage += "O número do documento não pode estar vazio!\n";
		}
		
		if(Verifica.comboBoxSemSeleção(cliente)) {
			errorMessage += "O cliente deve ser especificado!\n";
		}
		if(Integer.parseInt(quantidade) > Integer.parseInt(produto.getEstoqueAtual())) {
			errorMessage += "Erro! O estoque atual deste produto é menor que a quantidade da saída.\n";
		}
		if (errorMessage.length() > 0) {
			throw new DadosInvalidosException(errorMessage);
		} else {
			retorno = new ProdutosSaida(produto, quantidade, valorTotal, cliente.getSelectionModel().getSelectedItem());
		}
		return retorno;
	}
}

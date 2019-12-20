package gestaoDeEstoque.util.factory;

import gestaoDeEstoque.model.estoque.Produtos;
import gestaoDeEstoque.model.estoque.entradaOuSaida.ProdutosEntrada;
import gestaoDeEstoque.util.Verifica;
import gestaoDeEstoque.util.exception.DadosInvalidosException;

public class FactoryProdutosEntrada {

	public static ProdutosEntrada getProdutosEntrada(Produtos produto, String quantidade,
			String valorTotal, String numeroDocumento) throws DadosInvalidosException{
		
		ProdutosEntrada retorno = null;
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
		
		if (errorMessage.length() > 0) {
			throw new DadosInvalidosException(errorMessage);
		} else {
			retorno = new ProdutosEntrada(produto, quantidade, valorTotal);
		}
		return retorno;
	}
}

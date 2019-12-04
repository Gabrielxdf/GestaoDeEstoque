package gestaoDeEstoque.util.factory;

import gestaoDeEstoque.model.estoque.Fornecedor;
import gestaoDeEstoque.model.estoque.Grupos;
import gestaoDeEstoque.model.estoque.Produtos;
import gestaoDeEstoque.util.Verifica;

public class FactoryProdutos {
	private static String errorMessage = "";

	public static Produtos getProduto(String nome, String codigo, String valor, String codigoBarras,
			String estoqueMinimo, String estoqueIdeal, String classificacao, String descricao, Fornecedor fornecedor,
			Grupos nomeGrupo) {
		Produtos retorno = null;
		if (Verifica.stringVazia(nome) && Verifica.stringVazia(codigo) && Verifica.stringVazia(valor)
				&& Verifica.stringVazia(codigoBarras) && Verifica.stringVazia(estoqueMinimo)
				&& Verifica.stringVazia(estoqueIdeal) && Verifica.stringVazia(classificacao)
				&& Verifica.stringVazia(descricao) && Verifica.objetoNulo(fornecedor)
				&& Verifica.objetoNulo(nomeGrupo)) {
			retorno = new Produtos(nome, codigo, valor, codigoBarras, estoqueMinimo, estoqueIdeal, classificacao,
					descricao, fornecedor, nomeGrupo);
		}
		return retorno;
	}

	public static String getErrorMessage() {
		return errorMessage;
	}
}

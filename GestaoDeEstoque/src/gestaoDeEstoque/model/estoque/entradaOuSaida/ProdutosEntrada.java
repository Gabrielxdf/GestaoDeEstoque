package gestaoDeEstoque.model.estoque.entradaOuSaida;

import gestaoDeEstoque.model.estoque.Produtos;
import gestaoDeEstoque.util.pesquisa.Pesquisavel;
/**
 * Classe modelo dos Produtos para Entradas
 * @author Gabriel Henrique
 *
 */
public class ProdutosEntrada extends ProdutoEntradaOuSaida implements Pesquisavel{
/**
 * Construtor do ProdutoEntrada.
 * @param produto
 * @param quantidade
 * @param valorTotal
 */
public ProdutosEntrada(Produtos produto, String quantidade, String valorTotal) {
	super(produto, quantidade, valorTotal);
}

/**
 * Pega a String do nome do Produto.
 * @return {@link ProdutoEntradaOuSaida#getProduto()#getNome()}
 */
@Override
public String getNome() {
	return this.getProduto().getNome();
}

/**
 * Pega a String do código do Produto.
 * @return {@link ProdutoEntradaOuSaida#getProduto()#getCodigo()}
 */
@Override
public String getCodigo() {
	return this.getProduto().getCodigo();
}

}

package gestaoDeEstoque.model.estoque.entradaOuSaida;

import gestaoDeEstoque.model.estoque.Produtos;
import gestaoDeEstoque.model.pessoa.Cliente;
import gestaoDeEstoque.util.pesquisa.Pesquisavel;
/**
 * Classe modelo dos Produtos para Saídas
 * @author Gabriel Henrique
 *
 */
public class ProdutosSaida extends ProdutoEntradaOuSaida implements Pesquisavel{

private Cliente cliente;

/**
 * Construtor do ProdutoSaida.
 * @param produto
 * @param quantidade
 * @param valorTotal
 * @param cliente
 */
public ProdutosSaida(Produtos produto, String quantidade, String valorTotal, Cliente cliente) {
	super(produto, quantidade, valorTotal);
	this.cliente = cliente;
}

/**
 * Pega o Objeto cliente {@link Cliente}
 * @return cliente
 */
public Cliente getCliente() {
	return cliente;
}

/**
 * Define o cliente {@link Cliente}
 * @param cliente
 */
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
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

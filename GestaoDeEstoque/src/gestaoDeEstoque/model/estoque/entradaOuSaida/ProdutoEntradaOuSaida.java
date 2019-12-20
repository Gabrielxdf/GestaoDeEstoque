package gestaoDeEstoque.model.estoque.entradaOuSaida;

import gestaoDeEstoque.model.estoque.Produtos;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 * Classe modelo para um Produto para Entrada ou Saída.
 * @author Gabriel Henrique
 *
 */
public abstract class ProdutoEntradaOuSaida {
	private Produtos produto;
	private StringProperty quantidade;
	private StringProperty valorTotal;
	
	/**
	 * Construtor do ProdutoEntradaOuSaida
	 * @param produto
	 * @param quantidade
	 * @param valorTotal
	 */
	public ProdutoEntradaOuSaida(Produtos produto, String quantidade, String valorTotal) {
		this.produto = produto;
		this.quantidade = new SimpleStringProperty(quantidade);
		this.valorTotal = new SimpleStringProperty(valorTotal);
	}
	
	/**
	 * Pega o Objeto produto {@link Produtos}.
	 * @return produto
	 */
	public Produtos getProduto() {
		return produto;
	}
	
	/**
	 * Pega a StringProperty da quantidade.
	 * @return quantidade
	 */
	public StringProperty getQuantidadeProperty() {
		return quantidade;
	}
	
	/**
	 * Pega a StringProperty do valor total.
	 * @return valorTotal
	 */
	public StringProperty getValorTotalProperty() {
		return valorTotal;
	}
	
	/**
	 * Pega a String da quantidade.
	 * @return quantidade
	 */
	public String getQuantidade() {
		return quantidade.get();
	}
	
	/**
	 * Pega a String do valor total.
	 * @return valorTotal
	 */
	public String getValorTotal() {
		return valorTotal.get();
	}
	
	/**
	 * Define o produto {@link Produtos}.
	 * @param produto
	 */
	public void setProduto(Produtos produto) {
		this.produto = produto;
	}

	/**
	 * Define a quantidade.
	 * @param quantidade
	 */
	public void setQuantidade(String quantidade) {
		this.quantidade = new SimpleStringProperty(quantidade);
	}
	
	/**
	 * Define o valor total.
	 * @param valorTotal
	 */
	public void setValorTotal(String valorTotal) {
		this.valorTotal = new SimpleStringProperty(valorTotal);
	}
}

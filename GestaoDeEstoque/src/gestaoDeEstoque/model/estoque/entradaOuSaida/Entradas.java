package gestaoDeEstoque.model.estoque.entradaOuSaida;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * Classe modelo das Entradas
 * @author Gabriel Henrique
 *
 */
public class Entradas {
private List<ProdutosEntrada> produtoEntrada = new ArrayList<>();
private String data;
private Double valorTotal = 0.0;
private String descricao;
private String numeroDocumento;

/**
 * Construtor da Entrada.
 * @param produtoEntrada
 * @param descricao
 * @param numeroDocumento
 */
public Entradas(List<ProdutosEntrada> produtoEntrada, String descricao, String numeroDocumento) {
	this.produtoEntrada = produtoEntrada;
	this.data = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	for(ProdutosEntrada p : this.produtoEntrada) {
		Double valorDoProduto = Double.parseDouble(p.getValorTotalProperty().get());
		this.valorTotal += valorDoProduto;
	}
	this.descricao = descricao;
	this.numeroDocumento = numeroDocumento;
}

/**
 * Pega o Objeto produtoEntrada {@link ProdutosEntrada}.
 * 
 * @return produtoEntrada
 */
public List<ProdutosEntrada> getProdutoEntrada() {
	return produtoEntrada;
}

/**
 * Pega a String da data.
 * @return data
 */
public String getData() {
	return data;
}

/**
 * Pega o Double do valor total.
 * @return valorTotal
 */
public Double getValorTotal() {
	return valorTotal;
}

/**
 * Define o produtoEntrada {@link ProdutosEntrada}
 * @param entrada
 */
public void setEntrada(List<ProdutosEntrada> produtoEntrada) {
	this.produtoEntrada = produtoEntrada;
}

/**
 * Define a data.
 * @param data
 */
public void setData(String data) {
	this.data = data;
}

/**
 * Define o valor total.
 * @param valorTotal
 */
public void setValorTotal(Double valorTotal) {
	this.valorTotal = valorTotal;
}

/**
 * Pega a String da descrição.
 * @return descricao
 */
public String getDescricao() {
	return descricao;
}

/**
 * Define a descrição.
 * @param descricao
 */
public void setDescricao(String descricao) {
	this.descricao = descricao;
}

/**
 * Pega a String do número do documento.
 * @return numeroDocumento
 */
public String getNumeroDocumento() {
	return numeroDocumento;
}

/**
 * Define o número do documento.
 * @param numeroDocumento
 */
public void setNumeroDocumento(String numeroDocumento) {
	this.numeroDocumento = numeroDocumento;
}

}

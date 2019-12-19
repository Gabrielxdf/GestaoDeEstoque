package gestaoDeEstoque.model.estoque;

import gestaoDeEstoque.model.pessoa.Cliente;
import gestaoDeEstoque.util.pesquisa.Pesquisavel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProdutosSaida implements Pesquisavel{
private Produtos produto;
private StringProperty quantidade;
private StringProperty valorTotal;
private Cliente cliente;

public ProdutosSaida(Produtos produto, String quantidade, String valorTotal, Cliente cliente) {
	this.produto = produto;
	this.quantidade = new SimpleStringProperty(quantidade);
	this.valorTotal = new SimpleStringProperty(valorTotal);
	this.cliente = cliente;
}

public Produtos getProduto() {
	return produto;
}
public StringProperty getQuantidadeProperty() {
	return quantidade;
}
public StringProperty getValorTotalProperty() {
	return valorTotal;
}
public void setProduto(Produtos produto) {
	this.produto = produto;
}
public void setQuantidade(StringProperty quantidade) {
	this.quantidade = quantidade;
}
public void setValorTotal(StringProperty valorTotal) {
	this.valorTotal = valorTotal;
}

public Cliente getCliente() {
	return cliente;
}

public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}

@Override
public String getNome() {
	
	return this.produto.getNome();
}

@Override
public String getCodigo() {
	return this.produto.getCodigo();
}

}

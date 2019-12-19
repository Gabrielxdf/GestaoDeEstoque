package gestaoDeEstoque.model.estoque;

import gestaoDeEstoque.util.pesquisa.Pesquisavel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProdutosEntrada implements Pesquisavel{
private Produtos produto;
private StringProperty quantidade;
private StringProperty valorTotal;

public ProdutosEntrada(Produtos produto, String quantidade, String valorTotal) {
	this.produto = produto;
	this.quantidade = new SimpleStringProperty(quantidade);
	this.valorTotal = new SimpleStringProperty(valorTotal);
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

@Override
public String getNome() {
	
	return this.produto.getNome();
}

@Override
public String getCodigo() {
	return this.produto.getCodigo();
}

}

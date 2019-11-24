package GestaoDeEstoque.model.estoque;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Grupos {
private StringProperty nome;
private IntegerProperty quantidadeProdutos;
private DoubleProperty valorTotal;
public Grupos(StringProperty nome) {
	super();
	this.nome = nome;
}
public StringProperty getNome() {
	return nome;
}
public void setNome(StringProperty nome) {
	this.nome = nome;
}
public IntegerProperty getQuantidadeProdutos() {
	return quantidadeProdutos;
}
public void setQuantidadeProdutos(IntegerProperty quantidadeProdutos) {
	this.quantidadeProdutos = quantidadeProdutos;
}
public DoubleProperty getValorTotal() {
	return valorTotal;
}
public void setValorTotal(DoubleProperty valorTotal) {
	this.valorTotal = valorTotal;
}


}

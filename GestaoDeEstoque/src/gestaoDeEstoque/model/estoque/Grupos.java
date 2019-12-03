package gestaoDeEstoque.model.estoque;

import gestaoDeEstoque.util.Pesquisavel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Grupos implements Pesquisavel{
	private StringProperty nome;
	private StringProperty quantidadeProdutos;
	private StringProperty valorTotal;

	public Grupos() {
		this(null);
	}

	public Grupos(String nome) {
		this.nome = new SimpleStringProperty(nome);
		this.quantidadeProdutos = new SimpleStringProperty("0");
		this.valorTotal = new SimpleStringProperty("0");
	}

	
	
	// Getters and Setters para Property e não-Property
	public void setNome(StringProperty nome) {
		this.nome = nome;
	}

	public void setQuantidadeProdutos(StringProperty quantidadeProdutos) {
		this.quantidadeProdutos = quantidadeProdutos;
	}

	public void setValorTotal(StringProperty valorTotal) {
		this.valorTotal = valorTotal;
	}

	public StringProperty getNomeProperty() {
		return nome;
	}

	public StringProperty getQuantidadeProdutosProperty() {
		return quantidadeProdutos;
	}

	public StringProperty getValorTotalProperty() {
		return valorTotal;
	}
	@Override
	public String getNome() {
		return nome.get();
	}

	public void setNome(String nome) {
		this.nome.set(nome);
	}

	public String getQuantidadeProdutos() {
		return quantidadeProdutos.get();
	}

	public void setQuantidadeProdutos(String quantidadeProdutos) {
		this.quantidadeProdutos.set(quantidadeProdutos);
	}

	public String getValorTotal() {
		return valorTotal.get();
	}

	public void setValorTotal(String valorTotal) {
		this.valorTotal.set(valorTotal);
	}

	@Override
	public String getCodigo() {
		
		return null;
	}

}

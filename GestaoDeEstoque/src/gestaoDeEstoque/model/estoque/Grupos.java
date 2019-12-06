package gestaoDeEstoque.model.estoque;

import java.util.ArrayList;
import java.util.List;

import gestaoDeEstoque.util.pesquisa.Pesquisavel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Grupos implements Pesquisavel{
	private StringProperty nome;
	private StringProperty quantidadeProdutos;
	private StringProperty valorTotal;
	private List<Produtos> listaProdutos = new ArrayList<>();

	public Grupos() {
		this(null);
	}

	public Grupos(String nome) {
		this.nome = new SimpleStringProperty(nome);
		this.quantidadeProdutos = new SimpleStringProperty("0");
		this.valorTotal = new SimpleStringProperty("0");
	}

	
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
	
	public List<Produtos> getListaProdutos(){
		return listaProdutos;
	}
	
	@Override
	public String getNome() {
		return nome.get();
	}

	@Override
	public String getCodigo() {
		
		return null;
	}

	@Override
	public String toString() {
		return getNome();
	}
	

}

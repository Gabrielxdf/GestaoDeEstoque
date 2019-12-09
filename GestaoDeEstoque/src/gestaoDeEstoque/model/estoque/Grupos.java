package gestaoDeEstoque.model.estoque;

import java.util.List;
import gestaoDeEstoque.util.pesquisa.Pesquisavel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Grupos implements Pesquisavel{
	private StringProperty quantidadeProdutos;
	private StringProperty nome;
	private StringProperty valorTotal;
	private ObservableList<Produtos> listaProdutos = FXCollections.observableArrayList();

	public Grupos() {
		this(null);
	}

	public Grupos(String nome) {
		this.nome = new SimpleStringProperty(nome);
		this.quantidadeProdutos = new SimpleStringProperty("10");
		this.valorTotal = new SimpleStringProperty("10");
	}
	
	public Grupos(String nome, String quantidadeProdutos, String valorTotal) {
		this.nome = new SimpleStringProperty(nome);
		this.quantidadeProdutos = new SimpleStringProperty(quantidadeProdutos);
		this.valorTotal = new SimpleStringProperty(valorTotal);
	}

	public void setNome(String nome) {
		this.nome = new SimpleStringProperty(nome);
	}
	
	public void setQuantidadeProdutos() {
		this.quantidadeProdutos = new SimpleStringProperty(Integer.toString(getListaProdutos().size()));
	}
	
	public void setValorTotal() {
		Double novoValor = 0.0;
		for(Produtos x: getListaProdutos()) {
			novoValor += Double.parseDouble(x.getValor().get());
		}
		this.valorTotal = new SimpleStringProperty(Double.toString(novoValor));
	}
	
	public void setQuantidadeProdutos(String quantidade) {
		this.quantidadeProdutos = new SimpleStringProperty(quantidade);
	}
	
	public void setValorTotal(String valor) {
		this.valorTotal = new SimpleStringProperty(valor);
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

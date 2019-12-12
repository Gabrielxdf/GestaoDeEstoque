package gestaoDeEstoque.model.estoque;

import java.util.List;
import gestaoDeEstoque.util.pesquisa.Pesquisavel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 * Classe modelo do Grupo.
 * @author Gabriel Henrique
 */
public class Grupos implements Pesquisavel{
	private StringProperty quantidadeProdutos;
	private StringProperty nome;
	private StringProperty valorTotal;
	private ObservableList<Produtos> listaProdutos = FXCollections.observableArrayList();
	
	/**
	 * Construtor apenas com o parâmetro do nome.
	 * @param nome
	 */
	public Grupos(String nome) {
		this.nome = new SimpleStringProperty(nome);
		this.quantidadeProdutos = new SimpleStringProperty("0");
		this.valorTotal = new SimpleStringProperty("0");
	}
	
	/**
	 * Construtor do Grupo.
	 * @param nome
	 * @param quantidadeProdutos
	 * @param valorTotal
	 */
	public Grupos(String nome, String quantidadeProdutos, String valorTotal) {
		this.nome = new SimpleStringProperty(nome);
		this.quantidadeProdutos = new SimpleStringProperty(quantidadeProdutos);
		this.valorTotal = new SimpleStringProperty(valorTotal);
	}
	
	/**
	 * Define o nome.
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = new SimpleStringProperty(nome);
	}
	
	/**
	 * Define a quantidade de produtos.
	 */
	public void setQuantidadeProdutos() {
		this.quantidadeProdutos = new SimpleStringProperty(Integer.toString(getListaProdutos().size()));
	}
	
	/**
	 * Define o valor total.
	 */
	public void setValorTotal() {
		Double novoValor = 0.0;
		for(Produtos x: getListaProdutos()) {
			novoValor += Double.parseDouble(x.getValorProperty().get());
		}
		this.valorTotal = new SimpleStringProperty(Double.toString(novoValor));
	}
	
	/**
	 * Define a quantidade.
	 * @param quantidade
	 */
	public void setQuantidadeProdutos(String quantidade) {
		this.quantidadeProdutos = new SimpleStringProperty(quantidade);
	}
	
	/**
	 * Pega a StringProperty do nome.
	 * @return nome
	 */
	public StringProperty getNomeProperty() {
		return nome;
	}
	
	/**
	 * Pega a StringProperty da quantidade de produtos..
	 * @return quantidadeProdutos
	 */
	public StringProperty getQuantidadeProdutosProperty() {
		return quantidadeProdutos;
	}
	
	/**
	 * Pega a StringProperty do valor total.
	 * @return valorTotal
	 */
	public StringProperty getValorTotalProperty() {
		return valorTotal;
	}
	
	/**
	 * Pega a List de produtos.
	 * @return listaProdutos
	 */
	public List<Produtos> getListaProdutos(){
		return listaProdutos;
	}
	
	/**
	 * Pega a String do nome.
	 * @return nome
	 */
	@Override
	public String getNome() {
		return nome.get();
	}
	
	/**
	 * Pega a String do código.
	 * @return null
	 */
	@Override
	public String getCodigo() {
		return null;
	}
	
	/**
	 * método toString.
	 * @return {@link Grupos#getNome()}
	 */
	@Override
	public String toString() {
		return getNome();
	}
	
	/**
	 * Pega a String da quantidade de produtos.
	 * @return quantidadeProdutos
	 */
	public String getQuantidadeProdutos() {
		return quantidadeProdutos.get();
	}
	
	/**
	 * Pega a String do valor total.
	 * @return valorTotal
	 */
	public String getValorTotal() {
		return valorTotal.get();
	}

}

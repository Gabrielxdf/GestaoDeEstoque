package gestaoDeEstoque.model.estoque;

import gestaoDeEstoque.util.pesquisa.Pesquisavel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Produtos implements Pesquisavel{
	private StringProperty nome;
	private Grupos grupo;
	private StringProperty codigo;
	private StringProperty valor;
	private StringProperty codigoBarras;
	private StringProperty estoqueMinimo;
	private StringProperty estoqueIdeal;
	private StringProperty estoqueAtual;
	private Fornecedor fornecedor;
	private StringProperty classificacao;
	private StringProperty descricao;

	public Produtos(String nome, String codigo, String valor, String codigoBarras, String estoqueMinimo,
			String estoqueIdeal, String classificacao, String descricao, Fornecedor fornecedor, Grupos nomeGrupo) {
		this.nome = new SimpleStringProperty(nome);
		this.grupo = nomeGrupo;
		this.codigo = new SimpleStringProperty(codigo);
		this.valor = new SimpleStringProperty(valor);
		this.codigoBarras = new SimpleStringProperty(codigoBarras);
		this.estoqueMinimo = new SimpleStringProperty(estoqueMinimo);
		this.estoqueIdeal = new SimpleStringProperty(estoqueIdeal);
		this.fornecedor = fornecedor;
		this.classificacao = new SimpleStringProperty(classificacao);
		this.descricao = new SimpleStringProperty(descricao);
	}
	
	public StringProperty getNomeProperty() {
		return nome;
	}
	
	public StringProperty getCodigoProperty() {
		return codigo;
	}
	
	public Grupos getGrupo() {
		return grupo;
	}

	public StringProperty getValor() {
		return valor;
	}

	public StringProperty getCodigoBarras() {
		return codigoBarras;
	}

	public StringProperty getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public StringProperty getEstoqueIdeal() {
		return estoqueIdeal;
	}

	public StringProperty getEstoqueAtual() {
		return estoqueAtual;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public StringProperty getClassificacao() {
		return classificacao;
	}

	public StringProperty getDescricao() {
		return descricao;
	}

	public void setNome(StringProperty nome) {
		this.nome = nome;
	}

	public void setGrupo(Grupos grup) {
		this.grupo = grupo;
	}

	public void setCodigo(StringProperty codigo) {
		this.codigo = codigo;
	}

	public void setValor(StringProperty valor) {
		this.valor = valor;
	}

	public void setCodigoBarras(StringProperty codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public void setEstoqueMinimo(StringProperty estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public void setEstoqueIdeal(StringProperty estoqueIdeal) {
		this.estoqueIdeal = estoqueIdeal;
	}

	public void setEstoqueAtual(StringProperty estoqueAtual) {
		this.estoqueAtual = estoqueAtual;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public void setClassificacao(StringProperty classificacao) {
		this.classificacao = classificacao;
	}

	public void setDescricao(StringProperty descricao) {
		this.descricao = descricao;
	}

	@Override
	public String getNome() {
		return nome.get();
	}

	@Override
	public String getCodigo() {
		return codigo.get();
	}

	@Override
	public String toString() {
		return getNome();
	}
	
	
}


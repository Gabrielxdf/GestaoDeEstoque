package gestaoDeEstoque.model.estoque;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Produtos {
	private StringProperty nome;
	private Grupos nomeGrupo;
	private StringProperty codigo;
	private StringProperty valor;
	private StringProperty codigoBarras;
	private StringProperty estoqueMinimo;
	private StringProperty estoqueIdeal;
	private StringProperty estoqueAtual;
	private Fornecedor fornecedor;
	private StringProperty classificacao;
	private StringProperty descricao;

	public Produtos() {
		this(null, null, null, null, null, null, null, null, null, null);
	}
	public Produtos(String nome, String codigo, String valor, String codigoBarras, String estoqueMinimo,
			String estoqueIdeal, String classificacao, String descricao, Fornecedor fornecedor, Grupos nomeGrupo) {
		this.nome = new SimpleStringProperty(nome);
		this.nomeGrupo = nomeGrupo;
		this.codigo = new SimpleStringProperty(codigo);
		this.valor = new SimpleStringProperty(valor);
		this.codigoBarras = new SimpleStringProperty(codigoBarras);
		this.estoqueMinimo = new SimpleStringProperty(estoqueMinimo);
		this.estoqueIdeal = new SimpleStringProperty(estoqueIdeal);
		this.fornecedor = fornecedor;
		this.classificacao = new SimpleStringProperty(classificacao);
		this.descricao = new SimpleStringProperty(descricao);
	}
	// Getters and Setters retornando Strings

	// Getters and Setters retornando Property
	public StringProperty getNome() {
		return nome;
	}

	public void setNome(StringProperty nome) {
		this.nome = nome;
	}

	public Grupos getNomeGrupo() {
		return nomeGrupo;
	}

	public void setNomeGrupo(Grupos nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}

	public StringProperty getCodigo() {
		return codigo;
	}

	public void setCodigo(StringProperty codigo) {
		this.codigo = codigo;
	}

	public StringProperty getValor() {
		return valor;
	}

	public void setValor(StringProperty valor) {
		this.valor = valor;
	}

	public StringProperty getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(StringProperty codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public StringProperty getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(StringProperty estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public StringProperty getEstoqueIdeal() {
		return estoqueIdeal;
	}

	public void setEstoqueIdeal(StringProperty estoqueIdeal) {
		this.estoqueIdeal = estoqueIdeal;
	}

	public StringProperty getEstoqueAtual() {
		return estoqueAtual;
	}

	public void setEstoqueAtual(StringProperty estoqueAtual) {
		this.estoqueAtual = estoqueAtual;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public StringProperty getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(StringProperty classificacao) {
		this.classificacao = classificacao;
	}

	public StringProperty getDescricao() {
		return descricao;
	}

	public void setDescricao(StringProperty descricao) {
		this.descricao = descricao;
	}
}

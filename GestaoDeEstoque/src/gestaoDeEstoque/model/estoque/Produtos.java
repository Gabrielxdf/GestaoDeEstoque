package gestaoDeEstoque.model.estoque;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.StringProperty;

public class Produtos {
	private StringProperty nome;
	private Grupos nomeGrupo;
	private IntegerProperty codigo;
	private DoubleProperty valor;
	private LongProperty codigoBarras;
	private IntegerProperty estoqueMinimo;
	private IntegerProperty estoqueIdeal;
	private IntegerProperty estoqueAtual;
	private Fornecedor fornecedor;
	private StringProperty classificacao;
	private StringProperty descricao;

	public Produtos(StringProperty nome, Grupos nomeGrupo, IntegerProperty codigo, DoubleProperty valor,
			LongProperty codigoBarras, IntegerProperty estoqueMinimo, IntegerProperty estoqueIdeal,
			IntegerProperty estoqueAtual, Fornecedor fornecedor, StringProperty classificacao,
			StringProperty descricao) {
		super();
		this.nome = nome;
		this.nomeGrupo = nomeGrupo;
		this.codigo = codigo;
		this.valor = valor;
		this.codigoBarras = codigoBarras;
		this.estoqueMinimo = estoqueMinimo;
		this.estoqueIdeal = estoqueIdeal;
		this.estoqueAtual = estoqueAtual;
		this.fornecedor = fornecedor;
		this.classificacao = classificacao;
		this.descricao = descricao;
	}

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

	public IntegerProperty getCodigo() {
		return codigo;
	}

	public void setCodigo(IntegerProperty codigo) {
		this.codigo = codigo;
	}

	public DoubleProperty getValor() {
		return valor;
	}

	public void setValor(DoubleProperty valor) {
		this.valor = valor;
	}

	public LongProperty getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(LongProperty codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public IntegerProperty getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(IntegerProperty estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public IntegerProperty getEstoqueIdeal() {
		return estoqueIdeal;
	}

	public void setEstoqueIdeal(IntegerProperty estoqueIdeal) {
		this.estoqueIdeal = estoqueIdeal;
	}

	public IntegerProperty getEstoqueAtual() {
		return estoqueAtual;
	}

	public void setEstoqueAtual(IntegerProperty estoqueAtual) {
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

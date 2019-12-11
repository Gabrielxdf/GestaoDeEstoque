package gestaoDeEstoque.model.estoque;

import javax.xml.bind.annotation.XmlElement;

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
	
	public Produtos() {
		this(null, null, null, null, null, null, null ,null ,null, null);
	}
	
	public Produtos(String classificacao, String codigo, String codigoBarras, String descricao, String estoqueAtual, String estoqueIdeal,
			String estoqueMinimo, Fornecedor fornecedor, Grupos grupo, String nome, String valor) {
		this.nome = new SimpleStringProperty(nome);
		this.grupo = grupo;
		this.codigo = new SimpleStringProperty(codigo);
		this.valor = new SimpleStringProperty(valor);
		this.codigoBarras = new SimpleStringProperty(codigoBarras);
		this.estoqueMinimo = new SimpleStringProperty(estoqueMinimo);
		this.estoqueIdeal = new SimpleStringProperty(estoqueIdeal);
		this.fornecedor = fornecedor;
		this.classificacao = new SimpleStringProperty(classificacao);
		this.descricao = new SimpleStringProperty(descricao);
		this.estoqueAtual = new SimpleStringProperty("0");
	}

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
		this.estoqueAtual = new SimpleStringProperty("0");
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

	public StringProperty getValorProperty() {
		return valor;
	}

	public StringProperty getCodigoBarrasProperty() {
		return codigoBarras;
	}

	public StringProperty getEstoqueMinimoProperty() {
		return estoqueMinimo;
	}

	public StringProperty getEstoqueIdealProperty() {
		return estoqueIdeal;
	}

	public StringProperty getEstoqueAtualProperty() {
		return estoqueAtual;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public StringProperty getClassificacaoProperty() {
		return classificacao;
	}

	public StringProperty getDescricaoProperty() {
		return descricao;
	}

	public void setNome(StringProperty nome) {
		this.nome = nome;
	}

	public void setGrupo(Grupos grupo) {
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
	@XmlElement(name = "nome")
	@Override
	public String getNome() {
		return nome.get();
	}
	@XmlElement(name = "codigo")
	@Override
	public String getCodigo() {
		return codigo.get();
	}

	@XmlElement(name = "valor")
	public String getValor() {
		return valor.get();
	}
	@XmlElement(name = "codigoBarras")
	public String getCodigoBarras() {
		return codigoBarras.get();
	}
	@XmlElement(name = "estoqueMinimo")
	public String getEstoqueMinimo() {
		return estoqueMinimo.get();
	}
	@XmlElement(name = "estoqueIdeal")
	public String getEstoqueIdeal() {
		return estoqueIdeal.get();
	}
	@XmlElement(name = "estoqueAtual")
	public String getEstoqueAtual() {
		return estoqueAtual.get();
	}
	@XmlElement(name = "classificacao")
	public String getClassificacao() {
		return classificacao.get();
	}
	@XmlElement(name = "descricao")
	public String getDescricao() {
		return descricao.get();
	}
	
	@Override
	public String toString() {
		return getNome();
	}
	
	
}


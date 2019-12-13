package gestaoDeEstoque.model.estoque;

import javax.xml.bind.annotation.XmlElement;

import gestaoDeEstoque.util.pesquisa.Pesquisavel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Classe modelo do Produto.
 * 
 * @author Gabriel Henrique
 *
 */
public class Produtos implements Pesquisavel {
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

	/**
	 * Construtor do Produto.
	 * 
	 * @param nome
	 * @param codigo
	 * @param valor
	 * @param codigoBarras
	 * @param estoqueMinimo
	 * @param estoqueIdeal
	 * @param classificacao
	 * @param descricao
	 * @param fornecedor
	 * @param nomeGrupo
	 */
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

	/**
	 * Pega a StringProperty do nome.
	 * 
	 * @return nome
	 */
	public StringProperty getNomeProperty() {
		return nome;
	}

	/**
	 * Pega a StringProperty do código.
	 * 
	 * @return codigo
	 */
	public StringProperty getCodigoProperty() {
		return codigo;
	}

	/**
	 * Pega o Objeto grupo. {@link Grupos}
	 * 
	 * @return grupo
	 */
	public Grupos getGrupo() {
		return grupo;
	}

	/**
	 * Pega a StringProperty do valor.
	 * 
	 * @return valor
	 */
	public StringProperty getValorProperty() {
		return valor;
	}

	/**
	 * Pega a StringProperty do código de barras.
	 * 
	 * @return codigoBarras
	 */
	public StringProperty getCodigoBarrasProperty() {
		return codigoBarras;
	}

	/**
	 * Pega a StringProperty do estoque mínimo.
	 * 
	 * @return estoqueMinimo
	 */
	public StringProperty getEstoqueMinimoProperty() {
		return estoqueMinimo;
	}

	/**
	 * Pega a StringProperty do estoque ideal.
	 * 
	 * @return estoqueIdeal
	 */
	public StringProperty getEstoqueIdealProperty() {
		return estoqueIdeal;
	}

	/**
	 * Pega a StringProperty do estoque atual.
	 * 
	 * @return estoqueAtual
	 */
	public StringProperty getEstoqueAtualProperty() {
		return estoqueAtual;
	}

	/**
	 * Pega o Objeto fornecedor {@link Fornecedor}
	 * 
	 * @return fornecedor
	 */
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	/**
	 * Pega a StringProperty da classificação.
	 * 
	 * @return classificacao
	 */
	public StringProperty getClassificacaoProperty() {
		return classificacao;
	}

	/**
	 * Pega a StringProperty da descrição
	 * 
	 * @return descricao
	 */
	public StringProperty getDescricaoProperty() {
		return descricao;
	}

	/**
	 * Define o nome.
	 * 
	 * @param nome
	 */
	public void setNome(StringProperty nome) {
		this.nome = nome;
	}

	/**
	 * Define o grupo {@link Grupos}.
	 * 
	 * @param grupo
	 */
	public void setGrupo(Grupos grupo) {
		this.grupo = grupo;
	}

	/**
	 * Define o código.
	 * 
	 * @param codigo
	 */
	public void setCodigo(StringProperty codigo) {
		this.codigo = codigo;
	}

	/**
	 * Define o valor.
	 * 
	 * @param valor
	 */
	public void setValor(StringProperty valor) {
		this.valor = valor;
	}

	/**
	 * Define o código de barras.
	 * 
	 * @param codigoBarras
	 */
	public void setCodigoBarras(StringProperty codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	/**
	 * Define o estoque mínimo.
	 * 
	 * @param estoqueMinimo
	 */
	public void setEstoqueMinimo(StringProperty estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	/**
	 * Define o estoque ideal.
	 * 
	 * @param estoqueIdeal
	 */
	public void setEstoqueIdeal(StringProperty estoqueIdeal) {
		this.estoqueIdeal = estoqueIdeal;
	}

	/**
	 * Define o estoque atual.
	 * 
	 * @param estoqueAtual
	 */
	public void setEstoqueAtual(StringProperty estoqueAtual) {
		this.estoqueAtual = estoqueAtual;
	}

	/**
	 * Define o Fornecedor {@link Fornecedor}.
	 * 
	 * @param fornecedor
	 */
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	/**
	 * Define a classificação.
	 * 
	 * @param classificacao
	 */
	public void setClassificacao(StringProperty classificacao) {
		this.classificacao = classificacao;
	}

	/**
	 * Define a descrição
	 * 
	 * @param descricao
	 */
	public void setDescricao(StringProperty descricao) {
		this.descricao = descricao;
	}

	/**
	 * Pega a String do nome.
	 * 
	 * @return nome
	 */
	@XmlElement(name = "nome")
	@Override
	public String getNome() {
		return nome.get();
	}

	/**
	 * Pega a String do código.
	 * 
	 * @return codigo
	 */
	@XmlElement(name = "codigo")
	@Override
	public String getCodigo() {
		return codigo.get();
	}

	/**
	 * Pega a String do valor.
	 * 
	 * @return valor
	 */
	@XmlElement(name = "valor")
	public String getValor() {
		return valor.get();
	}

	/**
	 * Pega a String do código de barras.
	 * 
	 * @return codigoBarras
	 */
	@XmlElement(name = "codigoBarras")
	public String getCodigoBarras() {
		return codigoBarras.get();
	}

	/**
	 * Pega a String do estoque mínimo.
	 * 
	 * @return estoqueMinimo
	 */
	@XmlElement(name = "estoqueMinimo")
	public String getEstoqueMinimo() {
		return estoqueMinimo.get();
	}

	/**
	 * Pega a String do estoque ideal.
	 * 
	 * @return estoqueIdeal
	 */
	@XmlElement(name = "estoqueIdeal")
	public String getEstoqueIdeal() {
		return estoqueIdeal.get();
	}

	/**
	 * Pega a String do estoque atual.
	 * 
	 * @return estoqueAtual
	 */
	@XmlElement(name = "estoqueAtual")
	public String getEstoqueAtual() {
		return estoqueAtual.get();
	}

	/**
	 * Pega a String da classificação.
	 * 
	 * @return classificacao
	 */
	@XmlElement(name = "classificacao")
	public String getClassificacao() {
		return classificacao.get();
	}

	/**
	 * Pega a String da descrição.
	 * 
	 * @return descricao
	 */
	@XmlElement(name = "descricao")
	public String getDescricao() {
		return descricao.get();
	}

	/**
	 * Método toString.
	 * 
	 * @return {@link Produtos#getNome()}
	 */
	@Override
	public String toString() {
		return getNome();
	}

}

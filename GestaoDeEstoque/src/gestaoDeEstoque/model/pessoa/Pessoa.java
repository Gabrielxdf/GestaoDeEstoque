package gestaoDeEstoque.model.pessoa;

import java.time.LocalDate;

import gestaoDeEstoque.util.DateUtil;
import gestaoDeEstoque.util.pesquisa.Pesquisavel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Classe modelo da Pessoa.
 * 
 * @author Gabriel
 *
 */
public abstract class Pessoa implements Pesquisavel {
	private StringProperty codigo;
	private StringProperty nome;
	private ObjectProperty<LocalDate> dataNascimento;
	private StringProperty email;

	/**
	 * Construtor da Pessoa.
	 * 
	 * @param codigo
	 * @param nome
	 * @param email
	 * @param localdate
	 */
	public Pessoa(String codigo, String nome, String email, LocalDate localdate) {
		// public Pessoa(String codigo, String nome, String email, int ano, int mes, int
		// dia)
		this.codigo = new SimpleStringProperty(codigo);
		this.nome = new SimpleStringProperty(nome);
		this.email = new SimpleStringProperty(email);
		// this.dataNascimento = new SimpleObjectProperty<LocalDate>(LocalDate.of(ano,
		// mes, dia));
		this.dataNascimento = new SimpleObjectProperty<LocalDate>(localdate);
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
	 * Define o código.
	 * 
	 * @param codigo
	 */
	public void setCodigo(StringProperty codigo) {
		this.codigo = codigo;
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
	 * Define o nome.
	 * 
	 * @param nome
	 */
	public void setNome(StringProperty nome) {
		this.nome = nome;
	}

	/**
	 * Pega o LocalDate da data de nascimento.
	 * 
	 * @return dataNascimento
	 */
	public LocalDate getDataNascimentoProperty() {
		return dataNascimento.get();
	}

	/**
	 * Pega a StringProperty da data de nascimento.
	 * 
	 * @return dataNascimento
	 */
	public StringProperty getDataNascimentoStringProperty() {
		return new SimpleStringProperty(DateUtil.format(getDataNascimentoProperty()));
	}

	/**
	 * Define a data de nascimento.
	 * 
	 * @param dataNascimento
	 */
	public void setDataNascimento(ObjectProperty<LocalDate> dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * Prga a StringPropert do e-mail.
	 * 
	 * @return email
	 */
	public StringProperty getEmailProperty() {
		return email;
	}

	/**
	 * Define o e-mail.
	 * 
	 * @param email
	 */
	public void setEmail(StringProperty email) {
		this.email = email;
	}

	/**
	 * Pega a String do nome.
	 * 
	 * @return nome
	 */
	@Override
	public String getNome() {
		return nome.get();
	}

	/**
	 * Pega a String do código.
	 * 
	 * @return codigo
	 */
	@Override
	public String getCodigo() {
		return codigo.get();
	}

	/**
	 * Método toString.
	 * 
	 * @return {@link Pessoa#getNome()}
	 */
	@Override
	public String toString() {
		return getNome();
	}

}

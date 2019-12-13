package gestaoDeEstoque.util;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import gestaoDeEstoque.model.estoque.Fornecedor;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Classe de Telefones para ser usada em composição.
 * 
 * @author Gabriel Henrique
 *
 */
public class Telefones {
	private List<StringProperty> telefonesFornecedores = new ArrayList<>();
	private StringProperty celular;
	private StringProperty residencial;

	/**
	 * Construtor dos Telefones com os argumentos celular e residêncial.
	 * 
	 * @param celular
	 * @param residencial
	 */
	public Telefones(StringProperty celular, String residencial) {
		this.celular = celular;
		this.residencial = new SimpleStringProperty(residencial);
	}

	/**
	 * Construtor dos Telefones com um Array de Strings.
	 * 
	 * @param celular
	 * @param residencial
	 */
	public Telefones(String... telefone) {
		this.telefonesFornecedores = new ArrayList<StringProperty>();

		for (int x = 0; x < telefone.length; x++) {
			telefonesFornecedores.add(x, new SimpleStringProperty(telefone[x]));
		}

	}

	/**
	 * Pega a StringProperty do telefone celular.
	 * 
	 * @return celular
	 */
	public StringProperty getCelularProperty() {
		return this.celular;
	}

	/**
	 * Define o telefone celular.
	 * 
	 * @param celular
	 */
	public void setCelular(StringProperty celular) {
		this.celular = celular;
	}

	/**
	 * Pega a StringProperty do telefone residêncial.
	 * 
	 * @return residencial
	 */
	public StringProperty getResidencialProperty() {
		return residencial;
	}

	/**
	 * Define o telefone residêncial.
	 * 
	 * @param residencial
	 */
	public void setResidencial(StringProperty residencial) {
		this.residencial = residencial;
	}

	/**
	 * Pega a List de StringProperty do Telefones dos Fornecedores
	 * {@link Fornecedor}.
	 * 
	 * @return telefonesFornecedores
	 */
	public List<StringProperty> getTelefonesFornecedoresProperty() {
		return telefonesFornecedores;
	}

	/**
	 * Define a List de Telefones dos Fornecedores {@link Fornecedor}.
	 * 
	 * @param telefonesFornecedores
	 */
	public void setTelefonesFornecedores(List<StringProperty> telefonesFornecedores) {
		this.telefonesFornecedores = telefonesFornecedores;
	}

	/**
	 * Pega a List de String do Telefones dos Fornecedores {@link Fornecedor}.
	 * 
	 * @return lista
	 */
	@XmlElement(name = "telefoneFornecedores")
	public List<String> getTelefonesFornecedores() {
		List<String> lista = new ArrayList<>();
		for (StringProperty x : getTelefonesFornecedoresProperty()) {
			lista.add(x.get());
		}
		return lista;
	}

	/**
	 * Pega a String do telefone celular.
	 * 
	 * @return celular
	 */
	@XmlElement(name = "celular")
	public String getCelular() {
		return celular.get();
	}

	/**
	 * Pega a String do telefone residêncial.
	 * 
	 * @return residencial
	 */
	@XmlElement(name = "residencial")
	public String getResidencial() {
		return residencial.get();
	}

}

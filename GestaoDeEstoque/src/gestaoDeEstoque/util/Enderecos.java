package gestaoDeEstoque.util;

import javax.xml.bind.annotation.XmlElement;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Classe de Endereços para ser usada em composições.
 * 
 * @author Gabriel Henrique
 *
 */
public class Enderecos {
	private StringProperty cep;
	private StringProperty bairro;
	private StringProperty cidade;
	private StringProperty estado;
	private StringProperty endereco;

	/**
	 * Construtor do Endereço.
	 * 
	 * @param cep
	 * @param bairro
	 * @param cidade
	 * @param endereco
	 * @param estado
	 */
	public Enderecos(String cep, String bairro, String cidade, String endereco, String estado) {
		this.cep = new SimpleStringProperty(cep);
		this.bairro = new SimpleStringProperty(bairro);
		this.cidade = new SimpleStringProperty(cidade);
		this.estado = new SimpleStringProperty(estado);
		this.endereco = new SimpleStringProperty(endereco);
	}

	/**
	 * Pega a StringProperty do cep.
	 * 
	 * @return cep
	 */
	public StringProperty getCepProperty() {
		return cep;
	}

	public void setCep(StringProperty cep) {
		this.cep = cep;
	}

	/**
	 * Pega a StringProperty do bairro.
	 * 
	 * @return bairro
	 */
	public StringProperty getBairroProperty() {
		return bairro;
	}

	/**
	 * Define o bairro.
	 * 
	 * @param bairro
	 */
	public void setBairro(StringProperty bairro) {
		this.bairro = bairro;
	}

	/**
	 * Pega a StringProperty da cidade.
	 * 
	 * @return cidade
	 */
	public StringProperty getCidadeProperty() {
		return cidade;
	}

	/**
	 * Define a cidade.
	 * 
	 * @param cidade
	 */
	public void setCidade(StringProperty cidade) {
		this.cidade = cidade;
	}

	/**
	 * Pega a StringProperty do estado.
	 * 
	 * @return estado
	 */
	public StringProperty getEstadoProperty() {
		return estado;
	}

	/**
	 * Define o estado.
	 * 
	 * @param estado
	 */
	public void setEstado(StringProperty estado) {
		this.estado = estado;
	}

	/**
	 * Pega a StringProperty do endereço.
	 * 
	 * @return endereco
	 */
	public StringProperty getEnderecoProperty() {
		return endereco;
	}

	/**
	 * Define o endereço.
	 * 
	 * @param endereco
	 */
	public void setEndereco(StringProperty endereco) {
		this.endereco = endereco;
	}

	/**
	 * Pega a String do cep.
	 * 
	 * @return cep
	 */
	@XmlElement(name = "cep")
	public String getCep() {
		return cep.get();
	}

	/**
	 * Pega a String do bairro.
	 * 
	 * @return bairro
	 */
	@XmlElement(name = "bairro")
	public String getBairro() {
		return bairro.get();
	}

	/**
	 * Pega a String da cidade.
	 * 
	 * @return cidade
	 */
	@XmlElement(name = "cidade")
	public String getCidade() {
		return cidade.get();
	}

	/**
	 * Pega a String do estado.
	 * 
	 * @return estado
	 */
	@XmlElement(name = "estado")
	public String getEstado() {
		return estado.get();
	}

	/**
	 * Pega a String do endereço.
	 * 
	 * @return endereco
	 */
	@XmlElement(name = "endereco")
	public String getEndereco() {
		return endereco.get();
	}
}

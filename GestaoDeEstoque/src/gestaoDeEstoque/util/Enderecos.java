package gestaoDeEstoque.util;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Enderecos {
	private StringProperty cep;
	private StringProperty bairro;
	private StringProperty cidade;
	private StringProperty estado;
	private StringProperty endereco;

	public Enderecos(String cep, String bairro, String cidade, String endereco,
			String estado) {
		this.cep = new SimpleStringProperty(cep);
		this.bairro = new SimpleStringProperty(bairro);
		this.cidade = new SimpleStringProperty(cidade);
		this.estado = new SimpleStringProperty(estado);
		this.endereco = new SimpleStringProperty(endereco);
	}

	public StringProperty getCepProperty() {
		return cep;
	}

	public void setCep(StringProperty cep) {
		this.cep = cep;
	}

	public StringProperty getBairroProperty() {
		return bairro;
	}

	public void setBairro(StringProperty bairro) {
		this.bairro = bairro;
	}

	public StringProperty getCidadeProperty() {
		return cidade;
	}

	public void setCidade(StringProperty cidade) {
		this.cidade = cidade;
	}

	public StringProperty getEstadoProperty() {
		return estado;
	}

	public void setEstado(StringProperty estado) {
		this.estado = estado;
	}

	public StringProperty getEnderecoProperty() {
		return endereco;
	}

	public void setEndereco(StringProperty endereco) {
		this.endereco = endereco;
	}

}

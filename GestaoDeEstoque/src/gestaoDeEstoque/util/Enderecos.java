package gestaoDeEstoque.util;

import javafx.beans.property.StringProperty;

public class Enderecos {
	private StringProperty cep;
	private StringProperty bairro;
	private StringProperty cidade;
	private StringProperty estado;
	private StringProperty endereco;

	public Enderecos(StringProperty cep, StringProperty bairro, StringProperty cidade, StringProperty estado,
			StringProperty endereco) {
		super();
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.endereco = endereco;
	}

	public StringProperty getCep() {
		return cep;
	}

	public void setCep(StringProperty cep) {
		this.cep = cep;
	}

	public StringProperty getBairro() {
		return bairro;
	}

	public void setBairro(StringProperty bairro) {
		this.bairro = bairro;
	}

	public StringProperty getCidade() {
		return cidade;
	}

	public void setCidade(StringProperty cidade) {
		this.cidade = cidade;
	}

	public StringProperty getEstado() {
		return estado;
	}

	public void setEstado(StringProperty estado) {
		this.estado = estado;
	}

	public StringProperty getEndereco() {
		return endereco;
	}

	public void setEndereco(StringProperty endereco) {
		this.endereco = endereco;
	}

}

package gestaoDeEstoque.model.estoque;

import gestaoDeEstoque.util.Enderecos;
import gestaoDeEstoque.util.Telefones;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Fornecedor {
	private StringProperty fornecedor;
	private StringProperty cnpj;
	private StringProperty codigo;
	private StringProperty email;
	private Telefones telefone;
	private Enderecos endereco;

	public Fornecedor(String fornecedor, String cnpj, String codigo, String email, Telefones telefone,
			Enderecos endereco) {
		super();
		this.fornecedor = new SimpleStringProperty(fornecedor);
		this.cnpj = new SimpleStringProperty(cnpj);
		this.codigo = new SimpleStringProperty(codigo);
		this.email = new SimpleStringProperty(email);
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public StringProperty getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(StringProperty fornecedor) {
		this.fornecedor = fornecedor;
	}

	public StringProperty getCnpj() {
		return cnpj;
	}

	public void setCnpj(StringProperty cnpj) {
		this.cnpj = cnpj;
	}

	public StringProperty getCodigo() {
		return codigo;
	}

	public void setCodigo(StringProperty codigo) {
		this.codigo = codigo;
	}

	public StringProperty getEmail() {
		return email;
	}

	public void setEmail(StringProperty email) {
		this.email = email;
	}

	public Telefones getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefones telefone) {
		this.telefone = telefone;
	}

	public Enderecos getEndereco() {
		return endereco;
	}

	public void setEndereco(Enderecos endereco) {
		this.endereco = endereco;
	}

}

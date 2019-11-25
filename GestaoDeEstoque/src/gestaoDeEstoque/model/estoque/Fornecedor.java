package gestaoDeEstoque.model.estoque;

import gestaoDeEstoque.util.Enderecos;
import gestaoDeEstoque.util.Telefones;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Fornecedor {
	private StringProperty fornecedor;
	private StringProperty cnpj;
	private IntegerProperty codigo;
	private StringProperty email;
	private Telefones telefone;
	private Enderecos endereco;

	public Fornecedor(StringProperty fornecedor, StringProperty cnpj, IntegerProperty codigo, StringProperty email,
			Telefones telefone, Enderecos endereco) {
		super();
		this.fornecedor = fornecedor;
		this.cnpj = cnpj;
		this.codigo = codigo;
		this.email = email;
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

	public IntegerProperty getCodigo() {
		return codigo;
	}

	public void setCodigo(IntegerProperty codigo) {
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

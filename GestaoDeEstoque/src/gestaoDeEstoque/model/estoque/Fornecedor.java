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
	private StringProperty razaoSocial;
	private Telefones telefone;
	private Enderecos endereco;

	public Fornecedor(String fornecedor, String cnpj, String codigo, String email, Telefones telefone,
			Enderecos endereco, String razao) {
		super();
		this.fornecedor = new SimpleStringProperty(fornecedor);
		this.cnpj = new SimpleStringProperty(cnpj);
		this.codigo = new SimpleStringProperty(codigo);
		this.email = new SimpleStringProperty(email);
		this.telefone = telefone;
		this.endereco = endereco;
		this.razaoSocial = new SimpleStringProperty(razao);
	}

	public StringProperty getRazaoSocialProperty() {
		return razaoSocial;
	}

	public void setRazaoSocial(StringProperty razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public StringProperty getFornecedorProperty() {
		return fornecedor;
	}

	public void setFornecedor(StringProperty fornecedor) {
		this.fornecedor = fornecedor;
	}

	public StringProperty getCnpjProperty() {
		return cnpj;
	}

	public void setCnpj(StringProperty cnpj) {
		this.cnpj = cnpj;
	}

	public StringProperty getCodigoProperty() {
		return codigo;
	}

	public void setCodigo(StringProperty codigo) {
		this.codigo = codigo;
	}

	public StringProperty getEmailProperty() {
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

package GestaoDeEstoque.model.pessoa;

import gestaoDeEstoque.util.Enderecos;
import gestaoDeEstoque.util.Telefones;
import javafx.beans.property.StringProperty;

public class Cliente extends Pessoa {

	private StringProperty cpf;
	private Enderecos endereco;
	private Telefones telefone;

	public Cliente(Integer codigo, String nome, String email) {
		super(codigo, nome, email);
	}

	public Cliente(Integer codigo, String nome, StringProperty cpf, Enderecos endereco, Telefones telefone,
			String email) {
		super(codigo, nome, email);
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public StringProperty getCpf() {
		return cpf;
	}

	public void setCpf(StringProperty cpf) {
		this.cpf = cpf;
	}

	public Enderecos getEndereco() {
		return endereco;
	}

	public void setEndereco(Enderecos endereco) {
		this.endereco = endereco;
	}

	public Telefones getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefones telefone) {
		this.telefone = telefone;
	}


}

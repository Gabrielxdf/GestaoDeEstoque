package gestaoDeEstoque.model.pessoa;

import java.time.LocalDate;

import gestaoDeEstoque.util.Enderecos;
import gestaoDeEstoque.util.Telefones;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Cliente extends Pessoa {

	private StringProperty cpf;
	private Enderecos endereco;
	private Telefones telefone;


	public Cliente(String codigo, String nome, String cpf, Enderecos endereco, Telefones telefone,
			String email, LocalDate dataNascimento) {
		super(codigo, nome, email, dataNascimento);
		this.cpf = new SimpleStringProperty(cpf);
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

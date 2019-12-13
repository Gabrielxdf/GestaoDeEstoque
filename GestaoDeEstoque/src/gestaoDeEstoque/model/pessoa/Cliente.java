package gestaoDeEstoque.model.pessoa;

import java.time.LocalDate;
import gestaoDeEstoque.util.Enderecos;
import gestaoDeEstoque.util.Telefones;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Classe modelo do Cliente.
 * 
 * @author Gabriel Henrique
 */
public class Cliente extends Pessoa {

	private StringProperty cpf;
	private Enderecos endereco;
	private Telefones telefone;

	/**
	 * Construtor do Cliente.
	 * 
	 * @param codigo
	 * @param nome
	 * @param cpf
	 * @param endereco
	 * @param telefone
	 * @param email
	 * @param dataNascimento
	 */
	public Cliente(String codigo, String nome, String cpf, Enderecos endereco, Telefones telefone, String email,
			LocalDate dataNascimento) {
		super(codigo, nome, email, dataNascimento);
		this.cpf = new SimpleStringProperty(cpf);
		this.endereco = endereco;
		this.telefone = telefone;
	}

	/**
	 * Pega a StringProperty do cpf.
	 * 
	 * @return cpf
	 */
	public StringProperty getCpfProperty() {
		return cpf;
	}

	/**
	 * Define o cpf.
	 * 
	 * @param cpf
	 */
	public void setCpf(StringProperty cpf) {
		this.cpf = cpf;
	}

	/**
	 * Pega o Objeto endereço {@link Enderecos}.
	 * 
	 * @return endereco
	 */
	public Enderecos getEndereco() {
		return endereco;
	}

	/**
	 * Define o endereço {@link Enderecos}.
	 * 
	 * @param endereco
	 */
	public void setEndereco(Enderecos endereco) {
		this.endereco = endereco;
	}

	/**
	 * Pega o Objeto telefone {@link Telefones}.
	 * 
	 * @return telefone
	 */
	public Telefones getTelefone() {
		return telefone;
	}

	/**
	 * Define o telefone {@link Telefones}.
	 * 
	 * @param telefone
	 */
	public void setTelefone(Telefones telefone) {
		this.telefone = telefone;
	}

}

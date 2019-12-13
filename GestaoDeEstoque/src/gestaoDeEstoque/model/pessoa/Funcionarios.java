package gestaoDeEstoque.model.pessoa;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Classe modelo do Funcionário.
 * 
 * @author Gabriel Henrique
 *
 */
public class Funcionarios extends Pessoa {

	private StringProperty usuario;
	private StringProperty senha;
	private StringProperty confirmaSenha;

	/**
	 * Construtor do Funcionário.
	 * 
	 * @param codigo
	 * @param nome
	 * @param email
	 * @param usuario
	 * @param senha
	 * @param confirmaSenha
	 */
	public Funcionarios(String codigo, String nome, String email, String usuario, String senha, String confirmaSenha) {
		super(codigo, nome, email, null);
		this.usuario = new SimpleStringProperty(usuario);
		this.senha = new SimpleStringProperty(senha);
		this.confirmaSenha = new SimpleStringProperty(confirmaSenha);
	}

	/**
	 * Pega a StringProperty do usuário.
	 * 
	 * @return usuario
	 */
	public StringProperty getUsuario() {
		return usuario;
	}

	/**
	 * Define o usuario.
	 * 
	 * @param usuario
	 */
	public void setUsuario(StringProperty usuario) {
		this.usuario = usuario;
	}

	/**
	 * Pega a StringProperty da senha.
	 * 
	 * @return senha
	 */
	public StringProperty getSenha() {
		return senha;
	}

	/**
	 * Define a senha.
	 * 
	 * @param senha
	 */
	public void setSenha(StringProperty senha) {
		this.senha = senha;
	}

	/**
	 * Pega a StringProperty da confirmação da senha.
	 * 
	 * @return confirmaSenha
	 */
	public StringProperty getConfirmaSenha() {
		return confirmaSenha;
	}

	/**
	 * Define a confirmação da senha.
	 * 
	 * @param confirmaSenha
	 */
	public void setConfirmaSenha(StringProperty confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

}

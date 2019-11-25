package gestaoDeEstoque.model.pessoa;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Funcionarios extends Pessoa {

	private StringProperty usuario;
	private StringProperty senha;
	private StringProperty senhaAcesso;

	public Funcionarios(Integer codigo, String nome, String email) {
		super(codigo, nome, email);
	}

	public Funcionarios(Integer codigo, String nome, String email, StringProperty usuario, StringProperty senha,
			StringProperty senhaAcesso) {
		super(codigo, nome, email);
		this.usuario = usuario;
		this.senha = senha;
		this.senhaAcesso = senhaAcesso;
	}

	public StringProperty getUsuario() {
		return usuario;
	}

	public void setUsuario(StringProperty usuario) {
		this.usuario = usuario;
	}

	public StringProperty getSenha() {
		return senha;
	}

	public void setSenha(StringProperty senha) {
		this.senha = senha;
	}

	public StringProperty getSenhaAcesso() {
		return senhaAcesso;
	}

	public void setSenhaAcesso(StringProperty senhaAcesso) {
		this.senhaAcesso = senhaAcesso;
	}

}

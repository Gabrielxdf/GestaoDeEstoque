package gestaoDeEstoque.model.pessoa;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Funcionarios extends Pessoa {

	private StringProperty usuario;
	private StringProperty senha;
	private StringProperty confirmaSenha;


	public Funcionarios(String codigo, String nome, String email, String usuario, String senha,
			String confirmaSenha) {
		super(codigo, nome, email, null);
		this.usuario = new SimpleStringProperty(usuario);
		this.senha = new SimpleStringProperty(senha);
		this.confirmaSenha = new SimpleStringProperty(confirmaSenha);
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

	public StringProperty getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(StringProperty confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

}

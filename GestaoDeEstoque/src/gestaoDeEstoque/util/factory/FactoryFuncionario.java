package gestaoDeEstoque.util.factory;

import gestaoDeEstoque.model.pessoa.Funcionarios;
import gestaoDeEstoque.util.Verifica;

public class FactoryFuncionario {
	private static String errorMessage = "";
	public static Funcionarios getFuncionario(String codigo, String nome, String email, String usuario, String senha,
			String confirmaSenha) {
		Funcionarios retorno = null;
		if (Verifica.stringVazia(codigo) && Verifica.stringVazia(nome) && Verifica.stringVazia(email)
				&& Verifica.stringVazia(email) && Verifica.stringVazia(usuario) && Verifica.stringVazia(senha)
				&& Verifica.stringVazia(confirmaSenha)) {
			retorno = new Funcionarios(codigo, nome, email, usuario, senha, confirmaSenha);
		}
		return retorno;
	}
	public static String getErrorMessage() {
		return errorMessage;
	}
}

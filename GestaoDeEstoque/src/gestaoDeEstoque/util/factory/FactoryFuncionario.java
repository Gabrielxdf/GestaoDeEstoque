package gestaoDeEstoque.util.factory;

import gestaoDeEstoque.model.pessoa.Funcionarios;
import gestaoDeEstoque.util.Verifica;

public class FactoryFuncionario {
	private static String errorMessage = "";
	public static Funcionarios getFuncionario(String codigo, String email, String nome, String usuario, String senha,
			String confirmaSenha) {
		Funcionarios retorno = null;
		if (!Verifica.stringVazia(codigo) && !Verifica.stringVazia(nome) && !Verifica.stringVazia(email)
				&& !Verifica.stringVazia(email) && !Verifica.stringVazia(usuario) && !Verifica.stringVazia(senha)
				&& !Verifica.stringVazia(confirmaSenha)) {
			retorno = new Funcionarios(codigo, nome, email, usuario, senha, confirmaSenha);
		}else {
			errorMessage += "Alguns campos estão vazios.\n";
		}
		return retorno;
	}
	public static String getErrorMessage() {
		return errorMessage;
	}
}

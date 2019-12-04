package gestaoDeEstoque.util.factory;

import gestaoDeEstoque.model.estoque.Grupos;
import gestaoDeEstoque.util.Verifica;

public class FactoryGrupos {

	public static Grupos getGrupo(String nome) {
		Grupos retorno = null;
		if (Verifica.stringVazia(nome)) {
			retorno = new Grupos(nome);
		}
		return retorno;
	}
}

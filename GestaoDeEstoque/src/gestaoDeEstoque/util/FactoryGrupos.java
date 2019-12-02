package gestaoDeEstoque.util;

import gestaoDeEstoque.model.estoque.Grupos;

public class FactoryGrupos {

	public static Grupos getGrupo(String nome) {
		Grupos retorno = null;
		if(nome.length() != 0) {
			retorno = new Grupos(nome);
		}
		return retorno;
	}
}

package gestaoDeEstoque.util.factory;

import gestaoDeEstoque.model.estoque.Grupos;
import gestaoDeEstoque.util.Verifica;
import gestaoDeEstoque.util.exception.DadosInvalidosException;

public class FactoryGrupos {
	
	public static Grupos getGrupo(String nome) throws DadosInvalidosException{
		Grupos retorno = null;
		String errorMessage = "";
				
		if (Verifica.stringVazia(nome)) {
			errorMessage += "O nome não pode estar vazio!";
		}
		if(errorMessage.length()>0) {
			throw new DadosInvalidosException(errorMessage);
		}else {
			retorno = new Grupos(nome);
		}
		return retorno;
	}
}

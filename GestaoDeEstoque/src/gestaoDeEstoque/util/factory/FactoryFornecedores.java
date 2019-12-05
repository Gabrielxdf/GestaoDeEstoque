package gestaoDeEstoque.util.factory;

import gestaoDeEstoque.model.estoque.Fornecedor;
import gestaoDeEstoque.util.Enderecos;
import gestaoDeEstoque.util.Telefones;
import gestaoDeEstoque.util.Verifica;
/**
 * Fábrica de Objetos Fornecedores.
 * @author Gabriel Henrique
 *
 */
public class FactoryFornecedores {
	private static String errorMessage = "";
	public static Fornecedor getFornecedor(String fornecedor, String cnpj, String codigo, String email,
			Telefones telefone, Enderecos endereco, String razao) {
		
		Fornecedor retorno = null;
		
		if (!Verifica.stringVazia(fornecedor) && !Verifica.stringVazia(codigo)
				&& !Verifica.stringVazia(email) && !Verifica.objetoNulo(telefone) &&
				!Verifica.objetoNulo(endereco)) {
			
			retorno = new Fornecedor(fornecedor, cnpj, codigo, email, telefone, endereco, razao);
		}else {
			
			errorMessage += "Alguns campos estão vazios.\n";
		}
		return retorno;
	}
	public static String getErrorMessage() {
		return errorMessage;
	}
}

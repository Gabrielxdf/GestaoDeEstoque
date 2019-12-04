package gestaoDeEstoque.util.factory;

import gestaoDeEstoque.model.estoque.Fornecedor;
import gestaoDeEstoque.util.Enderecos;
import gestaoDeEstoque.util.Telefones;
import gestaoDeEstoque.util.Verifica;

public class FactoryFornecedores {
	private static String errorMessage = "";
	public static Fornecedor getFornecedores(String fornecedor, String cnpj, String codigo, String email,
			Telefones telefone, Enderecos endereco) {
		Fornecedor retorno = null;
		if (Verifica.stringVazia(fornecedor) && Verifica.stringVazia(cnpj) && Verifica.stringVazia(codigo)
				&& Verifica.stringVazia(email) && Verifica.objetoNulo(telefone) && Verifica.objetoNulo(endereco)) {
			retorno = new Fornecedor(fornecedor, cnpj, codigo, email, telefone, endereco);
		}
		return retorno;
	}
	public static String getErrorMessage() {
		return errorMessage;
	}
}

package gestaoDeEstoque.util.factory;

import gestaoDeEstoque.model.estoque.Fornecedor;
import gestaoDeEstoque.util.Enderecos;
import gestaoDeEstoque.util.Telefones;
import gestaoDeEstoque.util.Verifica;

public class FactoryFornecedores {
	public static Fornecedor getFornecedores(String fornecedor, String cnpj, String codigo, String email,
			Telefones telefone, Enderecos endereco) {
		Fornecedor retorno = null;
		if (Verifica.stringVazia(fornecedor) && Verifica.stringVazia(cnpj) && Verifica.stringVazia(codigo)
				&& Verifica.stringVazia(email) && Verifica.objetoVazio(telefone) && Verifica.objetoVazio(endereco)) {
			retorno = new Fornecedor(fornecedor, cnpj, codigo, email, telefone, endereco);
		}
		return retorno;
	}
}

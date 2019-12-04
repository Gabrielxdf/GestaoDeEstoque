package gestaoDeEstoque.util.factory;

import gestaoDeEstoque.model.pessoa.Cliente;
import gestaoDeEstoque.util.DateUtil;
import gestaoDeEstoque.util.Enderecos;
import gestaoDeEstoque.util.Telefones;
import gestaoDeEstoque.util.Verifica;

public class FactoryClientes {
	private static String errorMessage = "";
	public static Cliente getCliente(String codigo, String nome, String cpf, Enderecos endereco, Telefones telefone,
			String email, String dataNascimento) {
		String errorMessage = "";
		Cliente retorno = null;
		if (Verifica.stringVazia(codigo) && Verifica.stringVazia(nome) && Verifica.stringVazia(email)
				&& Verifica.stringVazia(dataNascimento) && Verifica.objetoNulo(telefone)
				&& Verifica.objetoNulo(endereco)) {
			if (!DateUtil.validDate(dataNascimento)) {
				errorMessage += "Data de Nascimento inválida, use o formato dd/mm/aaaa!\n";
			} else {
				retorno = new Cliente(codigo, nome, cpf, endereco, telefone, email, DateUtil.parse(dataNascimento));
			}
		}
		return retorno;
	}
	public static String getErrorMessage() {
		return errorMessage;
	}
}

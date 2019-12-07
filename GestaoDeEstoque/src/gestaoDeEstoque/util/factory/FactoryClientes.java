package gestaoDeEstoque.util.factory;

import gestaoDeEstoque.model.pessoa.Cliente;
import gestaoDeEstoque.util.DateUtil;
import gestaoDeEstoque.util.Enderecos;
import gestaoDeEstoque.util.Telefones;
import gestaoDeEstoque.util.Verifica;

public class FactoryClientes {

	public static Cliente getCliente(String nome, String cpf, String codigo, String email, Telefones telefone,
			Enderecos endereco, String dataNascimento) {
		Cliente retorno = null;
		if (!Verifica.stringVazia(codigo) && !Verifica.stringVazia(nome) && !Verifica.stringVazia(email) && !Verifica.objetoNulo(telefone)
				&& !Verifica.objetoNulo(endereco)) {
			if (!DateUtil.validDate(dataNascimento)) {
				
			} else {
				retorno = new Cliente(codigo, nome, cpf, endereco, telefone, email, DateUtil.parse(dataNascimento));
			}
		}
		return retorno;
	}
}

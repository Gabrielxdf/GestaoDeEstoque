package gestaoDeEstoque.util.factory;

import gestaoDeEstoque.model.pessoa.Cliente;
import gestaoDeEstoque.util.DateUtil;
import gestaoDeEstoque.util.Enderecos;
import gestaoDeEstoque.util.Estados;
import gestaoDeEstoque.util.Telefones;
import gestaoDeEstoque.util.Verifica;
import javafx.scene.control.ComboBox;

public class FactoryClientes {

	public static Cliente getCliente(String nome, String cpf, String codigo, String email, Telefones telefone,
		 String dataNascimento, String cep, String endereço, String cidade, String bairro, ComboBox<Estados> estados) {
		Cliente retorno = null;
		if (!Verifica.stringVazia(codigo) && !Verifica.stringVazia(nome) && !Verifica.stringVazia(email) && !Verifica.objetoNulo(telefone)
				&& !Verifica.stringVazia(cep) && !Verifica.stringVazia(endereço) && !Verifica.stringVazia(cidade)
				&& !Verifica.stringVazia(bairro) && !Verifica.comboBoxSemSeleção(estados)) {
			
			if (!DateUtil.validDate(dataNascimento)) {
				
			} else {
				retorno = new Cliente(codigo, nome, cpf, new Enderecos(cep, bairro, cidade, endereço, 
						estados.getSelectionModel().getSelectedItem().toString()), telefone, email, DateUtil.parse(dataNascimento));
			}
		}
		return retorno;
	}
}

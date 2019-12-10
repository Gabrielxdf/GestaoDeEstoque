package gestaoDeEstoque.util.factory;

import gestaoDeEstoque.model.pessoa.Cliente;
import gestaoDeEstoque.model.pessoa.Funcionarios;
import gestaoDeEstoque.model.pessoa.Pessoa;
import gestaoDeEstoque.util.DateUtil;
import gestaoDeEstoque.util.Enderecos;
import gestaoDeEstoque.util.Estados;
import gestaoDeEstoque.util.Telefones;
import gestaoDeEstoque.util.Verifica;
import gestaoDeEstoque.util.exception.DadosInvalidosException;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.ComboBox;

public class FactoryPessoa {
	public static Pessoa getPessoa(String identificador, String codigo, String nome, String email,
		String usuario, String senha, String confirmaSenha,String dataNascimento, String cpf, String telefone1,
			String telefone2, String cep, String endereco, String cidade, String bairro, ComboBox<Estados> estados)
			throws DadosInvalidosException {
		Pessoa retorno = null;
		String errorMessage = "";
		if(identificador.equals("F") || identificador.equals("C")) {
		}else {
			errorMessage += "Identificador inválido! use apenas F ou C, para funcionário, ou cliente, respectivamente\n";
		}
		if (Verifica.stringVazia(codigo)) {
			errorMessage += "O código não pode estar vazio!\n";
		}
		if (Verifica.stringVazia(nome)) {
			errorMessage += "O nome não pode estar vazio!\n";
		}
		if (Verifica.stringVazia(email)) {
			errorMessage += "O email não pode estar vazio!\n";
		}

		if (identificador.equals("F")) {
			if (Verifica.stringVazia(usuario)) {
				errorMessage += "O usuário não pode estar vazio!\n";
			}
			if (Verifica.stringVazia(senha)) {
				errorMessage += "A senha não pode estar vazia!\n";
			}
			if (!senha.equals(confirmaSenha)) {
				errorMessage += "A senha e sua confirmação precisam ser iguais!\n";
			}
			if (errorMessage.length() > 0) {
				throw new DadosInvalidosException(errorMessage);
			} else {
				retorno = new Funcionarios(codigo, nome, email, usuario, senha, confirmaSenha);
			}
		}

		if (identificador.equals("C")) {
			if (Verifica.stringVazia(telefone1) && Verifica.stringVazia(telefone2)) {
				errorMessage = "É necessário pelo menos um telefone.\n";
			}
			if (Verifica.comboBoxSemSeleção(estados)) {
				errorMessage = "Selecione um estado.!";
			}
			if (!DateUtil.validDate(dataNascimento)) {
				errorMessage += "Data inválida, selecione uma data no formato dd/mm/aaaa!\n";
			}
			if (!Verifica.validaCpf(cpf)) {
				errorMessage += "CPF Inválido!\n";
			}
			if (errorMessage.length() > 0) {
				throw new DadosInvalidosException(errorMessage);
			} else {
				retorno = new Cliente(codigo, nome, cpf,
						new Enderecos(cep, bairro, cidade, endereco,
								estados.getSelectionModel().getSelectedItem().toString()),
						new Telefones(new SimpleStringProperty(telefone1), telefone2), email,
						DateUtil.parse(dataNascimento));
			}
		}
		return retorno;
	}
}

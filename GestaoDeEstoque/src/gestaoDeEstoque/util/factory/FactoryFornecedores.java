package gestaoDeEstoque.util.factory;

import gestaoDeEstoque.model.estoque.Fornecedor;
import gestaoDeEstoque.util.Enderecos;
import gestaoDeEstoque.util.Estados;
import gestaoDeEstoque.util.Telefones;
import gestaoDeEstoque.util.Verifica;
import gestaoDeEstoque.util.exception.DadosInvalidosException;
import javafx.scene.control.ComboBox;

/**
 * Fábrica de Objetos Fornecedores.
 * 
 * @author Gabriel Henrique
 *
 */
public class FactoryFornecedores {
	/**
	 * Método para fabricar Fornecedores.
	 * 
	 * @param fornecedor
	 * @param cnpj
	 * @param codigo
	 * @param email
	 * @param telefone1
	 * @param telefone2
	 * @param razao
	 * @param cep
	 * @param endereço
	 * @param cidade
	 * @param bairro
	 * @param estados
	 * @return Fornecedor
	 * @throws DadosInvalidosException
	 */
	public static Fornecedor getFornecedor(String fornecedor, String cnpj, String codigo, String email,
			String telefone1, String telefone2, String razao, String cep, String endereço, String cidade, String bairro,
			ComboBox<Estados> estados) throws DadosInvalidosException {

		Fornecedor retorno = null;
		String errorMessage = "";

		if (Verifica.stringVazia(codigo)) {
			errorMessage += "O código não pode estar vazio!\n";
		}
		if (Verifica.stringVazia(fornecedor)) {
			errorMessage += "O nome do fornecedor não pode estar vazio!\n";
		}
		if (Verifica.stringVazia(email)) {
			errorMessage += "O email não pode estar vazio!\n";
		}
		if (Verifica.stringVazia(telefone1) && Verifica.stringVazia(telefone2)) {
			errorMessage = "É necessário pelo menos um telefone.\n";
		}
		if (Verifica.comboBoxSemSeleção(estados)) {
			errorMessage = "Selecione um estado.!\n";
		}
		if (!Verifica.validaCnpj(cnpj)) {
			errorMessage += "CNPJ Inválido!\n";
		}
		if (errorMessage.length() > 0) {
			throw new DadosInvalidosException(errorMessage);
		} else {
			retorno = new Fornecedor(fornecedor, cnpj, codigo, email, new Telefones(telefone1, telefone2),
					new Enderecos(cep, bairro, cidade, endereço,
							estados.getSelectionModel().getSelectedItem().toString()),
					razao);
		}

		return retorno;
	}
}

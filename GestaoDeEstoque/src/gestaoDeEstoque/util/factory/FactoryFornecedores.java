package gestaoDeEstoque.util.factory;

import gestaoDeEstoque.model.estoque.Fornecedor;
import gestaoDeEstoque.util.Enderecos;
import gestaoDeEstoque.util.Estados;
import gestaoDeEstoque.util.Telefones;
import gestaoDeEstoque.util.Verifica;
import javafx.scene.control.ComboBox;
/**
 * Fábrica de Objetos Fornecedores.
 * @author Gabriel Henrique
 *
 */
public class FactoryFornecedores {
	public static Fornecedor getFornecedor(String fornecedor, String cnpj, String codigo, String email,
			Telefones telefone, String razao, String cep, String endereço, String cidade, 
			String bairro, ComboBox<Estados> estados) {
		
		Fornecedor retorno = null;
		
		if (!Verifica.stringVazia(fornecedor) && !Verifica.stringVazia(codigo)
				&& !Verifica.stringVazia(email) &&!Verifica.objetoNulo(telefone) &&
				!Verifica.stringVazia(cnpj) && !Verifica.stringVazia(cep) && !Verifica.stringVazia(endereço) && 
				!Verifica.stringVazia(cidade) && !Verifica.stringVazia(bairro) && !Verifica.comboBoxSemSeleção(estados)) {
			retorno = new Fornecedor(fornecedor, cnpj, codigo, email, telefone, new Enderecos(cep, bairro, cidade, endereço,
					estados.getSelectionModel().getSelectedItem().toString()), razao);
		}else {
			
		}
		return retorno;
	}
}

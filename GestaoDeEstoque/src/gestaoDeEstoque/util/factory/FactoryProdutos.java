package gestaoDeEstoque.util.factory;

import gestaoDeEstoque.model.estoque.Fornecedor;
import gestaoDeEstoque.model.estoque.Grupos;
import gestaoDeEstoque.model.estoque.Produtos;
import gestaoDeEstoque.util.Verifica;
import gestaoDeEstoque.util.exception.DadosInvalidosException;
import javafx.scene.control.ComboBox;
/**
 * Classe para fabricar Produtos.
 * @author Gabriel Henrique
 *
 */
public class FactoryProdutos {
	/**
	 * Método para fabricar Produtos.
	 * @param nome
	 * @param codigo
	 * @param valor
	 * @param codigoBarras
	 * @param estoqueMinimo
	 * @param estoqueIdeal
	 * @param classificacao
	 * @param descricao
	 * @param fornecedor
	 * @param grupo
	 * @return Produtos
	 * @throws DadosInvalidosException
	 */
	public static Produtos getProduto(String nome, String codigo, String valor, String codigoBarras,
			String estoqueMinimo, String estoqueIdeal, ComboBox<String> classificacao, String descricao,
			ComboBox<Fornecedor> fornecedor, ComboBox<Grupos> grupo) throws DadosInvalidosException {
		Produtos retorno = null;
		String errorMessage = "";
		if (Verifica.stringVazia(codigo)) {
			errorMessage += "O código não pode estar vazio!\n";
		}
		if (Verifica.stringVazia(nome)) {
			errorMessage += "O nome não pode estar vazio!\n";
		}
		if (Verifica.stringVazia(codigoBarras)) {
			errorMessage += "O código de barras não pode estar vazio!\n";
		}
		if (Verifica.comboBoxSemSeleção(classificacao)) {
			errorMessage += "A classificação não pode estar vazia\n!";
		}
		if (Verifica.comboBoxSemSeleção(fornecedor)) {
			errorMessage += "O fornecedor não pode estar vazio\n!";
		}
		if (Verifica.comboBoxSemSeleção(grupo)) {
			errorMessage += "O grupo não pode estar vazio\n!";
		}
		try {
			Double.parseDouble(valor);
		} catch (NumberFormatException e) {
			errorMessage += "Erro! digite o valor do produto em apenas números e pontos(.) depois das casas decimais. Digite o valor em R$\n";
			errorMessage += "Exemplo: 12.5\n";
		}
		try {
			Integer.parseInt(estoqueMinimo);
		} catch (NumberFormatException e) {
			errorMessage += "Erro! digite o valor estoque mínimo do produto em apenas números inteiros.\n";
			errorMessage += "Exemplo: 17\n";
		}
		try {
			Integer.parseInt(estoqueIdeal);
		} catch (NumberFormatException e) {
			errorMessage += "Erro! digite o valor estoque ideal do produto em apenas números inteiros.\n";
			errorMessage += "Exemplo: 17\n";
		}
		if (errorMessage.length() > 0) {
			throw new DadosInvalidosException(errorMessage);
		} else {
			retorno = new Produtos(nome, codigo, valor, codigoBarras, estoqueMinimo, estoqueIdeal,
					classificacao.getSelectionModel().getSelectedItem().toString(), descricao,
					fornecedor.getSelectionModel().getSelectedItem(), grupo.getSelectionModel().getSelectedItem());
		}

		return retorno;
	}

}

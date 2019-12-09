package gestaoDeEstoque.util.factory;

import gestaoDeEstoque.model.estoque.Fornecedor;
import gestaoDeEstoque.model.estoque.Grupos;
import gestaoDeEstoque.model.estoque.Produtos;
import gestaoDeEstoque.util.Verifica;
import javafx.scene.control.ComboBox;

public class FactoryProdutos {

	public static Produtos getProduto(String nome, String codigo, String valor, String codigoBarras,
			String estoqueMinimo, String estoqueIdeal, ComboBox<String> classificacao, String descricao, 
			ComboBox<Fornecedor> fornecedor, ComboBox<Grupos> grupo) {
		Produtos retorno = null;
		if (!Verifica.stringVazia(nome) && !Verifica.stringVazia(codigo) && !Verifica.stringVazia(valor)
				&& !Verifica.stringVazia(codigoBarras) && !Verifica.stringVazia(estoqueMinimo)
				&& !Verifica.stringVazia(estoqueIdeal) && !Verifica.comboBoxSemSeleção(classificacao)
				&& !Verifica.stringVazia(descricao) && !Verifica.comboBoxSemSeleção(fornecedor)
				&& !Verifica.comboBoxSemSeleção(grupo)) {
			retorno = new Produtos(nome, codigo, valor, codigoBarras, estoqueMinimo, estoqueIdeal, classificacao.getSelectionModel().getSelectedItem().toString(),
					descricao, fornecedor.getSelectionModel().getSelectedItem(), grupo.getSelectionModel().getSelectedItem());
		}
		return retorno;
	}


}

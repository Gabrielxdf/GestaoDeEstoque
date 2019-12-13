package gestaoDeEstoque.model.estoque;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe auxiliar para fazer o "wrapping" da lista de produtos. Esta é usada
 * para salvar a lista de produtos em XML.
 * 
 * @author Marco Jakob
 * @author Gabriel Henrique
 */
@XmlRootElement(name = "produtos")
public class ProdutosListWrapper {

	private List<Produtos> produtos;

	/**
	 * Pega a lista de produtos.
	 * 
	 * @return produtos
	 */
	@XmlElement(name = "produto")
	public List<Produtos> getProdutos() {
		return produtos;
	}

	/**
	 * Define a lista de produtos para fazer o "wrapping".
	 * 
	 * @param produtos
	 */
	public void setProdutos(List<Produtos> produtos) {
		this.produtos = produtos;
	}
}

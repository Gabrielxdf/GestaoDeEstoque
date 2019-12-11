package gestaoDeEstoque.model.estoque;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe auxiliar para envolver uma lista de produtos. Esta é usada para salvar
 * a lista de produtos em XML.
 * 
 * @author Marco Jakob
 */
@XmlRootElement(name = "produtos")
public class ProdutosListWrapper {

	private List<Produtos> produtos;

	@XmlElement(name = "produto")
	public List<Produtos> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produtos> produtos) {
		this.produtos = produtos;
	}
}

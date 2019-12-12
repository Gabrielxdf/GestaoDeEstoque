package gestaoDeEstoque.model.estoque;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe auxiliar para fazer o "wrapping" da lista de fornecedores. Esta é usada para salvar a
 * lista de fornecedores em XML.
 * @author Marco Jakob
 * @author Gabriel Henrique
 */
@XmlRootElement(name = "fornecedores")
public class FornecedoresListWrapper {

    private List<Fornecedor> fornecedor;
    
    /**
     * Pega a lista de fornecedores.
     * @return fornecedor
     */
    @XmlElement(name = "fornecedor")
    public List<Fornecedor> getFornecedor() {
        return fornecedor;
    }
    
    /**
     * Define a lista de fornecedores para fazer o "wrapping".
     * @param fornecedor
     */
    public void setFornecedor(List<Fornecedor> fornecedor) {
        this.fornecedor = fornecedor;
    }
}

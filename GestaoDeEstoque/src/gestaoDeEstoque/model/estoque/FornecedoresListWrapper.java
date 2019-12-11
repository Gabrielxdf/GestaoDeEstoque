package gestaoDeEstoque.model.estoque;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe auxiliar para envolver uma lista de grupos. Esta é usada para salvar a
 * lista de grupos em XML.
 * 
 * @author Marco Jakob
 */
@XmlRootElement(name = "fornecedores")
public class FornecedoresListWrapper {

    private List<Fornecedor> fornecedor;

    @XmlElement(name = "fornecedor")
    public List<Fornecedor> getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(List<Fornecedor> fornecedor) {
        this.fornecedor = fornecedor;
    }
}

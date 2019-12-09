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
@XmlRootElement(name = "grupos")
public class GruposListWrapper {

    private List<Grupos> grupos;

    @XmlElement(name = "grupo")
    public List<Grupos> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupos> grupos) {
        this.grupos = grupos;
    }
}
package gestaoDeEstoque.model.estoque;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe auxiliar para fazer o "wrapping" da lista de grupos. Esta é usada para
 * salvar a lista de grupos em XML.
 * 
 * @author Marco Jakob
 * @author Gabriel Henrique
 */
@XmlRootElement(name = "grupos")
public class GruposListWrapper {

	private List<Grupos> grupos;

	/**
	 * Pega a lista de grupos.
	 * 
	 * @return grupos
	 */
	@XmlElement(name = "grupo")
	public List<Grupos> getGrupos() {
		return grupos;
	}

	/**
	 * Define a lista de grupos para fazer o "wrapping".
	 * 
	 * @param grupos
	 */
	public void setGrupos(List<Grupos> grupos) {
		this.grupos = grupos;
	}
}
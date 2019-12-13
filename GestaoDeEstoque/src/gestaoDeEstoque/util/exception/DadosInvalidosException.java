package gestaoDeEstoque.util.exception;

/**
 * Classe de Exceção para dados inválidos.
 * 
 * @author Gabriel Henrique
 *
 */
public class DadosInvalidosException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Construtor do DadosInvalidosException
	 * 
	 * @param msg
	 */
	public DadosInvalidosException(String msg) {
		super(msg);
	}
}

package gestaoDeEstoque.util;

import java.util.List;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.parg.viacep.ViaCEP;
import br.com.parg.viacep.ViaCEPEvents;
import br.com.parg.viacep.ViaCEPException;
import javafx.scene.control.ComboBox;

/**
 * Uma classe utilitária para fazer verificações.
 * 
 * @author Gabriel Henrique
 *
 */
public class Verifica implements ViaCEPEvents {
	ViaCEP cep = null;

	/**
	 * Verifica se uma String é vazia.
	 * 
	 * @param string
	 * @return true se for vazia, false se não for vazia.
	 */
	public static boolean stringVazia(String string) {
		if (string.length() > 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Verifica se uma ComboBox está sem nada selecionado nela.
	 * 
	 * @param comboBox
	 * @return true se não estiver nada selecionado, false caso tenha algo
	 *         selecionado.
	 */
	public static boolean comboBoxSemSeleção(ComboBox<?> comboBox) {
		if (comboBox.getSelectionModel().getSelectedIndex() >= 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Valida o CPF.
	 * 
	 * @API <a href="https://github.com/caelum/caelum-stella"> Caelum-Stella
	 * @param cpf
	 * @return true se o CPF for válido, caso contrário false.
	 */
	public static boolean validaCpf(String cpf) {
		CPFValidator cpfValidator = new CPFValidator();
		List<ValidationMessage> erros = cpfValidator.invalidMessagesFor(cpf);
		if (erros.size() > 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Valida o CNPJ.
	 * 
	 * @API <a href="https://github.com/caelum/caelum-stella"> Caelum-Stella
	 * @param cnpj
	 * @return true se o CNPJ for válido, caso contrário false.
	 */
	public static boolean validaCnpj(String cnpj) {
		CNPJValidator cnpjValidator = new CNPJValidator();
		List<ValidationMessage> erros = cnpjValidator.invalidMessagesFor(cnpj);
		if (erros.size() > 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Valida o CEP.
	 * 
	 * @API <a href="https://viacep.com.br">ViaCep</a>
	 */
	public void validaCep(String cep) {
		ViaCEP viaCEP = new ViaCEP(this);
		try {
			viaCEP.buscar(cep);
		} catch (ViaCEPException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Caso dê erro no {@link Verifica#validaCep(String)}. Este método é invocado.
	 * 
	 * @param cep
	 */
	@Override
	public void onCEPError(String cep) {

	}

	/**
	 * Caso não dê erro no {@link Verifica#validaCep(String)}. Este método é
	 * invocado.
	 * 
	 * @param cep
	 */
	@Override
	public void onCEPSuccess(ViaCEP cep) {
		this.cep = cep;
	}

	/**
	 * Pega o cep.
	 * 
	 * @return cep
	 */
	public ViaCEP getCep() {
		return this.cep;
	}

}

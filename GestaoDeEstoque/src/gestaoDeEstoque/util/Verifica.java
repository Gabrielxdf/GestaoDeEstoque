package gestaoDeEstoque.util;

import java.util.List;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.parg.viacep.ViaCEP;
import br.com.parg.viacep.ViaCEPEvents;
import br.com.parg.viacep.ViaCEPException;
import javafx.scene.control.ComboBox;

public class Verifica implements ViaCEPEvents {
	ViaCEP cep = null;
	
	public static boolean stringVazia(String string) {
		if (string.length() > 0) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean objetoNulo(Object objeto) {
		if (objeto == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean comboBoxVazia(ComboBox<?> comboBox) {
		if(comboBox.getSelectionModel().getSelectedIndex() >= 0) {
			return false;
		}else {
			return true;
		}
	}
	

	/**
	 * Valida CPF.
	 * 
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
	 * Valida CNPJ.
	 * 
	 * @param cpf
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
	 * Valida o CEP
	 * @param cep
	 */
	public void validaCep(String cep) {
		ViaCEP viaCEP = new ViaCEP(this);
		try {
			viaCEP.buscar(cep);
		} catch (ViaCEPException e){
			e.printStackTrace();
		}

	}

	@Override
	public void onCEPError(String cep) {
		
	}

	@Override
	public void onCEPSuccess(ViaCEP cep) {
		this.cep = cep;
	}
	
	public ViaCEP getCep() {
		return this.cep;
	}

}

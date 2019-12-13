package gestaoDeEstoque.util;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * Classe utilitária para limpar TextField e ComboBox
 * 
 * @author Gabriel Henrique
 *
 */
public class Limpa {
	/**
	 * Limpa os TextFields passados como argumento.
	 * 
	 * @param textField
	 */
	public static void limpaTextField(TextField... textFields) {
		for (TextField x : textFields) {
			x.setText("");
		}
	}

	/**
	 * Limpa as ComboBox passadas como argumento.
	 * 
	 * @param comboBoxes
	 */
	public static void limpaComboBox(ComboBox<?>... comboBoxes) {
		for (ComboBox<?> x : comboBoxes) {
			x.getSelectionModel().clearSelection();
		}
	}
}

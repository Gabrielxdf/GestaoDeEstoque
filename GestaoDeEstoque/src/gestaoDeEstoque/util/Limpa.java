package gestaoDeEstoque.util;

import javafx.scene.control.TextField;

public class Limpa {
	public static void limpaTextField(TextField... text) {
		for(TextField x: text) {
			x.setText("");
		}
	}
}

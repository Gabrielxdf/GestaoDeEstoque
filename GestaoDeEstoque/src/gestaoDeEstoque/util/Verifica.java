package gestaoDeEstoque.util;

public class Verifica {
	public static boolean stringVazia(String string) {
		if (string.length() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean objetoVazio(Object objeto) {
		if (objeto != null) {
			return true;
		} else {
			return false;
		}
	}
}

package gestaoDeEstoque.util;

public class Verifica {
	private static String errorMessage;
	
	public static boolean stringVazia(String string) {
		if (string.length() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean objetoNulo(Object objeto) {
		if (objeto != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String getErrorMessage() {
		return errorMessage;
	}
}

package gestaoDeEstoque.util;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

public class AlertUtil {
	/**
	 * Cria um Alert com os parâmetros dados.
	 * 
	 * @param title   o Titulo do Alert
	 * @param header  o Header do Alert
	 * @param content o Content do Alert
	 * @param type    o Tipo do Alert
	 */
	public static boolean criaUmAlert(String title, String header, String content, String type) {
		Alert alert = new Alert(null);
		switch (type) {
		case "ERROR":
			alert.setAlertType(AlertType.ERROR);
			alert.setTitle(title);
			alert.setHeaderText(header);
			alert.setContentText(content);
			alert.showAndWait();
			return true;
		case "WARNING":
			alert.setAlertType(AlertType.WARNING);
			alert.setTitle(title);
			alert.setHeaderText(header);
			alert.setContentText(content);
			alert.showAndWait();
			return true;
		case "CONFIRMATION":
			alert.setAlertType(AlertType.CONFIRMATION);
			alert.setTitle(title);
			alert.setHeaderText(header);
			alert.setContentText(content);
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				return true;
			} else {
				return false;
			}
		case "INFORMATION":
			alert.setAlertType(AlertType.INFORMATION);
			alert.setTitle(title);
			alert.setHeaderText(header);
			//alert.setContentText(content);
			alert.getDialogPane().setContent( new Label(content));
			alert.showAndWait();
			alert.setResizable(true);
			return true;
		}
		return false;
	}
}

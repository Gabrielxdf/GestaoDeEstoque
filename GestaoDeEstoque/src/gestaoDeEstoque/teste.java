package gestaoDeEstoque;

import com.gluonhq.charm.glisten.control.Alert;

import javafx.application.Application;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class teste extends Application {

	@Override
	public void start(Stage primaryStage) {
		Alert alert = new Alert(AlertType.WARNING);
alert.setContentText("TESTE");
alert.setTitleText("alo");
		alert.showAndWait();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

package gestaoDeEstoque;

import java.io.IOException;

import gestaoDeEstoque.model.estoque.Fornecedor;
import gestaoDeEstoque.model.estoque.Grupos;
import gestaoDeEstoque.model.estoque.Produtos;
import gestaoDeEstoque.model.pessoa.Funcionarios;
import gestaoDeEstoque.util.Enderecos;
import gestaoDeEstoque.util.Telefones;
import gestaoDeEstoque.util.factory.FactoryFornecedores;
import gestaoDeEstoque.util.factory.FactoryGrupos;
import gestaoDeEstoque.view.EditFornecedorController;
import gestaoDeEstoque.view.EditGruposController;
import gestaoDeEstoque.view.RootLayoutController;
import gestaoDeEstoque.view.EditProdutosController;
import gestaoDeEstoque.view.LoginController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	private ObservableList<Grupos> gruposData = FXCollections.observableArrayList();
	private ObservableList<Produtos> produtosData = FXCollections.observableArrayList();
	private ObservableList<Fornecedor> fornecedoresData = FXCollections.observableArrayList();
	private ObservableList<Funcionarios> funcionariosData = FXCollections.observableArrayList();

	/**
	 * Construtor
	 */
	public MainApp() {
		// alguns dados de exemplo
		gruposData.add(FactoryGrupos.getGrupo("Indefinido"));
		fornecedoresData.add(new Fornecedor("Indefinido", "00000000", "0000", "example@example.com",
				new Telefones("0", "0"), new Enderecos("", "", "", "", ""), "example"));
		funcionariosData.add(new Funcionarios("010", "Gabriel", "gabrielxdf16@gmail.com",
				"Gabrielxdf16", "1234", "1234"));
		
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("MyStock");
		showLogin();
		
	}

	/**
	 * Retorna a ObservableList de Grupos.
	 * 
	 * @return gruposData
	 */
	public ObservableList<Grupos> getGruposData() {
		return gruposData;
	}

	/**
	 * Retorna a ObservableList de Produtos.
	 * 
	 * @return produtosData
	 */
	public ObservableList<Produtos> getProdutosData() {
		return produtosData;
	}
	
	/**
	 * Retorna a ObservableList de Fornecedores
	 * @return
	 */
	public ObservableList<Fornecedor> getFornecedoresData(){
		return fornecedoresData;
	}
	
	public ObservableList<Funcionarios> getFuncionariosData(){
		return funcionariosData;
	}
	
	/**
	 * Inicializa o RootLayout
	 */
	public void initRootLayout() {
		try {
			// Carrega o root layout do arquivo fxml.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Mostra a scene (cena) contendo o root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			RootLayoutController controller = loader.getController();
			controller.setMainApp(this);
			primaryStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Mostra a tela de Login.
	 * 
	 */
	public void showLogin() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/Login.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Login");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			LoginController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setMainApp(this);
			dialogStage.getIcons().add(new Image("file:GestaoDeEstoque/src/gestaoDeEstoque/resources/password-icon.png"));
			dialogStage.showAndWait();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Exibe a tela de Grupos.
	 * 
	 */
	public void showEditGrupos() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/EditGrupos.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Grupos");
			dialogStage.initModality(Modality.NONE);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			EditGruposController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setMainApp(this);
			dialogStage.getIcons().add(new Image("file:GestaoDeEstoque/src/gestaoDeEstoque/resources/groups-icon.png"));
			dialogStage.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Exibe a tela de Produtos.
	 */
	public void showEditProdutos() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/EditProdutos.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Produtos");
			dialogStage.initModality(Modality.NONE);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			
			EditProdutosController controller = loader.getController();
			controller.setMainApp(this);
			controller.setStage(dialogStage);
			dialogStage.getIcons().add(new Image("file:GestaoDeEstoque/src/gestaoDeEstoque/resources/products-icon.png"));
			dialogStage.showAndWait();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Exibe a tela de Fornecedores.
	 */
	public void showEditFornecedores() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/EditFornecedor.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Fornecedores");
			dialogStage.initModality(Modality.NONE);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			
			EditFornecedorController controller = loader.getController();
			controller.setMainApp(this);
			controller.setStage(dialogStage);
			dialogStage.getIcons().add(new Image("file:GestaoDeEstoque/src/gestaoDeEstoque/resources/provider-icon.png"));
			dialogStage.showAndWait();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retorna o palco principal.
	 * @return primaryStage
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
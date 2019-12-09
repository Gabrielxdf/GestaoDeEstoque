package gestaoDeEstoque;

import java.io.File;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import gestaoDeEstoque.model.estoque.Fornecedor;
import gestaoDeEstoque.model.estoque.Grupos;
import gestaoDeEstoque.model.estoque.GruposListWrapper;
import gestaoDeEstoque.model.estoque.Produtos;
import gestaoDeEstoque.model.pessoa.Cliente;
import gestaoDeEstoque.model.pessoa.Funcionarios;
import gestaoDeEstoque.util.Enderecos;
import gestaoDeEstoque.util.Telefones;
import gestaoDeEstoque.util.factory.FactoryGrupos;
import gestaoDeEstoque.view.EditClienteController;
import gestaoDeEstoque.view.EditFornecedorController;
import gestaoDeEstoque.view.EditFuncionarioController;
import gestaoDeEstoque.view.EditGruposController;
import gestaoDeEstoque.view.RootLayoutController;
import gestaoDeEstoque.view.EditProdutosController;
import gestaoDeEstoque.view.LoginController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	private ObservableList<Grupos> gruposData = FXCollections.observableArrayList();
	private ObservableList<Cliente> clientesData = FXCollections.observableArrayList();
	private ObservableList<Produtos> produtosData = FXCollections.observableArrayList();
	private ObservableList<Fornecedor> fornecedoresData = FXCollections.observableArrayList();
	private ObservableList<Funcionarios> funcionariosData = FXCollections.observableArrayList();

	/**
	 * Construtor
	 */
	public MainApp() {
		// alguns dados de exemplo
		gruposData.add(FactoryGrupos.getGrupo("Indefinido"));
		gruposData.get(0).setQuantidadeProdutos("10");
		gruposData.get(0).setValorTotal("500.0");
		fornecedoresData.add(new Fornecedor("Indefinido", "00000000", "0000", "example@example.com",
				new Telefones("0", "0"), new Enderecos("", "", "", "", ""), "example"));
		funcionariosData.add(new Funcionarios("000", "admiin", "example@example.com", "admin", "admin", "admin"));
		loadDataFromFile(new File("GestaoDeEstoque/src/gestaoDeEstoque/resources/saveFiles/save.xml"));
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("MyStock");
		primaryStage.getIcons().add(new Image("file:GestaoDeEstoque/src/gestaoDeEstoque/resources/root-icon.png"));
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
	 * 
	 * @return
	 */
	public ObservableList<Fornecedor> getFornecedoresData() {
		return fornecedoresData;
	}

	public ObservableList<Funcionarios> getFuncionariosData() {
		return funcionariosData;
	}

	public ObservableList<Cliente> getClientesData() {
		return clientesData;
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
	 * Exibe a tela de Login.
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
			dialogStage.getIcons()
					.add(new Image("file:GestaoDeEstoque/src/gestaoDeEstoque/resources/password-icon.png"));
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
			dialogStage.getIcons()
					.add(new Image("file:GestaoDeEstoque/src/gestaoDeEstoque/resources/products-icon.png"));
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
			dialogStage.getIcons()
					.add(new Image("file:GestaoDeEstoque/src/gestaoDeEstoque/resources/provider-icon.png"));
			dialogStage.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Exibe a tela de clientes.
	 */
	public void showEditCliente() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/EditCliente.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Clientes");
			dialogStage.initModality(Modality.NONE);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			EditClienteController controller = loader.getController();
			controller.setMainApp(this);
			controller.setStage(dialogStage);
			dialogStage.getIcons().add(new Image("file:GestaoDeEstoque/src/gestaoDeEstoque/resources/client-icon.png"));
			dialogStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void showEditFuncionario() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/EditFuncionario.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Funcionarios");
			dialogStage.initModality(Modality.NONE);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			EditFuncionarioController controller = loader.getController();
			controller.setMainApp(this);
			controller.setStage(dialogStage);
			dialogStage.getIcons().add(new Image("file:GestaoDeEstoque/src/gestaoDeEstoque/resources/employee-icon.png"));
			dialogStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Carrega os dados do grupo do arquivo especificado. Os grupos atual
	 * será substituída.
	 * 
	 * @param file
	 */
	public void loadDataFromFile(File file) {
	    try {
	        JAXBContext context = JAXBContext
	                .newInstance(GruposListWrapper.class);
	        Unmarshaller um = context.createUnmarshaller();

	        // Reading XML from the file and unmarshalling.
	        GruposListWrapper wrapper = (GruposListWrapper) um.unmarshal(file);

	        gruposData.clear();
	        gruposData.addAll(wrapper.getGrupos());

	    } catch (Exception e) { // catches ANY exception
	    	e.printStackTrace();
	    	Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Error");
	        alert.setHeaderText("Could not load data");
	        alert.setContentText("Could not load data from file:\n" + file.getPath());
	        alert.showAndWait();
	    }
	}

	/**
	 * Salva os dados do grupo atual no arquivo especificado.
	 * 
	 * @param file
	 */
	public void saveDataToFile() {
	    try {
	        JAXBContext context = JAXBContext
	                .newInstance(GruposListWrapper.class);
	        Marshaller m = context.createMarshaller();
	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	        for(Grupos x : gruposData) {
	        	System.out.println(x.getNome());
	        	System.out.println(x.getQuantidadeProdutosProperty().get());
	        	System.out.println(x.getValorTotalProperty().get());
	        	System.out.println(x.getListaProdutos());
	        }
	        // Envolvendo nossos dados da pessoa.
	        GruposListWrapper wrapper = new GruposListWrapper();
	        wrapper.setGrupos(gruposData);
	        
	        // Enpacotando e salvando XML  no arquivo.
	        m.marshal(wrapper, System.out);
	        m.marshal(wrapper, new File("GestaoDeEstoque/src/gestaoDeEstoque/resources/saveFiles/save.xml"));

	    } catch (Exception e) { // catches ANY exception
	    	e.printStackTrace();
	    }
	}
	
	
	/**
	 * Retorna o palco principal.
	 * 
	 * @return primaryStage
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
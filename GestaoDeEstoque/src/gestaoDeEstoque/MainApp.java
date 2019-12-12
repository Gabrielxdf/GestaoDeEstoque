package gestaoDeEstoque;

import java.io.File;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import gestaoDeEstoque.model.estoque.Fornecedor;
import gestaoDeEstoque.model.estoque.FornecedoresListWrapper;
import gestaoDeEstoque.model.estoque.Grupos;
import gestaoDeEstoque.model.estoque.GruposListWrapper;
import gestaoDeEstoque.model.estoque.Produtos;
import gestaoDeEstoque.model.estoque.ProdutosListWrapper;
import gestaoDeEstoque.model.pessoa.Cliente;
import gestaoDeEstoque.model.pessoa.Funcionarios;
import gestaoDeEstoque.util.Enderecos;
import gestaoDeEstoque.util.Telefones;
import gestaoDeEstoque.view.EditClienteController;
import gestaoDeEstoque.view.EditEntradaController;
import gestaoDeEstoque.view.EditFornecedorController;
import gestaoDeEstoque.view.EditFuncionarioController;
import gestaoDeEstoque.view.EditGruposController;
import gestaoDeEstoque.view.RootLayoutController;
import gestaoDeEstoque.view.ViewClienteController;
import gestaoDeEstoque.view.ViewFornecedorController;
import gestaoDeEstoque.view.ViewFuncionarioController;
import gestaoDeEstoque.view.ViewGrupoController;
import gestaoDeEstoque.view.ViewProdutoController;
import gestaoDeEstoque.view.EditProdutosController;
import gestaoDeEstoque.view.EditSaidaController;
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
/**
 * Classe principal da aplicação.
 * @author Gabriel Henrique
 *
 */
public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	private ObservableList<Grupos> gruposData = FXCollections.observableArrayList();
	private ObservableList<Cliente> clientesData = FXCollections.observableArrayList();
	private ObservableList<Produtos> produtosData = FXCollections.observableArrayList();
	private ObservableList<Fornecedor> fornecedoresData = FXCollections.observableArrayList();
	private ObservableList<Funcionarios> funcionariosData = FXCollections.observableArrayList();

	/**
	 * Construtor do MainApp
	 */
	public MainApp() {
		// alguns dados de exemplo
		gruposData.add(new Grupos("Indefinido"));
		fornecedoresData.add(new Fornecedor("Indefinido", "05075964000112", "0000", "example@example.com",
				new Telefones("0", "0"), new Enderecos("", "", "", "", ""), "example"));
		funcionariosData.add(new Funcionarios("000", "admin", "example@example.com", "admin", "admin", "admin"));
		//loadDataFromFile();
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

	/**
	 * Exibe a tela de funcionários.
	 */
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
	 * Exibe a tela do Grupo passado como argumento.
	 * @param grupo
	 */
	public void showViewGrupos(Grupos grupo) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/ViewGrupo.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Grupo" + "-" + grupo.getNome());
			dialogStage.initModality(Modality.NONE);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			ViewGrupoController controller = loader.getController();
			controller.setGrupo(grupo);
			controller.setMainApp(this);
			dialogStage.getIcons().add(new Image("file:GestaoDeEstoque/src/gestaoDeEstoque/resources/groups-icon.png"));
			dialogStage.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Exibe a tela do Produto passado como argumento.
	 * @param produto.
	 */
	public void showViewProduto(Produtos produto) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/ViewProduto.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Produto" + "-" + produto.getNome());
			dialogStage.initModality(Modality.NONE);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			ViewProdutoController controller = loader.getController();
			controller.setProduto(produto);
			dialogStage.getIcons().add(new Image("file:GestaoDeEstoque/src/gestaoDeEstoque/resources/products-icon.png"));
			dialogStage.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Exibe a tela do Fornecedor passado como argumento.
	 * @param fornecedor.
	 */
	public void showViewFornecedor(Fornecedor fornecedor) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/ViewFornecedor.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Fornecedor" + "-" + fornecedor.getNome());
			dialogStage.initModality(Modality.NONE);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			ViewFornecedorController controller = loader.getController();
			controller.setFornecedor(fornecedor);
			controller.setMainApp(this);
			dialogStage.getIcons().add(new Image("file:GestaoDeEstoque/src/gestaoDeEstoque/resources/provider-icon.png"));
			dialogStage.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Exibe a tela do Funcionário passado como argumento.
	 * @param funcionario.
	 */
	public void showViewFuncionario(Funcionarios funcionario) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/ViewFuncionario.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Funcionário" + "-" + funcionario.getNome());
			dialogStage.initModality(Modality.NONE);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			ViewFuncionarioController controller = loader.getController();
			controller.setFuncionario(funcionario);
			dialogStage.getIcons().add(new Image("file:GestaoDeEstoque/src/gestaoDeEstoque/resources/employee-icon.png"));
			dialogStage.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Exibe a tela do Cliente passado como argumento.
	 * @param cliente.
	 */
	public void showViewCliente(Cliente cliente) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/ViewCliente.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Cliente" + "-" + cliente.getNome());
			dialogStage.initModality(Modality.NONE);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			ViewClienteController controller = loader.getController();
			controller.setCliente(cliente);
			dialogStage.getIcons().add(new Image("file:GestaoDeEstoque/src/gestaoDeEstoque/resources/client-icon.png"));
			dialogStage.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Exibe a tela de Entrada de produtos.
	 *
	 */
	public void showEditEntrada() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/EditEntrada.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Entrada");
			dialogStage.initModality(Modality.NONE);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			EditEntradaController controller = loader.getController();
			controller.setMainApp(this);
			controller.setStage(dialogStage);
			dialogStage.getIcons().add(new Image("file:GestaoDeEstoque/src/gestaoDeEstoque/resources/add-icon.png"));
			dialogStage.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Exibe a tela de Saída de produtos.
	 *
	 */
	public void showEditSaida() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/EditSaida.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Entrada");
			dialogStage.initModality(Modality.NONE);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			EditSaidaController controller = loader.getController();
			controller.setMainApp(this);
			controller.setStage(dialogStage);
			dialogStage.getIcons().add(new Image("file:GestaoDeEstoque/src/gestaoDeEstoque/resources/minus-icon.png"));
			dialogStage.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/**
	 * Carrega os dados do obtidos dos XML que foram salvos.
	 */
	public void loadDataFromFile() {
	    try {
	        JAXBContext grupoContext = JAXBContext
	                .newInstance(GruposListWrapper.class);
	        Unmarshaller grupoUnmarshaller = grupoContext.createUnmarshaller();
	        
	        JAXBContext funcionarioContext = JAXBContext
	                .newInstance(FornecedoresListWrapper.class);
	        Unmarshaller fornecedorUnmarshaller = funcionarioContext.createUnmarshaller();
	        
	        JAXBContext produtoContext = JAXBContext
	                .newInstance(ProdutosListWrapper.class);
	        Unmarshaller produtoUnmarshaller = produtoContext.createUnmarshaller();

	        

	        // Reading XML from the file and unmarshalling.
	        GruposListWrapper grupoWrapper = (GruposListWrapper) grupoUnmarshaller.unmarshal
	        		(new File("GestaoDeEstoque/src/gestaoDeEstoque/resources/saveFiles/saveGrupos.xml"));
	      
	        FornecedoresListWrapper fornecedorWrapper = (FornecedoresListWrapper) fornecedorUnmarshaller.unmarshal
	        		(new File("GestaoDeEstoque/src/gestaoDeEstoque/resources/saveFiles/saveFornecedores.xml"));
	        
	        ProdutosListWrapper produtoWrapper = (ProdutosListWrapper) produtoUnmarshaller.unmarshal
	        		(new File("GestaoDeEstoque/src/gestaoDeEstoque/resources/saveFiles/saveProdutos.xml"));
	        
	        
	        
	        gruposData.clear();
	        gruposData.addAll(grupoWrapper.getGrupos());
	        
	        fornecedoresData.clear();
	        fornecedoresData.addAll(fornecedorWrapper.getFornecedor());
	        
	        produtosData.clear();
	       produtosData.addAll(produtoWrapper.getProdutos());
	        
	        

	    } catch (Exception e) { // catches ANY exception
	    	e.printStackTrace();
	    }
	}

	/**
	 * Salva os dados atuais para arquivos XML.
	 * 
	 * @param file
	 */
	public void saveDataToFile() {
	    try {
	        JAXBContext grupoContext = JAXBContext
	                .newInstance(GruposListWrapper.class);
	        Marshaller grupoMarshal = grupoContext.createMarshaller();
	        grupoMarshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	        
	        JAXBContext fornecedorContext = JAXBContext
	                .newInstance(FornecedoresListWrapper.class);
	        Marshaller fornecedorMarshal = fornecedorContext.createMarshaller();
	        fornecedorMarshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	        
	        JAXBContext produtoContext = JAXBContext
	                .newInstance(ProdutosListWrapper.class);
	        Marshaller produtoMarshal = produtoContext.createMarshaller();
	        produtoMarshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	        
	        
	    
	        // Envolvendo nossos dados da pessoa.
	        GruposListWrapper grupoWrapper = new GruposListWrapper();
	        grupoWrapper.setGrupos(gruposData);
	        
	        FornecedoresListWrapper fornecedorWrapper = new FornecedoresListWrapper();
	        fornecedorWrapper.setFornecedor(fornecedoresData);
	        
	        ProdutosListWrapper produtoWrapper = new ProdutosListWrapper();
	        produtoWrapper.setProdutos(produtosData);
	        
	        
	        
	        // Enpacotando e salvando XML  no arquivo.
	        grupoMarshal.marshal(grupoWrapper, new File("GestaoDeEstoque/src/gestaoDeEstoque/resources/saveFiles/saveGrupos.xml"));
	        fornecedorMarshal.marshal(fornecedorWrapper, new File("GestaoDeEstoque/src/gestaoDeEstoque/resources/saveFiles/saveFornecedores.xml"));
	        produtoMarshal.marshal(produtoWrapper, new File("GestaoDeEstoque/src/gestaoDeEstoque/resources/saveFiles/saveProdutos.xml"));
	        
	    } catch (Exception e) { // catches ANY exception
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
package gestaoDeEstoque.model.estoque;

import javax.xml.bind.annotation.XmlElement;

import gestaoDeEstoque.util.Enderecos;
import gestaoDeEstoque.util.Telefones;
import gestaoDeEstoque.util.pesquisa.Pesquisavel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Classe modelo do Fornecedor
 * 
 * @author Gabriel Henrique
 */
public class Fornecedor implements Pesquisavel {
	private StringProperty fornecedor;
	private StringProperty cnpj;
	private StringProperty codigo;
	private StringProperty email;
	private StringProperty razaoSocial;
	private Telefones telefone;
	private Enderecos endereco;
	private ObservableList<Produtos> listaProdutos = FXCollections.observableArrayList();

	/**
	 * Construtor do Fornecedor.
	 * 
	 * @param fornecedor
	 * @param cnpj
	 * @param codigo
	 * @param email
	 * @param telefone
	 * @param endereco
	 * @param razao
	 */
	public Fornecedor(String fornecedor, String cnpj, String codigo, String email, Telefones telefone,
			Enderecos endereco, String razao) {
		this.fornecedor = new SimpleStringProperty(fornecedor);
		this.cnpj = new SimpleStringProperty(cnpj);
		this.codigo = new SimpleStringProperty(codigo);
		this.email = new SimpleStringProperty(email);
		this.telefone = telefone;
		this.endereco = endereco;
		this.razaoSocial = new SimpleStringProperty(razao);
	}

	/**
	 * Get a StringProperty da razão social.
	 * 
	 * @return razaoSocial
	 */
	public StringProperty getRazaoSocialProperty() {
		return razaoSocial;
	}

	/**
	 * Define a razão social.
	 * 
	 * @param razaoSocial
	 */
	public void setRazaoSocial(StringProperty razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	/**
	 * Get a StringProperty do fornecedor.
	 * 
	 * @return fornecedor
	 */
	public StringProperty getFornecedorProperty() {
		return fornecedor;
	}

	/**
	 * Define o fornecedor.
	 * 
	 * @param fornecedor
	 */
	public void setFornecedor(StringProperty fornecedor) {
		this.fornecedor = fornecedor;
	}

	/**
	 * Pega a StringProperty do cnpj.
	 * 
	 * @return cnpj
	 */
	public StringProperty getCnpjProperty() {
		return cnpj;
	}

	/**
	 * Define o cnpj.
	 * 
	 * @param cnpj
	 */
	public void setCnpj(StringProperty cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * Pega a StringProperty do codigo.
	 * 
	 * @return codigo
	 */
	public StringProperty getCodigoProperty() {
		return codigo;
	}

	/**
	 * Define o código.
	 * 
	 * @param codigo
	 */
	public void setCodigo(StringProperty codigo) {
		this.codigo = codigo;
	}

	/**
	 * Pega a StringProperty do email.
	 * 
	 * @return email
	 */
	public StringProperty getEmailProperty() {
		return email;
	}

	/**
	 * Define o e-mail.
	 * 
	 * @param email
	 */
	public void setEmail(StringProperty email) {
		this.email = email;
	}

	/**
	 * Pega o Objeto telefone {@link Telefones}.
	 * 
	 * @return telefone
	 */
	public Telefones getTelefone() {
		return telefone;
	}

	/**
	 * Define o telefone {@link Telefones}.
	 * 
	 * @param telefone
	 */
	public void setTelefone(Telefones telefone) {
		this.telefone = telefone;
	}

	/**
	 * Pega o Objeto endereco {@link Enderecos}.
	 * 
	 * @return endereco
	 */
	public Enderecos getEndereco() {
		return endereco;
	}

	/**
	 * Define o endereço {@link Enderecos}.
	 * 
	 * @param endereco
	 */
	public void setEndereco(Enderecos endereco) {
		this.endereco = endereco;
	}

	/**
	 * Pega a ObservableList de produtos {@link Produtos}.
	 * 
	 * @return listaProdutos
	 */
	public ObservableList<Produtos> getListaProdutos() {
		return listaProdutos;
	}

	/**
	 * Pega a String do fornecedor.
	 * 
	 * @return fornecedor
	 */
	@XmlElement(name = "fornecedor")
	@Override
	public String getNome() {
		return fornecedor.get();
	}

	/**
	 * Pega a String do código.
	 * 
	 * @return codigo
	 */
	@XmlElement(name = "codigo")
	@Override
	public String getCodigo() {
		return codigo.get();
	}

	/**
	 * Pega a String do cnpj.
	 * 
	 * @return cnpj
	 */
	@XmlElement(name = "cnpj")
	public String getCnpj() {
		return cnpj.get();
	}

	/**
	 * Pega a String do e-mail.
	 * 
	 * @return email
	 */
	@XmlElement(name = "email")
	public String getEmail() {
		return email.get();
	}

	/**
	 * Pega a String da razão social.
	 * 
	 * @return razaoSocial
	 */
	@XmlElement(name = "razaoSocial")
	public String getRazaoSocial() {
		return razaoSocial.get();
	}

	/**
	 * método toString.
	 * 
	 * @return {@link Fornecedor#getNome()}
	 */
	@Override
	public String toString() {
		return getNome();
	}
}

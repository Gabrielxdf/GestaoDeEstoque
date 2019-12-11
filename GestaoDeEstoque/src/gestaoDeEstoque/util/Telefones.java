package gestaoDeEstoque.util;



import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Telefones {
	private List<StringProperty> telefonesFornecedores = new ArrayList<>();
	private StringProperty celular;
	private StringProperty residencial;
	
	public Telefones() {
		
	}
	public Telefones(StringProperty celular, String residencial) {
		//this.celular = new SimpleStringProperty(celular);
		this.celular = celular;
		this.residencial = new SimpleStringProperty(residencial);
	}
	
	public Telefones (String... telefone) {
		this.telefonesFornecedores = new ArrayList<StringProperty>();
		
		for(int x = 0; x < telefone.length; x++ ) {
			telefonesFornecedores.add(x, new SimpleStringProperty(telefone[x]));
		}
		
	}

	public StringProperty getCelularProperty() {
		return this.celular;
	}

	public void setCelular(StringProperty celular) {
		this.celular = celular;
	}

	public StringProperty getResidencialProperty() {
		return residencial;
	}

	public void setResidencial(StringProperty residencial) {
		this.residencial = residencial;
	}

	public List<StringProperty> getTelefonesFornecedoresProperty() {
		return telefonesFornecedores;
	}

	public void setTelefonesFornecedores(List<StringProperty> telefonesFornecedores) {
		this.telefonesFornecedores = telefonesFornecedores;
	}
	@XmlElement(name = "telefoneFornecedores")
	public List<String> getTelefonesFornecedores() {
		List<String> lista = new ArrayList<>();
		for(StringProperty x : getTelefonesFornecedoresProperty()) {
			lista.add(x.get());
		}
		return lista;
	}
	/*
	@XmlElement(name = "celular")
	public String getCelular() {
		return celular.get();
	}
	@XmlElement(name = "residencial")
	public String getResidencial() {
		return residencial.get();
	}*/

	
}

package gestaoDeEstoque.util;



import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

public class Telefones {
	private List<StringProperty> telefonesFornecedores;
	private StringProperty celular;
	private StringProperty residencial;

	public Telefones(StringProperty celular, String residencial) {
		super();
		//this.celular = new SimpleStringProperty(celular);
		this.residencial = new SimpleStringProperty(residencial);
	}
	
	public Telefones (String... telefone) {
		this.telefonesFornecedores = new ArrayList<StringProperty>();
		
		for(int x = 0; x < telefone.length; x++ ) {
			telefonesFornecedores.add(x, new SimpleStringProperty(telefone[x]));
		}
		
	}

	public StringProperty getCelularProperty() {
		return celular;
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

}

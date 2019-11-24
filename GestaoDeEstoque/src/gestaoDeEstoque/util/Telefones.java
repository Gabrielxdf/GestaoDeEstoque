package gestaoDeEstoque.util;



import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Telefones {
	private List<StringProperty> telefonesFornecedores;
	private StringProperty celular;
	private StringProperty residencial;

	public Telefones(StringProperty celular, StringProperty residencial) {
		super();
		this.celular = celular;
		this.residencial = residencial;
	}
	
	public Telefones (String...telefone) {
		for(String x : telefone) {
			telefonesFornecedores.add(new SimpleStringProperty(x));
		}
	}

	public StringProperty getCelular() {
		return celular;
	}

	public void setCelular(StringProperty celular) {
		this.celular = celular;
	}

	public StringProperty getResidencial() {
		return residencial;
	}

	public void setResidencial(StringProperty residencial) {
		this.residencial = residencial;
	}

}

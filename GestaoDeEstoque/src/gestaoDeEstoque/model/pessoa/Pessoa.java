package gestaoDeEstoque.model.pessoa;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Pessoa {
	private IntegerProperty codigo;
	private StringProperty nome;
	private ObjectProperty<LocalDate> dataNascimento;
	private StringProperty email;

	public Pessoa(Integer codigo, String nome, String email) {
		this.codigo = new SimpleIntegerProperty(codigo);
		this.nome = new SimpleStringProperty(nome);
		this.email = new SimpleStringProperty(email);
		this.dataNascimento = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
	}

}

package GestaoDeEstoque.model.pessoa;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

//TODO fazer a formatação e conversão da Data de Nascimento
public class Pessoa {
	private IntegerProperty codigo;
	private StringProperty nome;
	private ObjectProperty dataNascimento;
	private StringProperty email;

	public Pessoa(Integer codigo, String nome, String email) {
		this.codigo = new SimpleIntegerProperty(codigo);
		this.nome = new SimpleStringProperty(nome);
		this.email = new SimpleStringProperty(email);
		this.dataNascimento = null;
	}

}

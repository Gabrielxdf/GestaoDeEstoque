package gestaoDeEstoque.model.pessoa;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public abstract class Pessoa {
	private StringProperty codigo;
	private StringProperty nome;
	private ObjectProperty<LocalDate> dataNascimento;
	private StringProperty email;

	public Pessoa(String codigo, String nome, String email, LocalDate localdate)
	{
		//public Pessoa(String codigo, String nome, String email, int ano, int mes, int dia)
		this.codigo = new SimpleStringProperty(codigo);
		this.nome = new SimpleStringProperty(nome);
		this.email = new SimpleStringProperty(email);
		//this.dataNascimento = new SimpleObjectProperty<LocalDate>(LocalDate.of(ano, mes, dia));
		this.dataNascimento = new SimpleObjectProperty<LocalDate>(localdate);
	}

	public StringProperty getCodigo() {
		return codigo;
	}

	public void setCodigo(StringProperty codigo) {
		this.codigo = codigo;
	}

	public StringProperty getNome() {
		return nome;
	}

	public void setNome(StringProperty nome) {
		this.nome = nome;
	}

	public ObjectProperty<LocalDate> getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(ObjectProperty<LocalDate> dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public StringProperty getEmail() {
		return email;
	}

	public void setEmail(StringProperty email) {
		this.email = email;
	}

	
}

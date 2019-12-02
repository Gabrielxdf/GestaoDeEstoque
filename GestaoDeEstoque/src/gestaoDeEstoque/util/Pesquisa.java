package gestaoDeEstoque.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

public class Pesquisa {
	private static <O> ObservableList<O> pesquisar(ObservableList<O> listaObservavel, String nome, TextField pesquisa) {
		ObservableList<O> novaLista = FXCollections.observableArrayList();
		for(int x = 0; x<listaObservavel.size(); x++) {
			if(listaObservavel.get(x).getNome().toLowerCase().contains(pesquisa.getText().toLowerCase()));
			novaLista.add(listaObservavel.get(x));
		}
		return novaLista;
	}
}

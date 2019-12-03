package gestaoDeEstoque.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import gestaoDeEstoque.util.Pesquisavel;

public class Pesquisa {
	public static ObservableList<Pesquisavel> pesquisarPorNome(ObservableList<Pesquisavel> listaObservavel, String pesquisa) {
		ObservableList<Pesquisavel> novaLista = FXCollections.observableArrayList();
		for(int x = 0; x<listaObservavel.size(); x++) {
			if(listaObservavel.get(x).getNome().toLowerCase().contains(pesquisa.toLowerCase()));
			novaLista.add(listaObservavel.get(x));
		}
		return novaLista;
	}
	public static ObservableList<Pesquisavel> pesquisarPorCodigo(ObservableList<Pesquisavel> listaObservavel, String pesquisa) {
		ObservableList<Pesquisavel> novaLista = FXCollections.observableArrayList();
		for(int x = 0; x<listaObservavel.size(); x++) {
			if(listaObservavel.get(x).getNome().toLowerCase().contains(pesquisa.toLowerCase()));
			novaLista.add(listaObservavel.get(x));
		}
		return novaLista;
	}
}

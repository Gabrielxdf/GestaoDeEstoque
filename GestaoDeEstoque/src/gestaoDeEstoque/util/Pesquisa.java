package gestaoDeEstoque.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import gestaoDeEstoque.util.Pesquisavel;

public class Pesquisa {
	public static <T extends Pesquisavel> ObservableList<T> pesquisarPorNome(ObservableList<T> listaObservavel,
			String pesquisa) {
		ObservableList<T> novaLista = FXCollections.observableArrayList();
		if (pesquisa.length() > 0) {
			for (int x = 0; x < listaObservavel.size(); x++) {
				if (listaObservavel.get(x).getNome().toLowerCase().contains(pesquisa.toLowerCase())) {
					novaLista.add(listaObservavel.get(x));
				}
			}
			return novaLista;
		} else {
			return listaObservavel;
		}
	}
	
	public static <T extends Pesquisavel> ObservableList<T> pesquisarPorCodigo(ObservableList<T> listaObservavel, String pesquisa) {
		ObservableList<T> novaLista = FXCollections.observableArrayList();
		if (pesquisa.length() > 0) {
			for (int x = 0; x < listaObservavel.size(); x++) {
				if (listaObservavel.get(x).getCodigo().toLowerCase().contains(pesquisa.toLowerCase())) {
					novaLista.add(listaObservavel.get(x));
				}
			}
			return novaLista;
		} else {
			return listaObservavel;
		}
	}

}

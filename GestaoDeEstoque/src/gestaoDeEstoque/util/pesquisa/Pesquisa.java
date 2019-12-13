package gestaoDeEstoque.util.pesquisa;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Classe utilitária para fazer pesquisa em ObservableLists.
 * 
 * @author Gabriel Henrique
 *
 */
public class Pesquisa {
	/**
	 * Método para fazer pesquisa por nome em uma ObservableList passada como
	 * argumento.
	 * 
	 * @param <T>
	 * @param listaObservavel
	 * @param pesquisa
	 * @return novaLista
	 */
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

	/**
	 * Método para fazer pesquisa por código em uma ObservableList passada como
	 * argumento.
	 * 
	 * @param <T>
	 * @param listaObservavel
	 * @param pesquisa
	 * @return novaLista
	 */
	public static <T extends Pesquisavel> ObservableList<T> pesquisarPorCodigo(ObservableList<T> listaObservavel,
			String pesquisa) {
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

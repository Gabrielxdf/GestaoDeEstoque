package gestaoDeEstoque.util;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
/**
 * Classe para ser usada em Thread para abrir PDF.
 * @author Gabriel Henrique
 *
 */
public class AbrePdf implements Runnable{
	private File file;
	
	public AbrePdf(File file) {
		this.file = file;
	}
	
	@Override
	public void run() {
		abrePdf();
		
	}
	public void abrePdf() {
		try {
			Desktop.getDesktop().open(file);
		} catch (IOException e) {
			AlertUtil.criaUmAlert("Erro", "Não foi possível abrir o arquivo.",
					"Não foi possível abrir o arquivo: " + file.getAbsolutePath(), "ERROR");
		}
	}

}

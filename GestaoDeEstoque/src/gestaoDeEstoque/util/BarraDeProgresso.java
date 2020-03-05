package gestaoDeEstoque.util;

import javafx.scene.control.ProgressBar;

public class BarraDeProgresso implements Runnable{
	private ProgressBar barraDeProgresso = new ProgressBar(0.0);
	private Double valor;
	
	
	public BarraDeProgresso(ProgressBar barraDeProgresso) {
		super();
		this.barraDeProgresso = barraDeProgresso;
	}
	
	public BarraDeProgresso(ProgressBar barraDeProgresso, Double valor) {
		super();
		this.barraDeProgresso = barraDeProgresso;
		this.valor = valor;
	}
	
	private void carregaBarra() {
		barraDeProgresso.setVisible(true);
		//barraDeProgresso.setProgress(valor);
		for (Double i = 0.01; i < 1; i = i + 0.0000001) {
			barraDeProgresso.setProgress(i);
		}
	}

	public void setValor(Double valor) {
		this.barraDeProgresso.setProgress(valor);
	}
	
	@Override
	public void run() {
		carregaBarra();
		
	}

}

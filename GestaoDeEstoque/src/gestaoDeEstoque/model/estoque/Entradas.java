package gestaoDeEstoque.model.estoque;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Entradas {
private List<ProdutosEntrada> entrada = new ArrayList<>();
private String data;
private Double valorTotal = 0.0;
private String descricao;
private String numeroDocumento;

public Entradas(List<ProdutosEntrada> entrada, String descricao, String numeroDocumento) {
	this.entrada = entrada;
	this.data = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	for(ProdutosEntrada p : this.entrada) {
		Double valorDoProduto = Double.parseDouble(p.getValorTotalProperty().get());
		this.valorTotal += valorDoProduto;
	}
	this.descricao = descricao;
	this.numeroDocumento = numeroDocumento;
}

public List<ProdutosEntrada> getEntrada() {
	return entrada;
}

public String getData() {
	return data;
}

public Double getValorTotal() {
	return valorTotal;
}

public void setEntrada(List<ProdutosEntrada> entrada) {
	this.entrada = entrada;
}

public void setData(String data) {
	this.data = data;
}

public void setValorTotal(Double valorTotal) {
	this.valorTotal = valorTotal;
}

public String getDescricao() {
	return descricao;
}

public void setDescricao(String descricao) {
	this.descricao = descricao;
}

public String getNumeroDocumento() {
	return numeroDocumento;
}

public void setNumeroDocumento(String numeroDocumento) {
	this.numeroDocumento = numeroDocumento;
}

}

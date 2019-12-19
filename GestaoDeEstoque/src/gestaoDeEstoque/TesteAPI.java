package gestaoDeEstoque;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class TesteAPI {

	public static void main(String[] args) {
		// criação do documento
		Document document = new Document();
		try {

			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("GestaoDeEstoque/src/Entradas/Teste.pdf"));
			document.open();
			
			// adicionando um parágrafo no documento
			document.addCreationDate();
			document.addAuthor("MyStock");
			document.addSubject("Gerando PDF em Java");
			document.addKeywords("www.devmedia.com.br");
			PdfContentByte canvas = writer.getDirectContent();
	        CMYKColor blackColor = new CMYKColor(0.f, 0.f, 0.f, 100.f);
	        canvas.setColorStroke(blackColor);
	        canvas.moveTo(35, 800);
	        canvas.lineTo(560, 800);
	        canvas.moveTo(35, 750);
	        canvas.lineTo(560, 750);
	        canvas.closePathStroke();
			Paragraph p = new Paragraph("Entradas");
			p.setAlignment(1);
			document.add(new Paragraph(p));
			p = new Paragraph(" ");
			document.add(new Paragraph(p));
			
			PdfPTable table = new PdfPTable(4);
			table.setWidthPercentage(100);
			PdfPCell cell = new PdfPCell(new Paragraph("Nome do Produto"));
			PdfPCell cell1 = new PdfPCell(new Paragraph("Nome do Fornecedor"));
			PdfPCell cell2 = new PdfPCell(new Paragraph("Quantidade"));
			PdfPCell cell3 = new PdfPCell(new Paragraph("Valor"));

			table.addCell(cell);
			table.addCell(cell1);
			table.addCell(cell2);
			table.addCell(cell3);

			for (int i = 0; i < 10; i++) {
				cell = new PdfPCell(new Paragraph("Nome do Produto" + i));
				cell1 = new PdfPCell(new Paragraph("Nome do Fornecedor" + i));
				cell2 = new PdfPCell(new Paragraph("Quantidade" + i));
				cell3 = new PdfPCell(new Paragraph("Valor" + i));

				table.addCell(cell);
				table.addCell(cell1);
				table.addCell(cell2);
				table.addCell(cell3);
			}

			document.add(table);

		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		document.close();
		try {
			Desktop.getDesktop().open(new File("GestaoDeEstoque/src/Entradas/Teste.pdf"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
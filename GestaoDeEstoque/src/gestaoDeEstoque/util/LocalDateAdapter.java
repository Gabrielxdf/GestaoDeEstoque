package gestaoDeEstoque.util;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Adaptador (para JAXB) para converter entre LocalDate e representação String
 * ISO 8601 da data como '31/03/2000'.
 * 
 * @author Marco Jakob
 */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
	/**
	 * Faz o unmarshall do Adaptador do LocalDate.
	 * 
	 * @return LocalDate
	 */
	@Override
	public LocalDate unmarshal(String v) throws Exception {
		return LocalDate.parse(v);
	}

	/**
	 * Faz o marshal do Adaptador do LocalDate.
	 * 
	 * @return LocalDate
	 */
	@Override
	public String marshal(LocalDate v) throws Exception {
		return v.toString();
	}
}

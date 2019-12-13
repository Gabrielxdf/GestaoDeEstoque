package gestaoDeEstoque.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Classe para converter LocalDate para String e vice-versa.
 * @author Marco Jakob
 * @author Gabriel Henrique
 */
public class DateUtil {
    
    
    private static final String DATE_PATTERN = "dd/MM/yyyy";
    
    //O formatador de data.
    private static final DateTimeFormatter DATE_FORMATTER = 
            DateTimeFormatter.ofPattern(DATE_PATTERN);
    
    /**
     * Retorna a data especificada como uma Strin formatada. O 
     * {@link DateUtil#DATE_PATTERN} é usado.
     * 
     * @param date. A data a ser retornada como String.
     * @return String formatada.
     */
    public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER.format(date);
    }

    /**
     * Converte uma String no formato definido {@link DateUtil#DATE_PATTERN} 
     * para um objeto {@link LocalDate}.
     * 
     * Retorna null se o String não puder se convertido.
     * 
     * @param dateString a data como String
     * @return o Objeto LocalDate ou null se não puder ser convertido
     */
    public static LocalDate parse(String dateString) {
        try {
            return DATE_FORMATTER.parse(dateString, LocalDate::from);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    /**
     * Checa se a String é uma data válida.
     * @param dateString A data como String
     * @return true se a String é uma data válida, false se não for
     */
    public static boolean validDate(String dateString) {
        return DateUtil.parse(dateString) != null;
    }
}

package sistemaacademico.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

    public static Date stringToDate(String dateStr) {
        try {
            SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy");
            return curFormater.parse(dateStr);
        } catch (ParseException ex) {
            System.err.println("Erro no stringToCal");
            return null;
        }
    }

    public static String dateToString(Date date) {
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/YYYY");
        return ft.format(date);
    }
}

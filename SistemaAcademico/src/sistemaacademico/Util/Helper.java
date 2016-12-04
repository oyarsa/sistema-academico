package sistemaacademico.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

    private static final String FORMATO_DATA = "dd/MM/yyyy";
    private static final String FORMATO_HORA = "HH:mm";

    private static Date formatStrToDate(String format, String dateStr) {
        if (dateStr.trim().equals("")) {
            return new Date(0);
        }
        try {
            SimpleDateFormat curFormater = new SimpleDateFormat(format);
            return curFormater.parse(dateStr);
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private static String dateToFormatStr(String format, Date date) {
        if (date.getTime() == 0)
            return "";
        SimpleDateFormat ft = new SimpleDateFormat(format);
        return ft.format(date);
    }

    public static Date stringToDate(String dateStr) {
        return formatStrToDate(FORMATO_DATA, dateStr);
    }

    public static String dateToString(Date date) {
        return dateToFormatStr(FORMATO_DATA, date);
    }

    public static Date stringToTimeDate(String timeStr) {
        return formatStrToDate(FORMATO_HORA, timeStr);
    }

    public static String timeDateToString(Date time) {
        return dateToFormatStr(FORMATO_HORA, time);
    }

    public static boolean isInteiro(String str) {
        return str.matches("-?[0-9]+");
    }
}

package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XDate {

    static SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    public static Date toDate(String date) {

        try {
            return format.parse(date);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String toString(Date date) {
        return format.format(date);
    }

}

package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;

public class DateUtils {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).ofPattern("d-M-yyyy");

    public static LocalDate parse(String date) {
        LocalDate result = null;
        try {
            result = LocalDate.from(formatter.parse(date));
        } catch (DateTimeParseException e) {
            System.out.println(e.getMessage());
            result = LocalDate.now();
        }
        return result;
    }

    public static String format(LocalDate date) {
        return formatter.format(date);
    }

}

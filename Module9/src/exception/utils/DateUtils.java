package exception.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateUtils {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).ofPattern("dd-MM-yyyy");

    public static LocalDate parse(String date) {
        return LocalDate.from(formatter.parse(date));
    }

    public static String format(LocalDate date) {
        return formatter.format(date);
    }

}

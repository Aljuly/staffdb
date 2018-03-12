package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Utility functions for working with data
 *
 * @author Marco Jakob
 */
public class DateUtil {

    private DateUtil() {

    }

    /** Date template for conversion */
    private static final String DATE_PATTERN = "dd.MM.yyyy";

    /** Date formatter */
    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern(DATE_PATTERN);

    /**
     * Returns obtained date as a well formatted string
     * Using defined {@link DateUtil#DATE_PATTERN}.
     *
     * @param date - Date which will be returned as a String
     * @return formatted string
     */
    public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER.format(date);
    }

    /**
     * Convert string, which formatted by
     * template rules {@link DateUtil#DATE_PATTERN} into object {@link LocalDate}.
     *
     * Returns null, if the string can't be converted
     *
     * @param dateString - String date
     * @return Date Object or null, if the String can't be converted
     */
    public static LocalDate parse(String dateString) {
        try {
            return DATE_FORMATTER.parse(dateString, LocalDate::from);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    /**
     * Checking, does the Sting is a correct Date
     *
     * @param dateString
     * @return true, if the String is a correct Date
     */
    public static boolean validDate(String dateString) {
        return DateUtil.parse(dateString) != null;
    }
}

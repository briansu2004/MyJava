import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class OffsetDateTimeFormatCheckerSimple {
    public static boolean isOffsetDateTimeFormat(String dateTimeString, String formatPattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);
        try {
            OffsetDateTime.parse(dateTimeString, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String inputString = "2023-08-31T15:30:45+00:00"; // Example input string
        String formatPattern = "yyyy-MM-dd'T'HH:mm:ssXXX"; // Format pattern for OffsetDateTime

        boolean isOffsetDateTime = isOffsetDateTimeFormat(inputString, formatPattern);

        System.out.println("Is OffsetDateTime format: " + isOffsetDateTime);
    }
}

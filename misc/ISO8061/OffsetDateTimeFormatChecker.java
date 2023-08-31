import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class OffsetDateTimeFormatChecker {
    public static boolean isOffsetDateTimeFormat(String dateTimeString) {
        List<String> formatPatterns = new ArrayList<>();
        formatPatterns.add("yyyy-MM-dd'T'HH:mm:ssXXX");
        formatPatterns.add("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        formatPatterns.add("yyyy-MM-dd'T'HH:mm:ss");
        formatPatterns.add("yyyy-MM-dd'T'HH:mm:ss.SSS");
        // Add more format patterns as needed

        for (String formatPattern : formatPatterns) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);
            try {
                OffsetDateTime.parse(dateTimeString, formatter);
                return true;
            } catch (DateTimeParseException e) {
                // Parsing failed for this format, try the next one
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String inputString = "2023-08-31T15:30:45+00:00"; // Example input string
        System.out.println(String.format("%s is OffsetDateTime format: %b", inputString,
                isOffsetDateTimeFormat(inputString)));

    }
}

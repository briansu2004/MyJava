import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Try3 {
    public static OffsetDateTime parseISO8601String(String input) {
        List<String> formatPatterns = new ArrayList<>();

        formatPatterns.add("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        formatPatterns.add("yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX");
        formatPatterns.add("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        formatPatterns.add("yyyy-MM-dd'T'HH:mm:ssXXX");
        formatPatterns.add("yyyy-MM-dd'T'HH:mm:ss.SSS");
        formatPatterns.add("yyyy-MM-dd'T'HH:mm:ss");
        formatPatterns.add("yyyy-MM-dd'T'HH:mm");
        formatPatterns.add("yyyy-MM-dd'T'HH:mmX");

        for (String formatPattern : formatPatterns) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);
            try {
                return OffsetDateTime.parse(input, formatter);
            } catch (DateTimeParseException e) {
                // Parsing failed for this format, try the next one
            }
        }

        return null;
    }


    public static void parseString(String input) {
        System.out.println(String.format("%s -> %s", input, parseISO8601String(input)));
    }

    public static void main(String[] args) {
        parseString("2023-08-31T15:30:45.123");
    }
}

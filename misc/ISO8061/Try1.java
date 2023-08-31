import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Try1 {
    public static OffsetDateTime parseISO8601String(String input) {
        List<String> formatPatterns = new ArrayList<>();

        formatPatterns.add("yyyyMMdd'T'HHmmss.SSSX");
        formatPatterns.add("yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX");
        formatPatterns.add("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        formatPatterns.add("yyyy-MM-dd'T'HH:mm:ssXXX");
        formatPatterns.add("yyyy-MM-dd'T'HH:mmXXX");
        formatPatterns.add("yyyy-MM-dd'T'HH:mm:ss.SSS");
        formatPatterns.add("yyyy-MM-dd'T'HH:mm:ss");
        formatPatterns.add("yyyy-MM-dd'T'HH:mm");
        formatPatterns.add("yyyy-MM-dd");
        formatPatterns.add("yyyyMMdd'T'HHmmss.SSSZ");
        formatPatterns.add("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        formatPatterns.add("yyyyMMdd'T'HHmmZ");
        formatPatterns.add("yyyy-MM-dd'T'HH:mmZ");
        formatPatterns.add("yyyyMMdd'T'HHmmss.SSS");
        formatPatterns.add("yyyyMMdd");
        formatPatterns.add("yyyy-MM-dd'T'HH:mm:ssX");
        formatPatterns.add("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        formatPatterns.add("yyyyMMdd'T'HHmmssX");
        formatPatterns.add("yyyy-MM-dd'T'HH:mm:ss");
        formatPatterns.add("yyyyMMdd'T'HHmmss");
        formatPatterns.add("yyyyMMdd'T'HHmmX"); // Fix for "20230831T1530Z"

        
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
        parseString("2023-08-31T15:30:45+00:00");
        parseString("20230831T153045.123Z");
        parseString("2023-08-31T15:30:45.123Z");
        parseString("20230831T1530Z");
        parseString("2023-08-31T15:30Z");
        parseString("20230831T153045.123");
        parseString("2023-08-31T15:30:45.123");
        parseString("20230831");
        parseString("2023-08-31");
    }
}

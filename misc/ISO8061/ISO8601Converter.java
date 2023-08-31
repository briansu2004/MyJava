import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ISO8601Converter {
    public static OffsetDateTime parseISO8601String(String input) {
        try {
            return OffsetDateTime.parse(input, DateTimeFormatter.ISO_DATE_TIME);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        String input = "2023-08-22T21:51:31.732944-04:00"; // Example input string

        OffsetDateTime offsetDateTime = parseISO8601String(input);

        if (offsetDateTime != null) {
            System.out.println("Parsed OffsetDateTime: " + offsetDateTime);
        } else {
            System.out.println("Input string is not in ISO8601 format.");
        }
    }
}

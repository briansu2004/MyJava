import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;

public class ISO8601Converter1 {
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

        OffsetDateTime offsetDateTime1 = OffsetDateTime.now();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        String formatted1 = offsetDateTime1.format(formatter1);
        System.out.println(formatted1);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ssXXX");
        String formatted2 = offsetDateTime1.format(formatter2);
        System.out.println(formatted2);
        DateTimeFormatter formatter3 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        String formatted3 = offsetDateTime1.format(formatter3);
        System.out.println(formatted3);


    }
}

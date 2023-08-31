import java.time.LocalDate;
import java.time.OffsetDateTime;

public class OffsetDateTimeToLocalDateExample {
    public static LocalDate offsetDateTimeToNullableLocalDate(OffsetDateTime odt) {
        if (odt == null) {
            return null;
        }
        return odt.toLocalDate();
    }

    public static void main(String[] args) {
        // Create an OffsetDateTime instance
        OffsetDateTime offsetDateTime = OffsetDateTime.now();

        // Convert OffsetDateTime to LocalDate using the function
        LocalDate localDate = offsetDateTimeToNullableLocalDate(offsetDateTime);
        
        // Convert a null OffsetDateTime
        LocalDate nullLocalDate = offsetDateTimeToNullableLocalDate(null);

        // Print the OffsetDateTime and LocalDate
        System.out.println("OffsetDateTime: " + offsetDateTime);
        System.out.println("LocalDate: " + localDate);
        System.out.println("Null LocalDate: " + nullLocalDate);
    }
}

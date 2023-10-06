import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class Util {
    public static LocalDate convertString2LocalDate(String timestampString) {
        try {
            long timestamp = Long.parseLong(timestampString);
            Instant instant = Instant.ofEpochMilli(timestamp);
            ZoneId zoneId = ZoneId.of("UTC");
            LocalDate localDate = instant.atZone(zoneId).toLocalDate();
            return localDate;
        } catch (NumberFormatException e) {
            return null;
        }
    }
}

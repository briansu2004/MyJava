import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

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

    public static String convertDate2String(Date date) {
        try {
            // Create a SimpleDateFormat with the desired output format
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            // Format the date and store it as a string
            return sdf.format(date);
        } catch (Exception e) {
            return null;
        }
    }
}

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class EDT {
    static DateTimeFormatter globalFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mma z");
    static DateTimeFormatter etFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mma 'ET'");

    static ZoneId istZoneId = ZoneId.of("Asia/Kolkata");
    static ZoneId etZoneId = ZoneId.of("America/New_York");

    public static void main(String[] args) {
        LocalDateTime currentDateTime = LocalDateTime.now();

        ZonedDateTime currentISTime = currentDateTime.atZone(istZoneId); // India Time
        ZonedDateTime currentETime = currentISTime.withZoneSameInstant(etZoneId); // ET Time

        System.out.println(globalFormat.format(currentISTime));
        System.out.println(etFormat.format(currentETime));
    }
}

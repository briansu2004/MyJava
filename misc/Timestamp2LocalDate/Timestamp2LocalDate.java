
public class Timestamp2LocalDate {
    public static void main(String[] args) {
        String timestampString = "1735707600000";
        System.out.println(String.format("%s -> %s", timestampString,
                Util.convertString2LocalDate(timestampString)));

        timestampString = "1767157200000";
        System.out.println(String.format("%s -> %s", timestampString,
                Util.convertString2LocalDate(timestampString)));
    }
}

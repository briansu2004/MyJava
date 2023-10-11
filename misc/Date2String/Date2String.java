import java.util.Date;

public class Date2String {
    public static void main(String[] args) {
        Date date = new Date("Mon Apr 01 00:00:00 EDT 2013");
        System.out.println(String.format("%s -> %s", date, Util.convertDate2String(date)));

    }
}

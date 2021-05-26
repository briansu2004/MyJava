import java.text.SimpleDateFormat;
import java.util.Date;

public class Rfc3339 {

    public static void main(String[] args) {
        //System.out.println("Hello");

        String timestamp = new SimpleDateFormat("yyyy-MM-dd'T'h:m:ssZ").format(new Date());
        System.out.println(timestamp); //2021-05-25T1:21:53-0400

        //String t = new SimpleDateFormat("yyyy-MM-dd'T'h:m:ssZ").parse("2008-11-13T13:23:30-08:00");
        //Type mismatch: cannot convert from Date to String

        timestamp = new SimpleDateFormat("yyyy-MM-dd'T'h:m:SZ").format(new Date());
        System.out.println(timestamp); //2021-05-25T1:24:160-0400

        SimpleDateFormat rfc3339 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        timestamp = rfc3339.format(new Date()).replaceAll("(\\d\\d)(\\d\\d)$", "$1:$2");
        System.out.println(timestamp); //2021-05-25T13:26:44-04:00

        timestamp = new SimpleDateFormat("yyyy-MM-dd'T'h:m:ss'Z'").format(new Date());
        System.out.println(timestamp); //
    }

}

import java.util.ArrayList;
import java.util.HashMap;

public class test1 {

    public static void main(String[] args) {
        Util util = new Util();

        // String a[] = new String[] { "Brian", "Su", "Telus", "Brian", "Su" };

        ArrayList<String> data = new ArrayList<String>();
        // data.add("B");
        // data.add("B");
        // data.add("B");
        // data.add("S");

        // ArrayList<String> data = Arrays.asList(a); // = (ArrayList<String>)
        // Arrays.asList("Brian", "Su", "Telus",
        // "Brian", "Su");

        HashMap<String, Integer> result = Util.FreqCnt(data);
        System.out.println(result);

    }
}

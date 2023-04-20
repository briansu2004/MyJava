import java.util.ArrayList;
import java.util.List;

public class SimpleSerializeCharacteristic {
    public static void main(String[] args) {

        List<Characteristic> lst = new ArrayList<>();

        lst.add(new Characteristic("Name", "Brian Su"));
        lst.add(new Characteristic("Gender", "Male"));
        lst.add(new Characteristic("Hobby", "Write courses"));

        String str = AppUtil.SerializeCharacteristicListToString(lst);

        System.out.println("Serilize: " + str);
        System.out.println("lst.toString(): " + lst.toString());

    }

}

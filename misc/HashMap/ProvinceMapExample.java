import java.util.ArrayList;
import java.util.List;

public class ProvinceMapExample {
    public static void main(String[] args) {
        // Example usage
        // Provider provider = new Provider();
        // List<MyObj> uinList = provider.getMyObjList();

        List<MyObj> uinList = new ArrayList<>();
        uinList.add(new MyObj("FAKE"));
        uinList.add(new MyObj("ON"));
        uinList.add(new MyObj("QC"));
        uinList.add(new MyObj("BC"));

        for (MyObj uin : uinList) {
            uin.setProvince(Util.getProvinceBasedOnLocale(uin.getProvince()));
        }

        for (MyObj uin : uinList) {
            System.out.println("Province: " + uin.getProvince());
        }
    }
}

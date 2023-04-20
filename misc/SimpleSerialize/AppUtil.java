import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AppUtil {
    public static String SerializeCharacteristicListToString(List<Characteristic> lst) {
        if (lst == null) {
            return null;
        }

        if (lst.size() == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (Characteristic c : lst) {
            sb.append("{").append("name:").append(c.getName()).append(",value:").append(c.getValue()).append("}")
                    .append(",");
        }

        return sb.deleteCharAt(sb.length() - 1).append("]").toString();
    }

    public static List<Characteristic> DeserializeStringToCharacteristicList(String str) {
        if (str == null || str.trim().isEmpty() || str.trim().equals("[]")) {
            return new ArrayList<>();
        }

        List<Characteristic> result = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(str);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                String value = jsonObject.getString("value");
                String additionalField = null;
                if (jsonObject.has("addtionalField")) {
                    additionalField = jsonObject.getString("addtionalField");
                }
                result.add(new Characteristic(name, value, additionalField));
            }
        } catch (JSONException e) {
            // handle the exception
        }

        return result;
    }

}

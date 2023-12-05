import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Util {

    private static boolean isFrench() {
        return "fr".equalsIgnoreCase(Locale.getDefault().getLanguage());
    }

    private static final Map<String, String> ENGLISH_PROVINCE_MAP = createEnglishProvinceMap();
    private static final Map<String, String> FRENCH_PROVINCE_MAP = createFrenchProvinceMap();

    private static Map<String, String> createEnglishProvinceMap() {
        Map<String, String> map = new HashMap<>();
        map.put("BC", "British Columbia");
        map.put("ON", "Ontario");
        map.put("QC", "Quebec");
        // Add other English provinces as needed
        return map;
    }

    private static Map<String, String> createFrenchProvinceMap() {
        Map<String, String> map = new HashMap<>();
        map.put("BC", "Colombie-Britannique");
        map.put("ON", "Ontario");
        map.put("QC", "Québec");
        // Add other French provinces as needed
        return map;
    }

    public static String getProvinceBasedOnLocale(String provinceCode) {
        Map<String, String> provinceMap = isFrench() ? FRENCH_PROVINCE_MAP : ENGLISH_PROVINCE_MAP;
        return provinceMap.getOrDefault(provinceCode, provinceCode);
    }


}

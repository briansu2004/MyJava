import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class Util {

    public static HashMap<String, Integer> FreqCnt(ArrayList<String> data) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        for (Integer i = 0; i < data.size(); i++) {
            if (result.containsKey(data.get(i)))
                result.put(data.get(i), result.get(data.get(i)) + 1);
            else
                result.put(data.get(i), 1);
        }
        return result;
    }

    public static <K, V, T> Map<K, V> frequencyCount(Collection<T> items) {
        var frequencies = new HashMap<K, V>();
        for (var key : items) {
            frequencies.put(key, frequencies.getOrDefault(key, 0) + 1);
        }
        return frequencies;
    }

}
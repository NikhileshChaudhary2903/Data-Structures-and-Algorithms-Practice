import java.util.HashMap;
import java.util.Map;

public class MapUtility {
    public static void main(String[] x) {

        HashMap<String, String> map = new HashMap<>();
        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>(map);

        map.put("hellow", "world");
        map.get("hellow");
        map.getOrDefault("not", "null");
        map.clear();
        map.remove("hellow");
        map.isEmpty();
        map.size();
        map.containsKey("key");
        map.containsValue("val");
        map.putIfAbsent("k", "v");
        map1.putAll(map);

        map.forEach((k, v) -> System.out.println(k + ": " + v));

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        for (String key : map.keySet()) {
        }
        for (String val : map.values()) {
        }
    }
}

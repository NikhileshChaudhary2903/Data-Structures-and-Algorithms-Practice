import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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

        // HashSet

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.remove(1);
        set.contains(1);
        set.size();
        set.isEmpty();
        set.clear();

        HashSet<Integer> set1 = new HashSet<>(set);
        HashSet<Integer> set2 = new HashSet<>();

        // union
        set1.addAll(set2);

        // intersection
        set1.retainAll(set2);

        // set diff will remove set2 elements
        set1.removeAll(set2);

        for (Integer s : set) {
        }

        int[] nums = {1, 2, 2, 3, 4, 4};
        // Convert to Set (using Streams for primitives)
        Set<Integer> unique = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        // Convert set to primitive array
        int[] array = set1.stream().mapToInt(Integer::intValue).toArray();
    }
}

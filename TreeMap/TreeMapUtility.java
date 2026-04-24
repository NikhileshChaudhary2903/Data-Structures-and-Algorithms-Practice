import java.util.TreeMap;
import java.util.Map;

public class TreeMapUtility {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(10, "Ten");
        map.put(20, "Twenty");
        map.put(30, "Thirty");

        // 1. Basic Navigation (O(log n))
        map.firstKey();       // 10
        map.lastKey();        // 30
        map.firstEntry();     // 10="Ten"
        
        // 2. Proximity Searches (The most important part)
        // floorKey(k)   -> key <= k
        // ceilingKey(k) -> key >= k
        // lowerKey(k)   -> key < k
        // higherKey(k)  -> key > k
        Integer fK = map.floorKey(15);      // 10
        Integer cK = map.ceilingKey(15);    // 20
        
        Map.Entry<Integer, String> fE = map.floorEntry(15); // 10="Ten"

        // 3. Polling (Destructive - removes the entry)
        map.pollFirstEntry(); // Removes and returns 10="Ten"
        map.pollLastEntry();  // Removes and returns 30="Thirty"

        // 4. Sub-Maps (Range Views)
        // subMap(from, fromInclusive, to, toInclusive)
        var range = map.subMap(10, true, 25, true); // Entries between 10 and 25
    }
}

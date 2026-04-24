import java.util.TreeSet;
import java.util.Arrays;
import java.util.Iterator;

public class TreeSetUtility {
    public static void main(String[] args) {
        // 1. Initialization
        TreeSet<Integer> set = new TreeSet<>();
        
        // Custom Comparator (e.g., Reverse Order)
        TreeSet<Integer> revSet = new TreeSet<>((a, b) -> b - a);

        // 2. Basic Operations - All are O(log n)
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(50);

        set.remove(40);
        boolean hasTen = set.contains(10); // true
        int size = set.size();             // 4
        boolean empty = set.isEmpty();     // false

        // 3. Navigation Methods (The "Interview Gold")
        // These return null if no such element exists
        int first = set.first();           // 10 (smallest)
        int last = set.last();             // 50 (largest)

        // floor(n) -> <= n | ceiling(n) -> >= n
        Integer floor = set.floor(25);     // 20
        Integer ceil = set.ceiling(25);    // 30

        // lower(n) -> < n | higher(n) -> > n
        Integer lower = set.lower(20);     // 10
        Integer higher = set.higher(20);   // 30

        // 4. Polling (Useful for PriorityQueue-like behavior)
        Integer smallest = set.pollFirst(); // Retrieves and removes 10
        Integer largest = set.pollLast();   // Retrieves and removes 50

        // 5. Range Views (Returns a view, not a copy)
        // subSet(from, to) -> from is inclusive, to is exclusive
        var sub = set.subSet(20, 40);      // [20, 30]
        var head = set.headSet(30);        // Elements < 30
        var tail = set.tailSet(30);        // Elements >= 30

        // 6. Iterating
        // Ascending (Default)
        for (Integer val : set) { 
            // System.out.println(val);
        }

        // Descending
        Iterator<Integer> descIt = set.descendingIterator();
        // Or get a reverse view
        var reverseView = set.descendingSet();
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListUtility {
    public static void main(String[] args) {
        // ArrayList
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(0, 3);
        // removes element at index
        list.remove(1);
        boolean contains = list.contains(1);
        list.get(0);
        list.set(1, 4);
        list.size();
        list.isEmpty();
        list.clear();
        list.sort(Collections.reverseOrder());

        String[] arr = list.toArray(new String[0]);
        list.toArray(String[]::new);
        // new String[0] is the modern, preferred way for type safety.
        List<String> list1 = new ArrayList<>(Arrays.asList(arr));
        // Wrapping in new ArrayList<>() makes the list mutable (you can add/remove).

        int[] arr1 = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        int[] nums = {1, 2, 3};
        list = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());

        Collections.sort(list);
        Collections.sort(list, (a, b) -> b - a);
        Collections.max(list);
        Collections.reverse(list);
        Collections.swap(list, 0, 1);
    }
}

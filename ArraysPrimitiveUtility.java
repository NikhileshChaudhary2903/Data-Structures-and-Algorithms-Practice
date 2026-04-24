import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraysPrimitiveUtility {

    public static void main(String[] args) {
        int a[] = new int[]{1, -2, -3, 4};

        Arrays.sort(a);
        // same number and same pair of elements corr to each index
        Arrays.equals(a, new int[]{2, 3, 4});
        Arrays.toString(a);
        Arrays.fill(a, -1);
        Arrays.copyOf(a, 5);
        Arrays.sort(a, 2, 4);

        // Arrays.deepToString(matrix)
        // Arrays.copyOfRange(a, from, to)

        int[] nums = { 5, 2, 8, 1, 9, 2 };

        // Method A: Standard
        IntStream myStream = Arrays.stream(nums);

        // Method B: For a specific range (index 1 to 4)
        IntStream rangedStream = Arrays.stream(nums, 1, 4);

        int sum = Arrays.stream(nums).sum();
        long uniqueCount = Arrays.stream(nums).distinct().count();

        int max = Arrays.stream(nums).max().getAsInt(); // returns OptionalInt
        double avg = Arrays.stream(nums).average().getAsDouble();
        long count = Arrays.stream(nums).count();
        int m = 5;
        // Scenario: Find the sum of squares of all numbers greater than 3.
        int sumOfSquares = Arrays.stream(nums).filter(n -> n > 3).map(n -> n * n).sum();

        // 1. To another Primitive Array
        int[] doubled = Arrays.stream(nums).map(n -> n * 2).toArray();

        // 2. To a List<Integer> (Crucial Step: .boxed())
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());

        // Prints 0 to 9
        IntStream.range(0, 10).forEach(System.out::println);

        // Prints 0 to 10
        IntStream.rangeClosed(0, 10).forEach(System.out::println);

        // Linear search
        int index = IntStream.range(0, nums.length).filter(i -> nums[i] > 100).findFirst().orElse(-1); // Result: 2

    }
}

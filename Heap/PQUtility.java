import java.util.PriorityQueue;
import java.util.Collections;

public class PQUtility {
    public static void main(String[] args) {
      // Min-Heap (Default): Smallest element at top
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Max-Heap: Largest element at top
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // Custom Comparator (e.g., for an array or object)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
              
        // 1. Min-Heap (Smallest element stays at the root)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] nums = {10, 2, 8, 1, 15};
        for (int n : nums) pq.offer(n);

        // Standard retrieval: 1, 2, 8, 10, 15
        while (!pq.isEmpty()) {
            // System.out.println(pq.poll()); 
        }

        // 2. The "Top K" Pattern (Finding the K largest elements)
        // Trick: Use a Min-Heap of size K.
        int k = 3;
        PriorityQueue<Integer> topK = new PriorityQueue<>();
        for (int n : nums) {
            topK.offer(n);
            if (topK.size() > k) {
                topK.poll(); // Removes the smallest of the current "top" elements
            }
        }
        // Result: topK now contains the 3 largest elements: [8, 10, 15]
    }
}

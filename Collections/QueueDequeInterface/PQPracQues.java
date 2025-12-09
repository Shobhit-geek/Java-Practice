package Collections.QueueDequeInterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PQPracQues {
    public static void main(String[] args) {
        // ✅ 1️⃣ K Largest Elements in an Array

        // Input: [3,2,1,5,6,4], k = 2
        // Output: [6,5]
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        List<Integer> alist = List.of(3,2,1,5,6,4);
        pq.addAll(alist);
        System.out.println(pq.peek());
        pq.remove();
        System.out.println(pq.peek());


        // ✅ 2️⃣ K Smallest Elements

        // Input: [7,10,4,3,20,15], k = 3
        // Output: [3,4,7]

        // ✅ 3️⃣ Sort a Nearly Sorted Array (k-sorted array)

        // Each element is at most k positions away.

        // Hint:
        // Use min-heap of size k+1.

        // Difficulty: ★★★
        // Heap: Min-Heap

        // ✅ 4️⃣ Frequency Sort (characters by frequency)

        // Input: "tree"
        // Output: "eert" or "eetr"

        // Hint:
        // Use max-heap based on frequency.

        // Difficulty: ★★★
        // Heap: Max-Heap (custom comparator)

        // ✅ 5️⃣ Connect Ropes with Minimum Cost

        // Input: [4,3,2,6]
        // Output: 29

        // Explanation:
        // 4+3=7,
        // 7+2=9,
        // 9+6=15
        // Total = 7+9+15 = 29

        // Hint:
        // Min-heap → repeatedly take two smallest.

        // Difficulty: ★★★
        // Heap: Min-Heap

        // ✅ 6️⃣ K Closest Numbers to X

        // Input: arr = [10,2,14,4,7,6], k=3, x=5
        // Output: [4,6,7]

        // Hint:
        // Use a max-heap of size k storing pair (distance, number).

        // Difficulty: ★★★
        // Heap: Max-Heap

        // ✅ 7️⃣ Find Median from Data Stream

        // Insert numbers and return median at any point.

        // Hint:
        // Use two heaps:
        // ✔ Max-heap for left half
        // ✔ Min-heap for right half

        // Difficulty: ★★★★★
        // Heaps: Min + Max

        // ✅ 8️⃣ Merge K Sorted Lists

        // Hint:
        // Use min-heap storing first element of each list.

        // Difficulty: ★★★★
        // Heap: Min-Heap with (value, listIndex)

        // ✅ 9️⃣ Top K Frequent Elements

        // Input: [1,1,1,2,2,3], k = 2
        // Output: [1,2]

        // Hint:
        // Use min-heap of size k with frequencies.

        // Difficulty: ★★★
        // Heap: Min-Heap

        // ✅ 🔟 Find K Most Frequent Words

        // Input: ["i","love","leetcode","i","love","coding"], k=2
        // Output: ["i","love"]

        // Hint:
        // Custom comparator:

        // First by frequency

        // Then lexicographically

        // Difficulty: ★★★★
        // Heap: Min-Heap (custom comparator)

        // ✅ 1️⃣1️⃣ Reorganize String → No two adjacent same

        // Input: "aab"
        // Output: "aba"

        // Hint:
        // Max-heap with counts
        // Always pick two most frequent characters.

        // Difficulty: ★★★★
        // Heap: Max-Heap

        // ✅ 1️⃣2️⃣ Kth Largest Element in a Stream

        // Add numbers continuously and track Kth largest.

        // Hint:
        // Use min-heap of fixed size k.

        // Difficulty: ★★★
        // Heap: Min-Heap
    }
}

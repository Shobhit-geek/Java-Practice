package Collections.QueueDequeInterface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// 🔥 1. What is a PriorityQueue?
// A PriorityQueue is a special queue where elements are removed in priority order—not in insertion order.

// Default behavior:
    // Min-Heap
    // ➡ Smallest element always comes out first
    // ➡ Highest priority = smallest value

// 🔥 2. Internal Working (MOST IMPORTANT)

    // Java PriorityQueue is implemented using:

    // ✔ Binary Heap (complete binary tree)
    // ✔ Stored in array internally
    // ✔ Heapify, percolate up/down operations

    // Internal structure looks like:
    //         2
    //      /     \
    //     4       7
    //    / \     / \
    //   9  10   15  21

    // Always the smallest element stays at root.

// Why is removal efficient?

    // Removing root runs in O(log n)
    // Adding runs in O(log n)
    // Peek runs in O(1)

// 🔥 3. Basic Operations
    // | Operation       | Method         | Time     |
    // | --------------- | -------------- | -------- |
    // | Insert element  | add(), offer() | O(log n) |
    // | Get smallest    | peek()         | O(1)     |
    // | Remove smallest | poll()         | O(log n) |
    // | Size            | size()         | O(1)     |
    // | Check empty     | isEmpty()      | O(1)     |

public class PriorityQueuee {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(5);
        pq.add(20);
        pq.add(1);
        // add() will:
        // ✔ Throws exception if insertion fails
        // ✔ Maintains heap order internally

        // ✅ offer() → safer add()
        pq.offer(5);
        // ✔ Does NOT throw exception
        // ✔ Returns false if insertion fails

        // ✅ contains() → check if element exists
        System.out.println(pq.contains(10));
        
        System.out.println(pq); // [1, 5, 20, 10] (heap order, not sorted)
        System.out.println(pq.size());
        System.out.println(pq.isEmpty());

        // ✅ peek() → get min element (but do NOT remove)
        System.out.println("Peek element: "+pq.peek());
            // ✔ O(1)
            // ✔ Returns null if queue empty
            // ✔ Head element = smallest (min-heap)

        // ✅ element() → same as peek(), but throws exception
        System.out.println(pq.element());
        // ❌ Throws NoSuchElementException if empty

        while(!pq.isEmpty()){
            // ✅ poll() → remove and return smallest element
            System.out.print(pq.poll()+", ");  
        }

        // ✅ remove() → same as poll(), but throws exception
        // pq.remove();
        // ❌ Throws exception if queue empty
        
        // ⭐ remove(Object o) → remove specific element
        // pq.remove(20);  // removes 20 if present
        // ✔ O(n), because it searches
        // ✔ Safely removes specific element

        // ⭐ Max-Heap PriorityQueue

        // Java PriorityQueue is min-heap by default.
        // To make max-heap, use Comparator:
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Comparator.reverseOrder());

        // OR   custom:
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        maxpq.add(10);
        maxpq.add(5);
        maxpq.add(20);
        maxpq.add(1);
        System.out.println("Max-Heap PQ elements: "+ maxpq);

        while (!maxpq.isEmpty()) {
            System.out.print(maxpq.poll() + ", ");
        }

        // ⭐ 7. PriorityQueue Important Notes
            //✔ Does not allow null → NullPointerException
            //✔ Allows duplicate values
            //✔ Order PRINTED is NOT sorted

        // PriorityQueue maintains heap order, not sorted order.

        // ⭐ Convert PriorityQueue → List
        // List<Integer> list = new ArrayList<>(pq);
    }

}

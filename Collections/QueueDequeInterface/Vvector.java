package Collections.QueueDequeInterface;

import java.util.Vector;

public class Vvector {
    public static void main(String[] args) {
    // 🔥 1. VECTOR (Legacy Class)

    // 📌 What is Vector?
    // Vector is a dynamic array like ArrayList but:

    // | Feature         | Vector                | ArrayList    |
    // | --------------- | --------------------- | ------------ |
    // | Synchronization | **Yes (thread-safe)** | No           |
    // | Performance     | Slower                | Faster       |
    // | Legacy?         | Yes                   | Modern       |
    // | Growth factor   | Doubles capacity      | Grows by 50% |

    // 👉 Today, Vector is not recommended (use ArrayList or CopyOnWriteArrayList instead).

        Vector<Integer> v = new Vector<>();

        // Add elements
        v.add(10);
        v.add(20);
        v.add(30);

        // Add at index
        v.add(1, 99);

        // Get element
        System.out.println("Element at index 2: " + v.get(2));

        // Remove element
        v.remove(Integer.valueOf(20));

        // Size and capacity
        System.out.println("Size: " + v.size());
        System.out.println("Capacity: " + v.capacity());

        // Iterate
        for (Integer x : v) {
            System.out.print(x + " ");
        }
    }

}

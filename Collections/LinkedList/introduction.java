package Collections.LinkedList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

// 🔹1 ️What is LinkedList?(Interview Definition)
// LinkedList is a doubly linked list implementation of the List and Deque interfaces that allows fast 
// insertion and deletion but slower access.

// ✅2 ️Internal Working(MOST IMPORTANT DIFFERENCE)

// 🔥ArrayList(Behind the scenes) [10,20,30,40]
// Stored in continuous memory
// Index-based access is fast

// 🔥LinkedList(Behind the scenes) null←10⇄20⇄30⇄40→null

// Each element is a node:
// class Node {
//     Node prev;
//     Object data;
//     Node next;}

// ✅Each node knows: Previous element and Next element

// | Feature             | ArrayList         | LinkedList               |
// | ------------------- | ---------------   | ------------------------ |
// | Internal Structure  | Dynamic Array     | Doubly Linked List       |
// | Access (get)        | ✅ O(1) Fast     | ❌ O(n) Slow              |
// | Insertion at Middle | ❌ O(n)          | ✅ O(1)                   |
// | Deletion at Middle  | ❌ O(n)          | ✅ O(1)                   |
// | Memory Usage        | ✅ Less          | ❌ More (extra pointers)  |
// | Best Use            | Read-heavy apps   | Insert/Delete-heavy apps |

// ✅ Golden Rule:
// More reading → ArrayList
// More inserting/removing → LinkedList

public class introduction {

    public static void main(String[] args) {

        // Creating a LinkedList that stores Integer objects
        // Here, ll is an empty LinkedList initially
        LinkedList<Integer> ll = new LinkedList<>();

        // add(10) → Adds the value 10 at the end of the LinkedList
        ll.add(10);
        // List now: [10]

        // addFirst(20) → Adds 20 at the beginning (head) of the LinkedList
        ll.addFirst(20);
        // List now: [20, 10]

        // addLast(30) → Adds 30 at the end (tail) of the LinkedList
        ll.addLast(30);
        // List now: [20, 10, 30]
        ll.add(3, 80); // add(index, element)
        
        // addAll(): It adds each element one-by-one into the LinkedList.
        ll.addAll(Arrays.asList(33, 34, 35, 36, 37));

        // Creating an Iterator to traverse (loop through) the LinkedList
        Iterator<Integer> it = ll.iterator();

        // hasNext() checks if there is a next element in the list
        // The loop continues until all elements are printed
        while (it.hasNext()) {

            // next() returns the next available element from the list
            // print() is used instead of println() so values appear in one line
            System.out.print(it.next() + " ");
        }

        //✅ 3️⃣ ACCESS / READ OPERATIONS
        // Method	            Purpose
        // get(int index)	    Get element by index
        // getFirst()	        First element
        // getLast()	        Last element
        // peek()	            First element (no remove)
        // peekFirst()	        First element
        // peekLast()	        Last element

        System.out.println(ll.get(1));
        System.out.println(ll.getFirst());
        System.out.println(ll.peek());

        // ✅ 4️⃣ UPDATE / MODIFY OPERATIONS
        // Method	            Purpose
        // set(int index, E e)	Replace element

        ll.set(1, 99);

        it = ll.iterator(); // ✅ Reinitialization
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        // ✅ 5️⃣ REMOVE / DELETE OPERATIONS (INTERVIEW FAVORITE)
        // Method	                What it Removes
        // remove()	                First element
        // remove(int index)	    By index
        // remove(Object o)	        By value
        // removeFirst()	        First
        // removeLast()	            Last
        // poll()	                First (queue style)
        // pollFirst()	            First
        // pollLast()	            Last
        // clear()	                All elements

        ll.remove();
        ll.remove(1);
        ll.remove(Integer.valueOf(36));   // ✅ removes VALUE 36 safely
        ll.removeLast();

        System.out.println("After Removal operation, printing LL");
        it = ll.iterator(); // ✅ Reinitialization
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        // ✅ 6️⃣ SEARCH OPERATIONS
        // Method	                Purpose
        // contains(Object o)	    Element exists or not
        // indexOf(Object o)	    First index
        // lastIndexOf(Object o)	Last index

        System.out.println(ll.contains(20));
        System.out.println(ll.indexOf(80));


        // ✅ 7️⃣ STACK OPERATIONS (LIFO)- Because LinkedList implements Deque
        // Method	Stack Operation
        // push(E e)	Push to top
        // pop()	Remove top

        ll.push(100);
        ll.push(101);
        ll.pop();

        // ✅ 8️⃣ QUEUE OPERATIONS (FIFO)
        //     Method	Queue Operation
        //     offer(E e)	Insert
        //     poll()	Remove
        //     peek()	View

        ll.offer(101);
        ll.poll();
        System.out.println(ll.peek());

        it = ll.iterator(); // ✅ Reinitialization
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        // ✅ 🔟 CONVERSION OPERATIONS
        // Conversion	            Code
        // LinkedList → Array	    list.toArray()
        // LinkedList → ArrayList	new ArrayList<>(list)

        // BULK OPERATIONS (ON MULTIPLE ELEMENTS)
        // Method	Purpose
        // addAll(collection)	Add many
        // removeAll(collection)	Remove many
        // retainAll(collection)	Keep common
        // containsAll(collection)	Check multiple

    }      
} 

// ✅ Difference between Iterator and ListIterator

// | Feature                | Iterator         | ListIterator                          |
// | ---------------------- | ---------------- | ------------------------------------- |
// | Direction              | Only **forward** | **Forward + Backward**                |
// | Works with             | All Collections  | Only **List** (ArrayList, LinkedList) |
// | Modify while iterating | Remove only      | **Add, Remove, Set**                  |
// | Get index              | ❌ No            | ✅ Yes                               |
// | Start from middle      | ❌ No            | ✅ Yes                               |

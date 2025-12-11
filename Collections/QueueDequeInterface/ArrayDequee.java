package Collections.QueueDequeInterface;

import java.util.ArrayDeque;

public class ArrayDequee {
    // ArrayDeque is a double-ended queue (DeQueue) implementation backed by a resizable array.
    // ArrayDeque is the best and fastest implementation of Deque.

    // It can act as:
        // ✔ Queue (FIFO)
        // ✔ Stack (LIFO)
        // ✔ Deque (insert/remove from both ends)

    // 🔥 2️⃣ Internal Working

    // ArrayDeque uses:
    //     ✔ Resizable circular array internally
    //     ✔ Avoids shifting elements (like ArrayList)
    //     ✔ Extremely fast for queue + stack

    // 🔄 Circular Array Diagram
    // index: 0 1 2 3 4 5 6 7
    // array:  10 20 30    
    //         ^       ^
    //         front    rear
    // When rear reaches end, it wraps around → circular.

    public static void main(String[] args) {

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        // 🚀 Add Operations

        // 1. addFirst() → insert at front
        dq.addFirst(10);
        dq.addFirst(20);
        System.out.println(dq); // [20, 10]

        // 2. addLast() → insert at end
        dq.addLast(30); // [20, 10, 30]

        // 3. offerFirst() & offerLast() → same as add but safe -> offer() never throws exception.
        dq.offerFirst(40);
        System.out.println(dq); // [40, 20, 10, 30]

        // 🚀 Remove Operations
        System.out.println(dq.removeFirst()); // removes 40 ->Throws exception if empty.
        System.out.println(dq.removeLast()); // removes 30

        System.out.println(dq.pollFirst()); // return & remove firstElement, return NULL if empty
        System.out.println(dq.pollLast()); // return & remove last Element,

        // 🚀 C. Peek Operations
        dq.offerLast(50);
        dq.addLast(60);
        System.out.print(dq.peekFirst()+" "); // front element
        System.out.print(dq.peekLast()+" "); // last element
        System.out.println(dq);

        // Acts as STACK (better than Stack class) - Use push(), pop(), peek()
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(10); // addFirst()
        stack.push(5);
        stack.push(20);
        System.out.println("Stack Elements: "+stack);
        System.out.println(stack.pop()); // 20
        System.out.println(stack.peek()); //5

        // Acts as QUEUE (FIFO) - Use offer(), poll(), peek()

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(20); // insert at end of dequeue
        queue.offer(10);
        queue.offer(5);
        System.out.println(queue.poll()); //20- retrives & remove head of the queue
        System.out.println(queue.peek()); //10- retrives head element, not remove it

    } 
    
}

// ⭐ 6️⃣ When to Use ArrayDeque?

// ✔ Replace Stack
// ✔ Use as Queue
// ✔ Use for sliding window problems
// ✔ Use for BFS/DFS (stack+queue)
// ✔ Use for palindrome checking
// ✔ Use for max/min sliding window (interview question)

// | Feature                   | **ArrayDeque**                     | **LinkedList**                                   |
// | ------------------------- | ---------------------------------- | ------------------------------------------------ |
// | **Underlying Structure**  | Resizable Circular Array           | Doubly Linked List                               |
// | **Performance (Overall)** | **Faster**                         | Slower than ArrayDeque                           |
// | **Memory Usage**          | Less memory                        | More memory (each node has pointers)             |
// | **Null Elements**         | ❌ Not allowed                     | ✔️ Allowed                                      |
// | **Thread-Safe**           | No                                 | No                                               |
// | **Used As**               | Stack, Queue, Deque                | Stack, Queue, Deque, List                        |
// | **Iterator Type**         | Fail-fast                          | Fail-fast                                        |
// | **Random Access**         | No                                 | No                                               |
// | **Typical Use-Case**      | Performance-critical queues/stacks | When you need frequent node removals from middle |

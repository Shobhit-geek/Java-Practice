package Collections.LinkedList;

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
    
}

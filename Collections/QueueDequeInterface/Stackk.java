package Collections.QueueDequeInterface;

import java.util.Stack;

public class Stackk {

    // 🔥 2. STACK (Legacy LIFO Data Structure)

    // Stack extends Vector → this itself is a problem.
    // That’s why ArrayDeque is preferred in modern Java.

// ⭐ Stack Basic Operations ------  LIFO → Last In First Out
    // | Method   | Meaning               |
    // | -------- | --------------------- |
    // | push()   | Insert element        |
    // | pop()    | Remove and return top |
    // | peek()   | View top element      |
    // | empty()  | Is stack empty?       |
    // | search() | Position from top     |
  public static void main(String[] args) {
        Stack<String> st = new Stack<>();

        st.push("A");
        st.push("B");
        st.push("C");

        System.out.println("Top: " + st.peek());    // C
        System.out.println("Popped: " + st.pop());  // C
        System.out.println("Now top: " + st.peek()); // B

        System.out.println("Stack: " + st);
    }
}

// ❌ Why Stack is Deprecated (Sort of)

// Because stack is:
// SLOW (synchronized)
// Based on legacy Vector
// Not optimized
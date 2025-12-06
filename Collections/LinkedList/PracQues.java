package Collections.LinkedList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class PracQues {
    public static void main(String[] args) {

        // ============================
        // Q1 -> Reverse a LinkedList
        // ============================

        // Creating a LinkedList of Integer
        LinkedList<Integer> ll = new LinkedList<>();

        // Adding multiple elements at once using Arrays.asList()
        ll.addAll(Arrays.asList(11, 13, 15, 17));

        // Creating a ListIterator (used earlier in a wrong approach)
        ListIterator<Integer> it = ll.listIterator();

        // ❗ This only PRINTS the reversed view, it does NOT modify original LinkedList
        System.out.println(ll.reversed());

        // Storing the size of the LinkedList
        int size = ll.size();

        /*
         * ❌ This approach caused ConcurrentModificationException:
         * 
         * Reason:
         * You were modifying the LinkedList (addLast, removeFirst)
         * while using an Iterator.
         * 
         * ✅ VERY IMPORTANT RULE OF ITERATOR:
         * If you structurally modify a collection (add/remove) outside the Iterator,
         * the Iterator is immediately invalid → causes ConcurrentModificationException.
         * 
         * That is why this block is commented.
         */

        // int count = 0;
        // while (it.hasNext() && count < size) {
        // ++count;
        // ll.addLast(it.next()); // ❌ structural modification
        // ll.removeFirst(); // ❌ structural modification
        // }

        // ✅ CORRECT & SAFE WAY TO REVERSE THE LINKED LIST
        for (int i = 0; i < size; i++) {
            int value = ll.removeLast(); // Step 1: Remove element from the end
            ll.add(i, value); // Step 2: Insert it at the front progressively
        }

        // Printing the reversed LinkedList
        System.out.println("After Reverse: " + ll);

        // ===================================
        // Q2 -> Check Palindrome LinkedList
        // ===================================

        // Creating another LinkedList
        LinkedList<Integer> ll2 = new LinkedList<>();

        // Adding elements (this one is palindrome)
        ll2.addAll(Arrays.asList(11, 13, 15, 13, 11));

        // Iterator not required here but created earlier
        ListIterator<Integer> it2 = ll2.listIterator();

        // Storing the size
        int size2 = ll2.size();

        // Flag to track palindrome state
        boolean palindrome = true;

        System.out.println("Checking if ll2 is palindrome in nature? ");

        // Loop runs only till half of the list
        for (int i = 0; i < size2 / 2; i++) {

            /*
             * ❗ IMPORTANT FIX:
             * You were using:
             * ll2.get(i) != ll2.get(size2 - i - 1)
             * 
             * ❌ This compares REFERENCES for Integer objects
             * ✅ Correct way is to compare VALUES using .equals()
             */

            if (!ll2.get(i).equals(ll2.get(size2 - i - 1))) {
                System.out.println("Not Palindrome");
                palindrome = false;
                break; // Stop checking once mismatch is found
            }
        }

        // If no mismatch was found
        if (palindrome) {
            System.out.println("LL is palindrome");
        }

        // Q3-> Merging 2 linkedlist

        LinkedList<Integer> ll3 = new LinkedList<>(Arrays.asList(10, 20, 30));
        LinkedList<Integer> ll4 = new LinkedList<>(Arrays.asList(40, 50, 60));

        // ✅ Merge ll2 into ll1
        ll3.addAll(ll4);

        System.out.println("Merge 2 list: "+ll3);

    }
}

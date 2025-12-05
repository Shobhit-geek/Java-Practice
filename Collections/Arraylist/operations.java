package Collections.Arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// ArrayList is a resizable array implementation of the List interface that allows
//  duplicate elements and maintains insertion order.
// Internally,ArrayList uses: Object[] elementData;

public class operations {
    public static void main(String[] args) {

        // ✅ 1. CREATION OPERATIONS
        // ArrayList<Integer> list2 = new ArrayList<>(100);   // initial capacity
        // ArrayList<Integer> list3 = new ArrayList<>(list);  // copy another list

        // creation of arraylist
        ArrayList<Integer> alist = new ArrayList<>();
        
        // ✅ 2. ADDING ELEMENTS
        // Method	                        Purpose
        // add(E e)	                        Add at end
        // add(int index, E e)	            Add at specific index
        // addAll(Collection c)	            Add another collection
        // addAll(int index, Collection c)	Add at index

        // add - to add element to end in arraylist
        alist.add(10);
        alist.add(20);
        alist.add(30);
        alist.add(2, 40);

        // adding another arraylist to alist (some other ways of creating arraylist)
        List<Integer> list = Arrays.asList(1, 4, 2, 6);
        // ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30));

        alist.addAll(0, list);
        System.out.println("Printing the array elements: ");
        
        //Printing arraylist element
        for(int x: alist){
            System.out.print(x+" ");
        }
        System.out.println();

        // setting size of the arrayList
        alist.ensureCapacity(20);

        // ✅ 3. ACCESS / READ OPERATIONS
        System.out.println("size of arraylist: "+ alist.size());
        System.out.println("element at index at 1: "+alist.get(1));
        System.out.println("arraylist is Empty? "+alist.isEmpty());

        // ✅ 4. UPDATE / MODIFY OPERATIONS
        alist.set(1, 99);
        // Printing arraylist element
        for (int x : alist) {
            System.out.print(x + " ");
        }
        System.out.println();

        // ✅ 5. DELETE / REMOVE OPERATIONS
        // Method	                Purpose
        // remove(int index)	    Remove by index
        // remove(Object o)	    Remove by value
        // removeAll(Collection c)	Remove group
        // clear()	                Remove all

        alist.remove(7);
        alist.remove(Integer.valueOf(6)); //remove by value

        // Printing arraylist element
        for (int x : alist) {
            System.out.print(x + " ");
        }
        System.out.println();
        // ✅ 6. SEARCH OPERATIONS
        // | Method                  | Purpose       |
        // | ----------------------- | ------------- |
        // | `contains(Object o)`    | Exists or not |
        // | `indexOf(Object o)`     | First index   |
        // | `lastIndexOf(Object o)` | Last index    |

        System.out.println(alist.contains(20));
        System.out.println(alist.indexOf(2));

        // ✅ 8. SORTING OPERATIONS
        // | Method                               | Purpose   |
        // | ------------------------------------ | --------- |
        // | `Collections.sort(list)`             | Ascending |
        // | `Collections.sort(list, comparator)` | Custom    |
        // | `list.sort(comparator)`              | Java 8+   |

        Collections.sort(alist);
        //Printing arraylist element
        for(int x: alist){
            System.out.print(x+" ");
        }
        System.out.println();

        //reverse order sorting
        Collections.sort(alist.reversed());
        // Printing arraylist element
        for (int x : alist) {
            System.out.print(x + " ");
        }
        System.out.println();

        // ✅ 9. CONVERSION OPERATIONS
        // | Method           | Purpose                |
        // | ---------------- | ---------------------- |
        // | `toArray()`      | Convert to Object[]    |
        // | `toArray(T[] a)` | Convert to typed array |

        // ✅ Convert an ArrayList<Integer> into an Integer[] array
        // 'list' is an ArrayList that contains Integer objects
        // Example: list = [10, 20, 30]

        // toArray(new Integer[0]) means:
        // ➤ We are telling Java: "Convert this ArrayList into an Integer type array"
        // ➤ The [0] size is NOT used for storage
        // ➤ It is only used to tell Java the TYPE of array we want (Integer[])

        // Internally, Java will automatically create:
        // new Integer[list.size()]
        // and copy all elements into it

        Integer arr[] = list.toArray(new Integer[0]);

        // Now 'arr' becomes a normal array like this:
        // arr = [10, 20, 30]
        // Printing array element
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
        // using iteator to iterate over list
        // An Iterator is an object that can be used to loop through collections, likeArrayList and HashSet.
        Iterator<Integer> it = alist.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }
}

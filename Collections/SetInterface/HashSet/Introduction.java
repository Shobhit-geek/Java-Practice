package Collections.SetInterface.HashSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Introduction{
    public static void main(String[] args) {
        // 🔥 STEP 1: HashSet (Most Used Set Implementation)
        // 🔹 Basic Rules of HashSet:

        // | Rule              | True/False   |
        // | ----------------- | ------------ |
        // | Allows duplicates | ❌            |
        // | Maintains order   | ❌            |
        // | Allows null       | ✅ (only one) |
        // | Uses index        | ❌            |
        // | Fast search       | ✅            |

        HashSet<Integer> set = new HashSet<>();
        // adding element to set
        set.add(10);
        set.add(20);
        set.add(10); // ❌ Duplicate, will be ignored
        set.add(30);
        Iterator<Integer> it = set.iterator();
        System.out.println("Printing Set Element");
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }

        //✅ Output (Order NOT guaranteed):
        // [20, 10, 30]

        // ❓ Why doesn’t HashSet allow duplicates?
        // ✅ Because it internally uses hashing + equals().

        // 🔥 HOW HashSet REALLY WORKS INTERNALLY -> (hashCode() + equals())

        // ❗ HashSet does NOT check duplicates using ==.
        // It uses hashCode() first, then equals().

        // ✅ STEP 1: How HashSet Decides Where to Store Data

        // Whenever you do: set.add(10);

        // Java does internally:

        // 1️⃣ Calls hashCode() on 10
        // 2️⃣ Finds a bucket using that hash
        // 3️⃣ Places 10 inside that bucket

        // ✅ STEP 2: What Happens When You Add a Duplicate?
        // set.add(10);  // again

        // Java does:

        // 1️⃣ hashCode() of new 10
        // 2️⃣ Goes to same bucket
        // 3️⃣ Now calls equals() with existing element
        // 4️⃣ If equals() returns TRUE → duplicate ❌ ignored

        // ✅ This is why both methods matter.

        // ✅ 2️⃣ ADD OPERATIONS

        // | Method                 | What it Does           |
        // | ---------------------- | ---------------------- |
        // | `add(E e)`             | Adds element           |
        // | `addAll(Collection c)` | Adds multiple elements |

        List<Integer> list = Arrays.asList(10,40,50,60);
        set.addAll(list);
        System.out.println();
        Iterator<Integer> it2 = set.iterator();
        while (it2.hasNext()) {
            System.out.print(it2.next() + " ");
        }

        // ✅ 3️⃣ REMOVE OPERATIONS
        // | Method                    | Purpose            |
        // | ------------------------- | ------------------ |
        // | `remove(Object o)`        | Removes element    |
        // | `removeAll(Collection c)` | Removes multiple   |
        // | `clear()`                 | Removes everything |

        set.remove(20);
        for(int x: set){
            System.out.print(x+" ");
        }
        System.out.println();

        // ✅ 6️⃣ CONVERSION OPERATIONS
        // ✅ Set → List
        List<Integer> newList = new ArrayList<>(set);
        System.out.println(newList);

        // ✅ Set → Array
        Integer arr[] = set.toArray(new Integer[0]);
        for(int x: arr){
            System.out.print(x+" ");
        }

        System.out.println();
        
        // ✅ 7️⃣ SET OPERATIONS (MATH BASED – VERY IMPORTANT)
        // ✅ UNION

        HashSet<Integer> a = new HashSet<>(Arrays.asList(10, 20, 30));
        HashSet<Integer> b = new HashSet<>(Arrays.asList(30, 40, 50));

        // ✅ UNION (without modifying original a)
        Set<Integer> union = new HashSet<>(a);
        union.addAll(b);
        System.out.println("Union: " + union);

        // ✅ INTERSECTION (without modifying a)
        Set<Integer> intersection = new HashSet<>(a);
        intersection.retainAll(b);
        System.out.println("Intersection: " + intersection);

        // ✅ DIFFERENCE (A - B)
        Set<Integer> difference = new HashSet<>(a);
        difference.removeAll(b); // ✅ CORRECT METHOD
        System.out.println("Difference (A - B): " + difference);

    }
}
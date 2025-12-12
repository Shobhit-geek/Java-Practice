package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsUtilityClass {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(5);
        list.add(15);
        list.add(8);
        list.add(5);
        // ✅ 1. sort()
        // Sorting List in natural order:
        Collections.sort(list);
        System.out.println(list);

        // For custom sorting - sort in reverse order
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

        // ✅ 3. shuffle() - Randomizes elements:
        Collections.shuffle(list);
        System.out.println(list);

        // ✅ 4. max and min
        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));

        // ✅ 5. frequency() - Useful for counting occurrences.
        int f = Collections.frequency(list, 5);
        System.out.println(f);

        // ✅ 6. swap() - Swap two elements by index:
        Collections.swap(list, 0, 2);
        System.out.println(list);

        // ✅ 7. fill() - Replaces all elements with same value:
        // Collections.fill(list, 100);

        // ✅ 8. copy() - Copies from source → destination

        List<Integer> dest = new ArrayList<>(Arrays.asList(0,0,0,0));
        List<Integer> src = Arrays.asList(1,2,3,4);
        Collections.copy(dest, src);
        System.out.println(dest); // [1,2,3,4]

        // ✅ 9. rotate() - Rotate right by k steps:
        Collections.rotate(list, 2);
        System.out.println(list);

        // ✅ 10. binarySearch() - List must be sorted.
        Collections.sort(list);
        int index = Collections.binarySearch(list, 15);
        System.out.println(index);

        // ✅ 11. unmodifiableList() - Creates an immutable list:

        // List<Integer> unmod = Collections.unmodifiableList(list);
        // unmod.add(10); // ❌ runtime 
        
        //✅ 12. synchronizedList() - Convert normal list → thread-safe list.
        // List<Integer> syncList = Collections.synchronizedList(new ArrayList<>());

        // This is very important for concurrency.  
    }
}

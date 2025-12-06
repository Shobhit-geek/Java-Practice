package Collections.SetInterface.HashSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PracQues {
    public static void main(String[] args) {
        // 🟢 BASIC LEVEL

        // 1️⃣ Remove Duplicates from a List
        HashSet<Integer> set1 = new HashSet<>();
        List<Integer> list = Arrays.asList(10, 20, 10, 30, 20, 40);
        System.out.print("Printing Unique Elements: ");
        set1.addAll(list);
        for(int i: set1){
            System.out.print(i+" ");
        }
        System.out.println();

        // 2️⃣ Find Unique Characters in a String
        HashSet<Character> set2 = new HashSet<>();
        String str = "programming";
        for(int i=0; i<str.length();i++){
            set2.add(str.charAt(i));
        }
        System.out.print("Printing unique characters: ");
        for(char i : set2) {
            System.out.print(i + " ");
        }
        System.out.println();

        //3️⃣ Check if Two Sets are Equal
        HashSet<Integer> set3 = new HashSet<>(Arrays.asList(10, 20, 30));
        HashSet<Integer> set4 = new HashSet<>(Arrays.asList(30, 20, 10));
        
        System.out.print("Checking if 2 sets are equal or not: "+ set3.equals(set4));
        System.out.println();

        // 🟡 MEDIUM LEVEL

        // 4️⃣ Find Union of Two Sets
        // 5️⃣ Find Intersection of Two Sets
        // 6️⃣ Find Difference of Two Sets (A - B)

        // 🔴 INTERVIEW LEVEL

        //7️⃣ Find First Repeating Element in an Array
        // [10, 20, 30, 20, 40, 10]  -----> Output: 20

        HashSet<Integer> set5 = new HashSet<>();
        List<Integer> list5 = Arrays.asList(10, 20, 30, 20, 40, 10);
        Boolean flag = false;
        for(int i: list5){
            if(set5.contains(i)){
                System.out.println("First Repeating element: "+ i);
                flag = true;
                break;
            }
            set5.add(i);
        }
        if(!flag){
            System.out.println("all elements are unique");
        }

        // 8️⃣ Find All Duplicate Elements 
        // (Solve it like above question, have 1 array to store all the duplicate elements)
        // [10, 20, 30, 20, 40, 10] ----> Output: [10, 20]

        // 9️⃣ Check if a String has All Unique Characters
        // "abcd" → true
        // "aabc" → false
        HashSet<Character> set6 = new HashSet<>();
        String s1 = "abcda";
        Boolean flag2 = false;
        for(int i=0; i<s1.length();i++){
            char ch = s1.charAt(i);
            if(set6.contains(ch)){
                System.out.println("All characters are not unique");
                flag2 = true;
                break;
            }
            set6.add(ch);
        }
        if(!flag2){
            System.out.println("All  characters are unique!!");
        }
        

        // 🔟 Remove Duplicate Words from a Sentence
        // "I love java and I love coding"
        // Output: I love java and coding
        String sentence = "I love java and I love coding";

        // 1️⃣ Split sentence into words
        String[] words = sentence.split(" ");

        // 2️⃣ Use LinkedHashSet to remove duplicates + maintain order
        Set<String> set = new LinkedHashSet<>();
        for (String word : words) {
            set.add(word);   // duplicates automatically ignored
        }

        // 3️⃣ Build final sentence
        StringBuilder result = new StringBuilder();
        for (String word : set) {
            result.append(word).append(" ");
        }

        // 4️⃣ Print final result
        System.out.println(result.toString().trim());
    }
    
}

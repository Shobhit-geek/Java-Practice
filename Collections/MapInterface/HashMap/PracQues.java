package Collections.MapInterface.HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PracQues {
    public static void main(String[] args) {
        
        //Q1- Store the frequency of characters in this string using HashMap:
        // Input: "programming"

        // String input = "programming";
        // // ✅ 1. Create a HashMap to store character and its frequency
        // HashMap<Character, Integer> map = new HashMap<>();

        // // ✅ 2. Convert string to character array && LOOP
        // for(char ch: input.toCharArray()){

        //     // ✅ If character already exists, increase count
        //     if(map.containsKey(ch)){
        //         map.put(ch, map.get(ch)+1);
        //     }
        //     // ✅ If character appears first time
        //     else{
        //         map.put(ch, 1);
        //     }
        // }
        // // for(Map.Entry<Character, Integer> mp: map.entrySet()){
        // //     System.out.println("key: "+mp.getKey()+", value: "+mp.getValue());
        // // }
        
        // // 2nd way to iterate
        // Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();
        // while(it.hasNext()){
        //     Map.Entry<Character, Integer> mp = it.next();
        //     System.out.print(mp.getKey() + " = " + mp.getValue()+", ");
        // }



        // 🔹 Q2. Word Frequency
        // Input: "I love java and I love coding"

        // HashMap<String, Integer> map = new HashMap<>();
        // String sentence = "I love java and I love coding";
        // // Temporary variable to build each word character by character
        // String word = new String();

        // // Convert sentence into character array and iterate over each character
        // for (char ch : sentence.toCharArray()) {

        //     // If character is NOT a space, keep adding it to the current word
        //     if (ch != ' ') {
        //         word += ch; // building the current word
        //     } else {
        //         // When space is found → one full word is completed

        //         System.out.println(word); // printing each detected word

        //         // Add the word into map with frequency update
        //         // If word already exists → increase count
        //         // If word does not exist → add with count 1
        //         map.put(word, map.get(word) != null ? map.get(word) + 1 : 1);

        //         // Reset word to start building next word
        //         word = new String();
        //     }
        // }

        // // ✅ This is required to handle the LAST WORD ("coding")
        // // because loop only stores words when it finds a SPACE
        // map.put(word, map.get(word) != null ? map.get(word) + 1 : 1);

        // // Reset word again (not mandatory here but safe practice)
        // word = new String();

        // // ✅ Printing the final word frequency map using entrySet()
        // for (Map.Entry<String, Integer> mp : map.entrySet()) {
        //     System.out.print(mp.getKey() + "=" + mp.getValue() + ", ");
        // }
        
        //🔹 Q4. First Non-Repeating Character

        // Input:"aabbccd"
        // Output: d

        // HashMap<Character, Integer> map = new HashMap<>();
        // String input = "aabbccd";

        // for(char ch: input.toCharArray()){
        //     if(map.containsKey(ch)){
        //         map.put(ch, map.get(ch)+1);
        //     }
        //     else{
        //         map.put(ch, 1);
        //     }
        // }

        // Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();
        // while (it.hasNext()) {
        //     Map.Entry<Character, Integer> mp = it.next();
        //     if(mp.getValue() == 1){
        //         System.out.println("First non-repeating character: "+mp.getKey());
        //     }
        // }


    // 🔹 Two Sum – Problem Statement

    // You are given an array of integers nums and an integer target.
    // Your task is to find the indices of the two numbers in the array such that their sum is equal to the target value.

    // ✅ Conditions:
    // Each input has exactly one solution.
    // You may not use the same element twice.
    // You must return the indices, not the values.
    // You can return the answer in any order.

    // ✅ Example:
    // Input:
    // nums = [2, 7, 11, 15]
    // target = 9

    // Output:
    // [0, 1]

    // Explanation:
    // nums[0] + nums[1] = 2 + 7 = 9
    // TC-> O(n)
    // List<Integer> list = Arrays.asList(2, 7, 11, 15);
    // int target = 9;
    // HashMap<Integer, Integer> map = new HashMap<>();

    // for (int num : list) {
    //     // if result of target - num present in map, then the Pair is found
    //     int req = target - num;

    //     if (map.containsKey(req)) {
    //         System.out.println("Two elements: " + req + ", " + num);
    //         break;
    //     }
    //     map.put(num, 1); // store after checking
    // }

    // 🔹 Q7. Group Anagrams

    // Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
    // Output: [[eat, tea, ate], [tan, nat], [bat]]

    List<String> words = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");

    Map<String, List<String>> map = new HashMap<>();

    for (String word : words) {

        // 1️⃣ Convert word to char array, sort it → acts as a key
        char[] arr = word.toCharArray();
        Arrays.sort(arr);
        String key = new String(arr); // sorted form

        // 2️⃣ Insert into HashMap
        // If key not exists, create new list
        map.putIfAbsent(key, new ArrayList<>());

        // Add original word to its group
        map.get(key).add(word);
    }

    // 3️⃣ Print result (collection of grouped anagrams)
    System.out.println(map.values());

    }
}

// Explanation for Iterator for map

// 🔹 1️⃣ Why Map.Entry<String, Integer>?

// A Map stores data as key–value pairs, not as single values like a List.
// Each pair is represented by: Map.Entry<K, V>
// So for your map: Map<String, Integer> map;

// Each element inside the map is:
// Map.Entry<String, Integer> Which contains:

// getKey() → returns String
// getValue() → returns Integer

// So: Map.Entry<String, Integer> = ONE (key, value) pair

// 🔹 2️⃣ Why map.entrySet() ?

// map.entrySet() returns:
// Set<Map.Entry<String, Integer>>

// Meaning:
// A Set of key–value pairs
// So now your Map becomes a collection view that can be iterated like a List or Set.

// 🔹 3️⃣ Why .iterator() ?

// Collections like Set, List, etc. provide:
// iterator()
// So: Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
// means:
// "Give me an iterator that can move through each (key, value) pair of the map"

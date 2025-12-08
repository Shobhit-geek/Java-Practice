package Collections.MapInterface.HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PracQues {
    public static void main(String[] args) {
        
        // Store the frequency of characters in this string using HashMap:
        // Input: "programming"
        String input = "programming";
        // ✅ 1. Create a HashMap to store character and its frequency
        HashMap<Character, Integer> map = new HashMap<>();

        // ✅ 2. Convert string to character array && LOOP
        for(char ch: input.toCharArray()){

            // ✅ If character already exists, increase count
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }
            // ✅ If character appears first time
            else{
                map.put(ch, 1);
            }
        }
        for(Map.Entry<Character, Integer> it : map.entrySet()){
            System.out.print(it.getKey()+"->"+it.getValue()+" , ");
        }
        
    }
}


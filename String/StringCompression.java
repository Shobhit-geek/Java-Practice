package String;

/*
    * ------------------------- PROBLEM STATEMENT -------------------------
    * 
    * STRING COMPRESSION (Standard Interview Problem)
    * 
    * Given a string, compress it by counting consecutive repeating characters.
    * 
    * Example:
    * Input:  "aaabbccccdaa"
    * Output: "a3b2c4d1a2"
    * 
    * RULES:
    * 1. For each character, append the character + count of consecutive occurrences.
    * 2. If a character appears only once, still add 1.
    * 3. You must use character-by-character traversal.
    * 
    * Explanation:
    * aaabbccccdaa
    * a appears 3 times → a3
    * b appears 2 times → b2
    * c appears 4 times → c4
    * d appears 1 time  → d1
    * a appears 2 times → a2
    * 
    * Common Interview Question:
    * - Amazon, Google, Microsoft, Meta, Walmart
    * - Often asked with StringBuilder usage
    * ---------------------------------------------------------------------
    */
public class StringCompression {
    public static void strCompression(String str){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            // Check if next char is same
            if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {

                // ALWAYS append character
                sb.append(str.charAt(i));
                // append count only if more than 1
                if (count > 1) {
                    sb.append(count);
                }
                // reset count
                count = 1;
            }
        }
        if(sb.length() > str.length()){
            System.out.println("There is no need for compression");
        }
        System.out.println("The Compressed String is:"+sb);
    }
    
    public static void main(String[] args) {
        String s = "aaabbbcccd";
        strCompression(s);
    }
}

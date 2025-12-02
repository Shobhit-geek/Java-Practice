package String;

public class FirstLetterCaps {
    // Method to convert first letter of every word to Capital
    public static void CapsFL(String str) {

        // Step 1: Use StringBuilder for mutable string operations (faster than String)
        StringBuilder sb = new StringBuilder();

        // Step 2: Convert the very first character of the string to uppercase
        sb.append(Character.toUpperCase(str.charAt(0)));

        // Step 3: Loop through the string from index 1 to end
        for (int i = 1; i < str.length(); i++) {

            // If current character is NOT space, just append it
            if (str.charAt(i) != ' ') {
                sb.append(str.charAt(i));
            } else {
                // Step 4: If space found, append the space
                sb.append(' ');

                // Step 5: Convert next character to uppercase and append
                sb.append(Character.toUpperCase(str.charAt(i + 1)));

                // Step 6: Skip the next character because it is already processed
                i++;
            }
        }

        // Step 7: Print the final transformed string
        System.out.println("Final String is: " + sb.toString());
    }
    
    public static void main(String[] args) {
        String str = "hello, i am shobhit";
        CapsFL(str);
    }
}

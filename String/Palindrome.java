package String;

public class Palindrome {

    // A palindrome is a string that reads the same backward as forward.
    // Examples: "madam", "racecar", "level".
    // This method checks if a given string is a palindrome.

    public static boolean checkPalindrome(String s) {
        int n = s.length(); // Get the length of the string

        // Loop to compare characters from the start and end
        for (int i = 0; i < s.length() / 2; i++) {
            // Compare the i-th character from the start with the i-th character from the end
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false; // If any mismatch is found, the string is not a palindrome
            }
        }
        return true; // If no mismatches are found, the string is a palindrome
    }

    public static void main(String[] args) {
        // Example 1: Non-palindrome string
        String str = "Shobhit";
        boolean res = checkPalindrome(str);
        System.out.println("Is '" + str + "' a palindrome? " + res);

        // Example 2: Palindrome string
        String str2 = "madam";
        boolean res2 = checkPalindrome(str2);
        System.out.println("Is '" + str2 + "' a palindrome? " + res2);

        // Example 3: Palindrome string with even length
        String str3 = "abba";
        boolean res3 = checkPalindrome(str3);
        System.out.println("Is '" + str3 + "' a palindrome? " + res3);
    }
}

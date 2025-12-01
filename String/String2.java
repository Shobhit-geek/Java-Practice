package String;

public class String2 {
  public static void main(String[] args) {
    // Example of .equals() for comparing strings
    String str1 = "Shobhit";
    String str2 = "Shobhit";
    String str3 = new String("Shobhit");

    // Using .equals() to compare content
    System.out.println("Using .equals():");
    System.out.println("str1.equals(str2): " + str1.equals(str2)); // true
    System.out.println("str1.equals(str3): " + str1.equals(str3)); // true

    // Using == to compare references
    System.out.println("\nUsing ==:");
    System.out.println("str1 == str2: " + (str1 == str2)); // true (both refer to the same object in the string pool)
    System.out.println("str1 == str3: " + (str1 == str3)); // false (str3 refers to a different object)

    // Explanation:
    /*
    - .equals() compares the actual content of the strings.
    - == compares the memory references of the objects.
    - For strings, .equals() should be used to ensure content comparison.
    - Using == can lead to unexpected results when strings are created using the 'new' keyword,
      as it creates a new object in memory instead of using the string pool.
    */

    // substring(int beginIndex, int endIndex) 
    // Returns substring from beginIndex up to (but not including) endIndex.
    String str="Shobhit";
    System.out.println(str.substring(0,6));
    System.out.println(str.substring(1));  
  }
}

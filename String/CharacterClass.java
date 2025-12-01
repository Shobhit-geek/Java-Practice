package String;


// Java provides a wrapper class Character in java.lang package. 
// An object of type Character contains a single field, whose type is char. 
// The Character class offers a number of useful class (i.e., static) methods for manipulating characters
public class CharacterClass {
    public static void main(String[] args) {
        // If we pass a primitive char into a method that expects an object, the compiler 
        // automatically converts the char to a Character class object.
        // This feature is called Autoboxing and Unboxing.

        Character ch = Character.valueOf('q');
        System.out.println(ch);
        String str = "Shobhit";
        // System.out.println(str[i]); -- not work in java so use charAt()
        for(int i=0;i<str.length();i++){
            Character c = Character.valueOf(str.charAt(i));
            System.out.print(c+" ");
        }

        System.out.println("\n\n=== Important Character Class Methods ===");

        char a = 'A';
        char b = 'a';
        char digit = '5';
        char special = '@';

        // 1. Check case
        System.out.println("isUpperCase(A): " + Character.isUpperCase(a));
        System.out.println("isLowerCase(a): " + Character.isLowerCase(b));

        // 2. Change case
        System.out.println("toUpperCase(a): " + Character.toUpperCase(b));
        System.out.println("toLowerCase(A): " + Character.toLowerCase(a));

        // 3. Check digit
        System.out.println("isDigit(5): " + Character.isDigit(digit));

        // 4. Check alphabet
        System.out.println("isLetter(a): " + Character.isLetter(b));
        System.out.println("isLetterOrDigit(@): " + Character.isLetterOrDigit(special));

        // 5. Check whitespace
        System.out.println("isWhitespace(' '): " + Character.isWhitespace(' '));

        // 6. General category
        System.out.println("getType('A'): " + Character.getType(a)); // RETURNS INTEGER CATEGORY

        // 7. Check if char is defined in Unicode
        System.out.println("isDefined('A'): " + Character.isDefined(a));

        // 8. Check if it's a special control char
        System.out.println("isISOControl('\\n'): " + Character.isISOControl('\n'));

        // 9. Check if it's a Java identifier (variable name)
        System.out.println("isJavaIdentifierStart('A'): " + Character.isJavaIdentifierStart('A'));
        System.out.println("isJavaIdentifierPart('5'): " + Character.isJavaIdentifierPart('5'));

        // 10. Convert digit to numeric value
        System.out.println("getNumericValue('5'): " + Character.getNumericValue('5'));
    }
}
package String;


public class QNAString {

    // ✅ 1. Why are Strings immutable in Java?
    // Strings are immutable because the String class is marked final and its internal character array cannot be changed after creation.

    // ✔ Technical Reasons for Immutability

    // 1. String Pooling
    // Strings can be reused from the pool only because they never change.
    // If they were mutable, one variable could accidentally modify another.

    // 2. Security
    // Strings are used in:
    // - Database URLs, File paths, Class names, Network connections, Usernames/passwords
    // If someone could change them, it would be a security risk.

    // 3. HashCode Caching
    // Strings are used as keys in HashMaps. Immutability ensures:
    // - hashCode does not change
    // - consistent lookup

    // 4. Thread Safety
    // Immutability automatically makes Strings thread-safe.
    // - No need for synchronization
    // - Multiple threads can safely share the same string

    // 5. Performance Optimizations
    // JVM can share the same literal across multiple places, reducing memory usage.

    // 🛡️ 2. How does immutability help in security?

    // ✔ Reason 1: Strings store sensitive data
    // Many sensitive values are Strings:
    // - Database passwords, File system paths
    // - Class names in ClassLoader, Environment variables
    // If a string were mutable, malicious code could modify them at runtime.

    // ✔ Reason 2: ClassLoader uses Strings
    // Class loading depends heavily on String values.
    // If an attacker could change:
    // java.lang.String to something else dynamically, the entire JVM could be compromised.

    // ✔ Reason 3: Prevents changes in security-sensitive operations
    // Strings are used in:
    // - Network hostnames, Socket connections, Permissions checking
    // Immutable Strings prevent tampering after creation.

    // 🧵 3. What is the String Pool?
    // String Pool (a.k.a. String Intern Pool) is a special memory area inside the heap, where Java stores string literals.

    // ✔ Example:
    // String s1 = "hello";
    // String s2 = "hello";
    // Both variables refer to the same object in the pool, not two objects.

    // ✔ Why does Java do this?
    // To save memory.
    // Many programs contain repeated strings like:
    // - "OK"
    // - "abc"
    // Instead of creating thousands of identical "abc" objects, Java creates one in the pool and reuses it.

    // ✔ How objects are created with/without the pool

    // 1️⃣ Literal → Goes into pool
    // String s1 = "Java";
    // Only one object created/stored in pool.

    // 2️⃣ Using new → Creates object in heap
    // String s2 = new String("Java");
    // Creates one object in heap
    // "Java" literal still stored in pool separately.

    // 3️⃣ intern() method
    // String s3 = new String("Java").intern();
    // intern() asks JVM:
    // "Is there a literal Java in the pool? If yes, give me the pooled reference."
    // So s3 will point to the same pooled object.

    // 🎯 Summary (Perfect for interview)

    // ✔ Why Strings are immutable
    // - String pool concept
    // - Thread safety
    // - Security
    // - HashMap key reliability
    // - Performance optimization

    // ✔ How immutability ensures security
    // - Prevent tampering of passwords, DB URLs, file paths
    // - ClassLoader safe usage
    // - Prevents modifying sensitive values at runtime

    // ✔ What is String pool
    // - Memory area in heap for string literals
    // - Prevents duplicate strings
    // - Enabled by immutability

    
    //--------------------------------------
    // ✅ 1. Core Concept Questions
    // ✔ What is a String in Java?
    // ✔ Why are Strings immutable?
    // ✔ How does String immutability help in security?
    // ✔ What is the String Pool?
    // ✔ Difference between == and .equals() for Strings?
    // ✔ What is the difference between:
    //    - "abc"
    //    - new String("abc")
    // ✔ Where are String literals stored?
    // ✔ What is interning (intern() method)?
    // ✔ How is String memory handled in heap vs pool?

    // 🟦 2. String Methods (Must Know)
    // Expect questions like:
    // ✔ What does substring() do?
    // ✔ Is substring() efficient? (old vs new Java behavior)
    // ✔ Difference between:
    //    - length()
    //    - size() (doesn't exist)
    // ✔ What does charAt() return?
    // ✔ What does indexOf() return?
    // ✔ What does split() return?
    // ✔ Explain trim(), strip(), replace(), replaceAll(), toLowerCase()

    // 🟩 3. Coding Questions (Very Common)
    // You will be asked these:
    // ✔ Reverse a string
    // ✔ Check if string is palindrome
    // ✔ Find duplicate characters in a string
    // ✔ Count vowels and consonants
    // ✔ Find frequency of characters
    // ✔ Check if two strings are anagrams
    // ✔ Remove whitespaces
    // ✔ Remove duplicates
    // ✔ Find largest/smallest word in a sentence
    // ✔ Count words in a sentence
    // ✔ Print each character with its count
    // ✔ Convert string to int without using Integer.parseInt()
    // ✔ Check if substring exists
    // ✔ Implement your own indexOf()

    // 🟥 4. StringBuilder & StringBuffer
    // From this topic:
    // ✔ Difference between StringBuilder and StringBuffer?
    // ✔ Why StringBuilder is faster?
    // ✔ What is capacity vs length?
    // ✔ Does StringBuilder create new objects during append?
    // ✔ Is StringBuilder thread-safe?

    //--------------------------------------
    // Difference between StringBuilder and StringBuffer
    // 1. Thread Safety:
    //    - StringBuilder is not thread-safe.
    //    - StringBuffer is thread-safe as all its methods are synchronized.
    // 2. Performance:
    //    - StringBuilder is faster because it does not have the overhead of synchronization.
    //    - StringBuffer is slower due to synchronization overhead.
    // 3. Use Case:
    //    - Use StringBuilder when thread safety is not a concern.
    //    - Use StringBuffer when multiple threads might access the same instance.
    // 4. Introduced:
    //    - StringBuilder was introduced in Java 5.
    //    - StringBuffer has been available since Java 1.0.

    // 🟨 5. Memory Model & Performance
    // Interviewers love these:
    // ✔ How many objects are created in:
    //    String s = new String("Hello");
    // ✔ What happens internally when you do:
    //    s = s + "abc";
    // ✔ Why is + (string concatenation) slow in loops?
    // ✔ How to make string concatenation faster?

    // 🟧 6. Tricky Questions
    // ✔ Is String mutable or immutable? (Why?)
    // ✔ Can you modify a String using reflection?
    // ✔ Is "A" == "A" true? Why?
    // ✔ What is the output?
    //    String s1 = "abc";
    //    String s2 = "abc";
    //    System.out.println(s1 == s2);
    // ✔ Output?
    //    String s1 = new String("abc");
    //    String s2 = "abc";
    //    System.out.println(s1 == s2);
    // ✔ Output?
    //    String s = "hello";
    //    s.concat("world");
    //    System.out.println(s);

    // 🟪 7. Practical Questions
    // ✔ Why Strings are final?
    // ✔ What is Unicode in Java strings?
    // ✔ How strings support internationalization?
    // ✔ Difference between String, StringBuilder, StringBuffer—when to use which?

    // 🟫 8. Advanced / Optional
    // Some companies ask:
    // ✔ Difference between UTF-8 and UTF-16 in Java strings?
    // ✔ Why does Java store characters as 2 bytes?
    // ✔ What are code points? surrogate pairs?
    // ✔ Implement your own StringBuilder class
}

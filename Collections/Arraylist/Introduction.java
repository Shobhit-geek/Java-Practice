package Collections.Arraylist;

import java.util.ArrayList;

// 🔹1. What is a Collection in Java?

// A Collection is a framework used to store,manipulate,and process groups of objects dynamically.

// ❌Problems with Arrays 
// Limitation              Example 
// Fixed size              int arr[]=new int[5];→size cannot change 
// No built-in methods     No sort,search,reverse directly 
// Only same data type     Cannot mix different object types easily

// ✅ Advantages of Collections
// ✔ Dynamic size
// ✔ Built-in methods
// ✔ Ready-made data structures
// ✔ Generics (type safety)
// ✔ Sorting, Searching, Filtering supported

// public class ArrayExample {
//     public static void main(String[] args) {
//         int arr[] = new int[3];
//         arr[0] = 10;
//         arr[1] = 20;
//         arr[2] = 30;

//         // arr[3] = 40; ❌ Runtime Error

//         for (int i = 0; i < arr.length; i++) {
//             System.out.println(arr[i]);
//         }
//     }
// }

// ---------------------- GENERICS In JAVA -------------------
// A generic class is a class that can operate on objects of different types using a type parameter. 
// Like C++, we use <> to specify parameter types in generic class creation. To create objects of a 
// generic class, we use the following syntax:

// To create an instance of generic class 
// BaseType <Type> obj = new BaseType <Type>()

// Note: In Parameter type, we can not use primitives like "int", "char" or "double". 
// Use wrapper classes like Integer, Character, etc.

public class Introduction {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        //✅ Dynamic size
        // ✅ add(), remove(), contains(), sort()
        // ❌ Slightly slower than arrays
    }
}
//----------------------------------------------------------------------
// ✅ What Is Dynamic Size?

// Dynamic size means the size can grow or shrink at runtime automatically.

// ❌ Array (Fixed Size)
// int arr[] = new int[3]; -> You can store ONLY 3 elements — never more.

// If you try: arr[3] = 40;  // ❌ Runtime Error (ArrayIndexOutOfBounds)


// So: ✅ Array size = fixed at creation time

// ✅ Collection (Dynamic Size)
// ArrayList<Integer> list = new ArrayList<>();
// list.add(10);
// list.add(20);
// list.add(30);
// list.add(40);  // ✅ Size grows automatically


// So: ✅ Collection size = changes automatically at runtime
// You don’t define the size in advance.

// ✅ HOW Does the Size Actually Increase Internally?

// Let’s take ArrayList as example (most important one).

// Internally, an ArrayList uses an array like this:  Object[] elementData;
// But this internal array is resized automatically.

// ✅ Step-by-Step Example of Growth

// 1️⃣ You create an empty ArrayList
// ArrayList<Integer> list = new ArrayList<>();

// Internally:
// Capacity = 10 (default)
// Size = 0

// 2️⃣ You start adding elements
// list.add(10);  // size = 1
// list.add(20);  // size = 2
// ...
// list.add(10th element);  // size = 10 (capacity full)

// Now:
// Size = 10
// Capacity = 10 (backup memory full)

// 3️⃣ You add the 11th element
// list.add(110);  // BOOM — capacity exceeded!

// Now Java internally does 3 steps automatically:
// ✅ Step A: Create a Bigger Array

// New capacity formula:
// newCapacity = oldCapacity * 1.5
//              = 10 * 1.5 = 15

// ✅ Step B: Copy Old Data
// All 10 elements are copied to the new array.

// ✅ Step C: Add New Element
// Now 11th element is added safely.

// So:
// Old Capacity = 10
// New Capacity = 15
// Size = 11
//-------------------------------------------------------------------------

// ✅ This is how dynamic resizing works internally.

// | Feature            | Array        | ArrayList         |
// | ------------------ | ------------ | ----------------- |
// | Size               | Fixed        | Dynamic           |
// | Increase Size      | ❌ Impossible | ✅ Automatic    |
// | Internal Structure | Direct Array | Resizable Array   |
// | Resize Cost        | Not Possible | O(n) when happens |

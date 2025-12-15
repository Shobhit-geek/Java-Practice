package StreamsPrac;

public class Theory {
    public static void main(String[] args) {

        // ✔ What is a Stream?
        // A stream is a pipeline of operations performed on a collection WITHOUT modifying the original data.

        // ✔ Types of operations

        // Intermediate operations → return another Stream
            // (map, filter, sorted, distinct, limit, skip)

        // Terminal operations → end the stream
            // (collect, forEach, reduce, count, min, max, toList)

        // 2️⃣ Creating Streams
        // From collection:
            // List<Integer> list = List.of(1,2,3);
            // list.stream();

        // From arrays:
            // Arrays.stream(arr);

        // From direct values:
            // Stream.of(1,2,3);

        // 3️⃣ Most Important Intermediate Operations
        // filter()
            // list.stream()
            //     .filter(x -> x % 2 == 0)
            //     .forEach(System.out::println);

        // map()
            // list.stream()
            //     .map(x -> x * x)
            //     .forEach(System.out::println);

        // sorted()
            // list.stream()
            //     .sorted()
            //     .forEach(System.out::println);

        // distinct()
            // list.stream()
            //     .distinct()
            //     .forEach(System.out::println);

        // limit() & skip()
            // list.stream().limit(2)

        // 4️⃣ Terminal Operations
        // collect()
        // List<Integer> evens = list.stream()
        //                         .filter(x -> x % 2 == 0)
        //                         .collect(Collectors.toList());

        // reduce()
        // int sum = list.stream().reduce(0, (a,b) -> a + b);

        // count()
        // long c = list.stream().count();

        // 5️⃣ Stream with custom objects
        // class Emp {
        //     String name;
        //     int salary;
        // }


        // Find employees with salary > 50k:

        // list.stream()
        //     .filter(e -> e.salary > 50000)
        //     .forEach(e -> System.out.println(e.name));

        // 6️⃣ Collectors Important Methods
        // Grouping:
        // Map<String, List<Student>> map =
        //     students.stream().collect(Collectors.groupingBy(Student::getDept));

        // Counting:
        // Collectors.counting()

        // Averaging:
        // Collectors.averagingInt(Student::getMarks)

        // Joining Strings:
        // Collectors.joining(", ")

    //     ✅ How to Apply Streams on String in Java

    //     🔑 Key Rule = String → convert → Stream → apply operations

    //     1️⃣ Using chars() (MOST IMPORTANT)
    //     ✔ Returns
    //     IntStream of character Unicode values

    //     ✔ Example
    //     String s = "java";

    //     s.chars()
    //     .forEach(System.out::println); // gives unicode, to get see next example

    //     Convert to characters
    //     s.chars()
    //     .mapToObj(c -> (char) c)
    //     .forEach(System.out::println);

    //     🔥 Most used in interviews

    //     ✔ Frequency problems
    //     ✔ First non-repeated character
    //     ✔ Counting vowels/consonants

    //     2️⃣ Using codePoints() (Unicode-safe)
    //     ✔ Use when string may contain emojis / surrogate pairs
    //     s.codePoints()
    //     .mapToObj(Character::toChars)
    //     .map(String::new)
    //     .forEach(System.out::println);

    //     📌 Mostly asked in advanced interviews.

    //     3️⃣ Using split()
    //     ✔ Best for words
    //     String sentence = "java streams are powerful";

    //     Arrays.stream(sentence.split(" "))
    //         .forEach(System.out::println);

    //     Use cases

    //     ✔ Word count
    //     ✔ Longest word
    //     ✔ Frequency of words

    //     4️⃣ Convert String → Character List → Stream
    //     List<Character> chars =
    //         s.chars()
    //         .mapToObj(c -> (char) c)
    //         .toList();

    //     chars.stream().forEach(System.out::println);

    //     5️⃣ Stream over String lines (Java 11+)
    //     String text = "line1\nline2\nline3";

    //     text.lines()
    // .forEach(System.out::println);

    }
}

// ✅Explanation of (System.out::println)
// This is called Method Reference.
// It is a shorter version of a lambda expression.

// 🔍 Long form (Lambda expression)

// list.forEach(x -> System.out.println(x));
// This means:
// Take each element x
// Print it using System.out.println(x)

// ✨ Short form (Method Reference)
// list.forEach(System.out::println);

// Both are exactly the same.

// Below is the complete, interview-ready list, with when & why to use each.

// 🔥 Primitive Stream Conversion Methods (VERY IMPORTANT)

// Java has 3 primitive streams:
// IntStream
// LongStream
// DoubleStream

// Each has special methods to convert to other stream types.

// ✅ 1️⃣ mapToObj()
// ✔ Converts Primitive → Object
// IntStream.range(1, 4)
//          .mapToObj(x -> "Num-" + x)
//          .forEach(System.out::println);

// 📌 Used when:

// You want Stream<T>
// You want to use collect(), groupingBy(), maps, lists

// ✅ 2️⃣ mapToInt()
// ✔ Converts Object → IntStream
// List<String> list = List.of("a", "bb", "ccc");

// list.stream()
//     .mapToInt(String::length)
//     .forEach(System.out::println);

// 📌 Used when:

// Working with numbers
// You want sum(), average(), min(), max()

// ✅ 3️⃣ mapToLong()
// ✔ Converts Object → LongStream
// list.stream()
//     .mapToLong(String::length)
//     .sum();

// ✅ 4️⃣ mapToDouble()
// ✔ Converts Object → DoubleStream
// list.stream()
//     .mapToDouble(Product::getPrice)
//     .average();

// 🔁 Conversion Between Primitive Streams
// ✅ 5️⃣ asLongStream()
// IntStream.range(1, 5)
//          .asLongStream();

// ✅ 6️⃣ asDoubleStream()
// IntStream.range(1, 5)
//          .asDoubleStream();

// ✅ 7️⃣ boxed()
// ✔ Converts Primitive → Wrapper Object Stream
// IntStream.range(1, 4)
//          .boxed()
//          .collect(Collectors.toList());

// Equivalent to:
// mapToObj(Integer::valueOf)

// 📌 Very common in interviews.

// 🧠 Quick Summary Table
// Method	Converts
// mapToObj()	Primitive → Object
// mapToInt()	Object → Int
// mapToLong()	Object → Long
// mapToDouble()	Object → Double
// boxed()	Primitive → Wrapper Object
// asLongStream()	Int → Long
// asDoubleStream()	Int → Double

// 🎯 When to Use What (Golden Rule)
// ✔ If you want collections/maps → mapToObj() / boxed()
// ✔ If you want math operations → mapToInt() / mapToLong() / mapToDouble()
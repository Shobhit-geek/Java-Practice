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
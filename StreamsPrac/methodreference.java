package StreamsPrac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

class Person{
    String name;
    Person(String name){
        this.name = name;
    }
    @Override
    public String toString(){
        return name;
    }
}

public class methodreference {
    // 🔥 SUPER EASY METHOD to Remember Method References

    // There are only 4 types, and each one answers exactly one question.

    // ✅ TYPE–1: ClassName::staticMethod
    // 📌 When to use?

    // When you are calling a static method.

    // ✔ How to detect?

    // If in lambda you wrote:
    // (x, y) -> ClassName.method(x, y)

    // Then convert to:
    // ClassName::method

    // ✅ TYPE–2: object::instanceMethod
    // 📌 When to use?
    // When you call a method on a specific object.

    // ✔ How to detect?

    // If in lambda:
    // x -> someObject.method(x)

    // Convert to:
    // someObject::method

    // 🔥 Example

    // System.out::println
    // because System.out is a pre-existing object.

    // ✅ TYPE–3: ClassName::instanceMethod
    // 📌 When to use?
    // When the method is called on each element of the stream.

    // ✔ How to detect?

    // If in lambda:
    // str -> str.toUpperCase()

    // Convert to:
    // String::toUpperCase

    // When the instance is the stream element itself.
    // ✅ TYPE–4: ClassName::new (Constructor Reference)
    // 📌 When to use?

    // When lambda creates a new object.

    // ✔ How to detect?
    // If in lambda:
    // () -> new ClassName()

    // Convert to:
    // ClassName::new

    public static void main(String[] args) {

        //✅ Part–1: 10 Lambda → Method Reference Conversion Exercises
        // Convert each lambda into a method reference if possible.

        List<Integer> list = new ArrayList<>();
        list = Arrays.asList(11,55,22,99,33);

        // 1️⃣list.forEach(x -> System.out.println(x));
        list.forEach(System.out::println);
        list.forEach(x->System.out.print(x+" "));

        // ✔ Hint: method on a specific object

        // 2️⃣// names.stream().map(str -> str.toUpperCase());
        // names.stream().map(String:: toUpperCase);

        // ✔ Hint: instance method on element

        // 3️⃣nums.stream().sorted((a, b) -> Integer.compare(a, b));
        // nums.stream().sorted(Integer:: compare);

        // ✔ Hint: static compare method

        // 4️⃣list.removeIf(x -> x.isEmpty());
        // list.removeIf(String::isEmpty);

        // ✔ Hint: instance method on element

        // 5️⃣Collections.sort(list, (a, b) -> a.compareTo(b));
        // Collections.sort(list, String::compareTo);

        // ✔ Hint: element’s instance method

        // 6️⃣Stream.generate(() -> new Random());
        // Stream.generate(Random::new);

        // ✔ Hint: constructor reference

        // 7️⃣employees.forEach(emp -> emp.printDetails());
        // employees.forEach(Employee::printDetails);

        // ✔ Hint: instance method on element

        // 8️⃣strings.forEach(s -> logger.log(s));
        // strings.forEach(Logger::log);

        // ✔ Hint: method on specific object

        // 9️⃣list.stream().map(n -> String.valueOf(n));
        // list.stream().map(String::valueof);

        // ✔ Hint: static method of a class

        // 🔟list.stream().map(s -> new Person(s));
        // list.stream().map(Person::new);

        // ✔ Hint: constructor with parameter

        // ✅ Part–2: Stream + Method Reference Combined Question Set

        // 1️⃣ Print each element of a list using method reference
        List<Integer> nums = List.of(1, 2, 3, 4);
        //way1 via lambda
        nums.forEach(x->System.out.print(x));
        //way2 via method reference
        nums.forEach(System.out:: print);

        // 2️⃣ Convert all strings to uppercase using method reference
        List<String> names = List.of("java", "spring", "cloud");
        names.stream().map(String::toUpperCase).forEach(System.out::print);

        // 3️⃣ Sort list of integers using Integer::compare
        List<Integer> nums1 = new ArrayList<>(List.of(5, 2, 1, 4, 3));
        nums1.sort(Integer::compareTo);
        System.out.println(nums1);

        // 4️⃣ Get string lengths
        names.stream().map(String::length).forEach(System.out::println);

        // 5️⃣ Convert integers to strings
        List<String> listnew = nums1.stream().map(String::valueOf).collect(Collectors.toList());
        System.out.println(listnew);

        // 6️⃣ Create Person objects
        names.stream().map(name -> new Person(name)).forEach(System.out::println);
        // names.stream().map(Person::new).forEach(System.out::println);

        // 7️⃣ Filter empty strings
        names.stream().filter(String::isEmpty).forEach(System.out::println);

        // Count Strings with Specific Prefix - Count strings starting with a specific prefix, e.g., “A”.
        List<String> str = List.of("Asdd", "Sfsfsf", "Sfsfs", "Raj");
        List<String> result = str.stream().filter(name-> name.startsWith("A")).toList();    
        System.out.println(result);

        // 5. Find First Non-Repeated Character in a String
        
        String s = "java";
        Optional<Character> ch = s.chars()
                .mapToObj(c -> (char) c)
                .filter(c->s.indexOf(c)==s.lastIndexOf(c))
                .findFirst();

        System.out.println("First non-repeated character: "+ch.orElse(null));

        // 7. Sum of Numbers in a List

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1);
        // mapToInt(x -> x) works because Java automatically unboxes Integer to primitive int.
        int sum = numbers.stream().mapToInt(x->x).sum();

        //int summ = numbers.stream().mapToInt(Integer::intValue).sum();
        //equivalent lambda -> mapToInt(x -> x.intValue())
        System.out.println(sum);

        // 9. Find Duplicate Elements in a List
        HashSet<Integer> unique = new HashSet<>();
        Set<Integer> duplicate = numbers.stream().filter(x->!unique.add(x)).collect(Collectors.toSet());
        System.out.println(duplicate);

        //11. Flatten a List of Lists
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9));
        List<Integer> listRes = listOfLists.stream().flatMap(t->t.stream()).toList();
        System.out.println(listRes);
    }

}

package StreamsPrac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice1 {
    public static void main(String[] args) {

        // way-1 of creating stream from collection
        List<Integer> numbers = List.of(1,3,5,7,9,6);
        List<Integer> squareStream = numbers.stream()
                .map((Integer n) -> n*n).collect(Collectors.toList());
        System.out.print(squareStream);

        //way-2 creating stream from Array
        Integer[] arr = {1,3,4,5,43,435,8};
        Stream<Integer> streamArr = Arrays.stream(arr);
        List<Integer> evenNum = streamArr.filter((Integer n) -> n%2 == 0)
                .collect(Collectors.toList());

        System.out.print(evenNum);

        // way-3 creating stream using static method
        // List
    }
}

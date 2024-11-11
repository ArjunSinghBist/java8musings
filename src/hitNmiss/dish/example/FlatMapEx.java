package hitNmiss.dish.example;

import java.util.Arrays;
import java.util.List;

public class FlatMapEx {
    private static final List<String> wordList = List.of("Hello", "World");

    public static void main(String[] args) {
        wordList.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::print);

//        Square of numbers
        System.out.println("\n############## SQUARE OF NUMBERS ############");
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        nums.stream()
            .map(num -> num * num)
            .forEach(System.out::println);

//        All Pair of two arrays
        List<Integer> numList1 = List.of(1, 2, 3);
        List<Integer> numList2 = List.of(4, 5);

        numList1.stream()
                .flatMap(num1 -> numList2.stream()
                                         .filter(num2 -> (num1 + num2) % 3 == 0)
                                         .map(num2 -> List.of(num1, num2)))
                .forEach(System.out::println);

    }
}

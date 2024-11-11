package hitNmiss.dish.example;

import hitNmiss.dish.Dishes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReduceEx {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sum = numbers.stream()
                         .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);

        int mul = numbers.stream()
                         .reduce(1, (a, b) -> a * b);
        System.out.println("Multiplication: " + mul);

        Optional<Integer> max = numbers.stream()
                                       .reduce(Integer::max);
        Optional<Integer> min = numbers.stream()
                                       .reduce(Integer::min);
        max.ifPresent(n -> System.out.println("Max: " + n));
        min.ifPresent(n -> System.out.println("Min: " + n));

        Dishes.dishes.stream()
                .map(d -> 1)
                .reduce(Integer::sum)
                .ifPresent(n -> System.out.println("Total number of dishes: " + n));
//        Builtin for this
        System.out.println("Count result => " +
                Dishes.dishes.stream().count());
    }
}

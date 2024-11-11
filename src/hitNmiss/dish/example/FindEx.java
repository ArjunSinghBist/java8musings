package hitNmiss.dish.example;

import hitNmiss.dish.Dish;
import hitNmiss.dish.Dishes;
import org.w3c.dom.ls.LSOutput;

import java.util.List;

public class FindEx {
    private static final List<Dish> dishes = Dishes.dishes;

    public static void main(String[] args) {
        dishes.stream()
              .filter(Dish::isVegetarian)
              .findAny()
              .ifPresent(System.out::println);

//        Find first number divisible by 3
        List<Integer> nums = List.of(1, 2, 3, 9, 10);
        nums.stream()
            .map(num -> num * num)
            .filter(num -> num % 3 == 0)
            .findFirst()
            .ifPresent(System.out::println);
    }
}

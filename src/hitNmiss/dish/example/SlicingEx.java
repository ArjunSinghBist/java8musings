package hitNmiss.dish.example;

import hitNmiss.dish.Dish;

import java.util.List;
import java.util.stream.Collectors;

public class SlicingEx {

    private static final List<Dish> dishes = List.of(
            new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER)
                                                    );

    public static void main(String[] args) {
//        The list is already sorted based on calories. We don't need to filter the
//        whole list if we want lower calorie list. We can stop once Calorie value
//        exceeds a given value.
        System.out.println("####### DISHES WITH CALORIE VALUE < 400 #########");
        dishes.stream()
              .takeWhile(dish -> dish.getCalories() < 400)
              .forEach(System.out::println);

//        opposite of the above slicing
        System.out.println("\n##### DISHES WITH CALORIE > 400 ############");
        dishes.stream()
              .dropWhile(dish -> dish.getCalories() < 400)
              .forEach(System.out::println);

//        limit output to 2 dishes with calorie value > 300
        System.out.println("\n####### 2 DISHES WITH CALORIE VALUE > 300 ######");
        dishes.stream()
              .filter(dish -> dish.getCalories() > 300)
              .limit(2)
              .forEach(System.out::println);

//        skip first 2 dishes with calorie value > 300
        System.out.println("\n######## DISHES WITH CALORIE > 300 (EXCEPT FIRST 2)############");
        dishes.stream()
              .filter(dish -> dish.getCalories() > 300)
              .skip(2)
              .forEach(System.out::println);

//        fliter first 2 meat dishes
        System.out.println("\n###### FILTER FIRST 2 MEAT DISHES ######");
        dishes.stream()
              .filter(dish -> dish.getType() == Dish.Type.MEAT)
              .limit(2)
              .forEach(System.out::println);

//        Get the names of the dishes
        System.out.println("\n#### LIST OF NAME OF THE DISHES ######");
        List<String> names = dishes.stream()
                                   .map(Dish::getName)
                                   .collect(Collectors.toList());
        System.out.println("Names => " + names);
    }
}

package hitNmiss.dish.example;

import hitNmiss.dish.Dish;
import hitNmiss.dish.Dishes;

import java.util.List;

public class MatchingEx {

    public static void main(String[] args) {
        List<Dish> dishes = Dishes.dishes;
        if(dishes.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("There are some vegetarian dishes.");
        }

        if(!dishes.stream().allMatch(Dish::isVegetarian)) {
            System.out.println("There are some non-vegetarian dishes.");
        }

        if(dishes.stream().noneMatch(dish -> dish.getCalories() > 800)) {
            System.out.println("There are no dishes with calories above 800!");
        }
    }
}

package hitNmiss.dish.example;

import hitNmiss.dish.Dishes;

public class dishFilter {
    public static void main(String[] args) {
        Dishes.dishes.stream()
                .filter(dish -> {
                    System.out.println("Filtering -> " + dish.getName());
                    return dish.getCalories() > 400;
                })
                .map(dish -> {
                    System.out.println("Mapping -> " + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .forEach(System.out::println);
    }
}

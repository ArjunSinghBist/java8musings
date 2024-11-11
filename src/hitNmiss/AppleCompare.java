package hitNmiss;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AppleCompare {

    public static void main(String[] args) {
        List<Apple> apples = List.of(new Apple(140, Color.GREEN),
                new Apple(180, Color.RED),
                new Apple(190, Color.GREEN));

        System.out.println("List of Heavy Apples: " + filter(apples,
                (apple) -> apple.getWeight() >=150));

        System.out.println("List of Green Apples: " + filter(apples,
                apple -> apple.getColor().equals(Color.GREEN)));
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for(T ele: list) {
            if(predicate.test(ele)) {
                result.add(ele);
            }
        }
        return result;
    }

}

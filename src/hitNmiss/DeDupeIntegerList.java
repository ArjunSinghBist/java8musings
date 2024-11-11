package hitNmiss;

import java.util.*;
import java.util.stream.Collectors;

public class DeDupeIntegerList {

    static List<String> orgList = List.of("1", "2", "3",
            "3", "4", "5", "X", "10", "B", "42", "43", "44", "54");

    public static void main(String[] args) {

        List<String> randomList = new ArrayList<>();
        orgList.forEach(randomList::add);


        System.out.println("Original List -> " + orgList);
        System.out.println("Integer List imperative way -> " + impWay(orgList));
        System.out.println("Integer List stream way ->" + streamWay(orgList));
        System.out.println("Integer List stream way2 ->" + streamWay2(orgList));
    }

    private static List<Integer> streamWay2(List<String> orgList) {
        return orgList.stream()
                .distinct()
                .map(DeDupeIntegerList::convertToInt)
                .filter(Optional<Integer>::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    private static Optional<Integer> convertToInt(String s) {
        try {
            return Optional.of(Integer.valueOf(s));
        }catch (NumberFormatException _) {
            return Optional.empty();
        }
    }

    static Set<Integer> impWay(List<String> list) {

        Set<Integer> intList = new HashSet<>();
        for (String element : orgList) {
            try {
                intList.add(Integer.valueOf(element));
            } catch (NumberFormatException _) {
            }
        }

        return intList;
    }

    static List<Integer> streamWay(List<String> list) {

        return list.stream()
                   .distinct()
                   .map((num) -> {
                       try {
                           return Integer.valueOf(num);
                       } catch (NumberFormatException _) {
                       }
                       return null;
                   })
                   .filter(Objects::nonNull)
                   .collect(Collectors.toList());
    }
}
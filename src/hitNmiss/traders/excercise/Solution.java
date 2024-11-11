package hitNmiss.traders.excercise;

import hitNmiss.traders.Trader;
import hitNmiss.traders.Traders;
import hitNmiss.traders.Transaction;

import java.util.Comparator;
import java.util.List;

public class Solution {
    private final static List<Trader> traders = List.of(Traders.alan,
            Traders.brian,
            Traders.mario,
            Traders.raoul
                                                       );

    public static void main(String[] args) {
//      All transaction in 2011 and sorted by value
        System.out.println("\n###### TRANSACTIONS IN 2011 SORTED BY VALUE ASCENDING #######");
        Traders.transactions.stream()
                            .filter(transaction -> transaction.getYear() == 2011)
                            .sorted(Comparator.comparing(Transaction::getValue))
                            .forEach(System.out::println);

//        Unique cities of Traders working location
        System.out.println("\n####### UNIQUE CITIES WHERE TRADERS WORK ##########");
        traders.stream()
               .map(Trader::getCity)
               .distinct()
               .forEach(System.out::println);

//        Sort all Traders in Cambridge by name
        System.out.println("\n######## SORTED LIST BY NAME OF TRADERS IN CAMBRIDGE #########");
        traders.stream()
               .filter(trader -> "cambridge".equalsIgnoreCase(trader.getCity()))
               .map(Trader::getName)
               .sorted()
               .forEach(System.out::println);

        System.out.println("\n########### SORTED NAMES OF ALL TRADERS ###############");
        traders.stream()
               .map(Trader::getName)
               .sorted()
               .forEach(System.out::println);

        System.out.println("\n########## ANY TRADER BASED IN MILAN ###########");
        traders.stream()
               .filter(trader -> "milan".equalsIgnoreCase(trader.getCity()))
               .findAny().ifPresent(System.out::println);

        boolean milanTrader = Traders.transactions.stream()
                                                  .anyMatch(transaction -> transaction.getTrader().getCity().equalsIgnoreCase("milan"));
        System.out.println("Any trader in Milan: " + milanTrader);

        System.out.println("\n########### VALUES OF ALL TRANSACTION OF TRADERS IN CAMBRIDGE#########");
        Traders.transactions.stream()
                            .filter(transaction -> transaction.getTrader().getCity().equalsIgnoreCase("cambridge"))
                            .map(Transaction::getValue)
                            .forEach(System.out::println);

        System.out.println("\n############ HIGHEST VALUE OF ALL THE TRANSACTINS #######");
        Traders.transactions.stream()
                            .map(Transaction::getValue)
                            .reduce(Integer::max)
                            .ifPresent(System.out::println);

        System.out.println("\n############### LOWEST VALUE OF ALL THE TRANSACTINS ###############");
        Traders.transactions.stream()
                            .map(Transaction::getValue)
                            .reduce(Integer::min)
                            .ifPresent(System.out::println);

    }
}

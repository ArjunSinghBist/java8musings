package hitNmiss.traders.excercise;

import hitNmiss.traders.Transaction;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static hitNmiss.traders.Traders.transactions;

public class PrimitiveStreams {

    public static void main(String[] args) {
        long sum = transactions.stream()
                .mapToLong(Transaction::getValue)
                .sum();
        System.out.println("Sum of all transactions: " + sum);

        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
              .limit(20)
              .forEach(t -> System.out.println(t[0] + " " + t[1]));
    }
}

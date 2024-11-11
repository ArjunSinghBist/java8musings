package hitNmiss.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.IntConsumer;

public class ExecuterTryWithResources {

    public static void main(String[] args) {

        try(ExecutorService executorService = Executors.newFixedThreadPool(2)) {
            for(int i = 0; i < 10; i++) {
                int taskid = i;
                executorService.submit(() -> {
                    System.out.println("Executing task num " + taskid +
                            " in thread -> " + Thread.currentThread().getName());

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }catch(RuntimeException e) {
            e.printStackTrace();
        }

        IntConsumer consumer = System.out::println;
        consumer.accept(10);
    }
}

package hitNmiss.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args) {

//        Make a pool of connection
        ExecutorService executorService = Executors.newFixedThreadPool(2);

//        execute two threads
        for (int i = 0; i < 10; i++) {
            final int taksid = i;
            executorService.submit(() -> {
                System.out.println("Executing task number: " + taksid +
                        " in thread -> " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executorService.shutdown();

    }
}

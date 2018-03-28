package thread;

import java.util.concurrent.*;

/**
 * Created by Blong on 2018/3/28.
 */
public class CallableThreadDemo {


    public static void main(String args[]) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println("Factorial Service called for 10!");
        Future<Long> result10 = executorService.submit(new FactorialService(10));

        System.out.println("Factorial Service called for 20!");
        Future<Long> result20 = executorService.submit(new FactorialService(20));

        Long factorial10 = result10.get();
        System.out.println("10! = "+ factorial10);
        Long factorial20 = result20.get();
        System.out.println(factorial20);
        executorService.shutdown();


    }

    static class FactorialService implements Callable<Long> {
        private int number;

        public FactorialService(int number) {
            this.number = number;
        }
        @Override
        public Long call() throws Exception {
            return factorial();
        }
        public Long factorial() throws InterruptedException {
            long result = 1;
            while (number != 0) {
                result = number * result;
                number --;
                Thread.sleep(100);
            }
            return result;
        }

    }
}


package thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Blong on 2018/3/28.
 */
public class ExecutorDemo {
    public static void main(final String[] arguments) {
        Executor executor = Executors.newCachedThreadPool();
        executor.execute(new Task());
        ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) executor;
        poolExecutor.shutdown();
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            Long duration = (long) (Math.random() * 5);
            System.out.println("Running Task!");
            try {
                TimeUnit.SECONDS.sleep(duration);
                System.out.println("Task Completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}

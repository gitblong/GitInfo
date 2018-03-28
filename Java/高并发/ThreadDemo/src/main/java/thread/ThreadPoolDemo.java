package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Blong on 2018/3/28.
 */
public class ThreadPoolDemo {

    public static void main(final String[] arguments) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) executorService;

        System.out.println("Core threads: " + poolExecutor.getCorePoolSize());
        System.out.println("Largest executions: " + poolExecutor.getLargestPoolSize());
        System.out.println("Maximum allowed threads: " + poolExecutor.getMaximumPoolSize());
        System.out.println("Current threads in pool: " + poolExecutor.getPoolSize());
        System.out.println("Currently executing threads: " + poolExecutor.getActiveCount());
        System.out.println("Total number of threads(ever scheduled): " + poolExecutor.getTaskCount());

        poolExecutor.submit(new Task());
        poolExecutor.submit(new Task());

        System.out.println("Core threads: " + poolExecutor.getCorePoolSize());
        System.out.println("Largest executions: " + poolExecutor.getLargestPoolSize());
        System.out.println("Maximum allowed threads: " + poolExecutor.getMaximumPoolSize());
        System.out.println("Current threads in pool: " + poolExecutor.getPoolSize());
        System.out.println("Currently executing threads: " + poolExecutor.getActiveCount());
        System.out.println("Total number of threads(ever scheduled): " + poolExecutor.getTaskCount());

        executorService.shutdown();
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            try {
                Long duration = (long) (Math.random() * 5);
                System.out.println("Running Task! Threa Name: " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(duration);
                System.out.println("Task Completed! Thread Name: "+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

package thread;

/**
 * Created by Blong on 2018/3/28.
 */
public class TestThreadLock {
    public static Object lock1 = new Object();
    public static Object Lock2 = new Object();

    private static class ThreadDemo1 extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 1:Holding lock1...");
                try {
                    Thread.sleep(10);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread1:Holding lock 1& 2...");
                synchronized (Lock2) {
                    System.out.println("Thread 1:Holding lock 1 & 2...");
                }
            }
        }
    }

    private static class ThreadDemo2 extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 1:Holding lock2...");
                try {
                    Thread.sleep(10);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread1:Holding lock 1& 2...");
                synchronized (Lock2) {
                    System.out.println("Thread 1:Holding lock 1 & 2...");
                }
            }
        }
    }


    public static void main(String args[]) {
        ThreadDemo1 T1 = new ThreadDemo1();
        ThreadDemo2 T2 = new ThreadDemo2();
        T1.start();
        T2.start();

    }
}

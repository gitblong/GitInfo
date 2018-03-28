package thread;

/**
 * Created by Blong on 2018/3/28.
 */
public class ThreadLocalDemo implements Runnable {

    int counter;
    ThreadLocal<Integer> threadLocal = new ThreadLocal<>();


    @Override
    public void run() {
        counter++;
        if (threadLocal.get() != null) {
            threadLocal.set(threadLocal.get().intValue() + 1);
        } else {
            threadLocal.set(0);
        }
        System.out.println("Counter: " + counter);
        System.out.println("threaLocal: " + threadLocal.get());
    }
}

class TestThread6 {

    public static void main(String args[]) {
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();

        Thread t1 = new Thread(threadLocalDemo, "1");
        Thread t2 = new Thread(threadLocalDemo, "2");
        Thread t3 = new Thread(threadLocalDemo, "3");
        Thread t4 = new Thread(threadLocalDemo, "4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

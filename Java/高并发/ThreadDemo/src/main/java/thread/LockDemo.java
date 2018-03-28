package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Blong on 2018/3/28.
 */
public class LockDemo {
    private final Lock queueLock = new ReentrantLock();

    public void print() {
        queueLock.lock();
        try {
            Long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() + " Time Taken " + (duration / 1000) + "seconds");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.printf("%s printed the document successfully.\n", Thread.currentThread().getName());
            queueLock.unlock();
        }
    }



}
class ThreadDemo8 extends Thread {
    LockDemo lockDemo;

    ThreadDemo8(String name, LockDemo lockDemo) {
        super(name);
        this.lockDemo = lockDemo;
    }

    @Override
    public void run() {
        System.out.printf("%s starts printing a document\n", Thread.currentThread().getName());
        lockDemo.print();
    }
}
class TestThread7 {
    public static void main(String args[]) {
        LockDemo lockDemo = new LockDemo();
        ThreadDemo8 threadDemo1 = new ThreadDemo8("Thread - 1",lockDemo);
        ThreadDemo8 threadDemo2 = new ThreadDemo8("Thread - 2",lockDemo);
        ThreadDemo8 threadDemo3 = new ThreadDemo8("Thread - 3",lockDemo);
        ThreadDemo8 threadDemo4 = new ThreadDemo8("Thread - 4",lockDemo);
        threadDemo1.start();
        threadDemo2.start();
        threadDemo3.start();
        threadDemo4.start();

    }
}

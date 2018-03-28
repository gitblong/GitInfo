package thread;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Created by Blong on 2018/3/28.
 */
public class RunableDemo implements Runnable {
    public Thread t;
    private String threadName;
    boolean suspended = false;

    public RunableDemo(String name) {
        threadName = name;
        System.out.println("Creating" + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running" + threadName);
        try {
            for (int i = 10; i > 0; i--) {
                System.out.println("Thread:" + threadName + "," + i);
                //Let the thread sleep for a while
                Thread.sleep(300);
                synchronized (this) {
                    while (suspended) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Thread"+threadName+" interrupted.");
        }
        System.out.println("Thread"+threadName + " exiting.");
    }
    public void start() {
        System.out.println("Starting "+threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    void suspend() {
        suspended = true;
    }
    synchronized void resume() {
        suspended = false;
        notify();
    }
}

class TestThrea2 {
    public static void main(String args[]) {
        RunableDemo runableDemo1 = new RunableDemo("Thread-1");
        runableDemo1.start();
        RunableDemo runableDemo2 = new RunableDemo("Thread-2");
        runableDemo2.start();
        try {
            Thread.sleep(1000);
            runableDemo1.suspend();
            System.out.println("Suspending First Thread");
            Thread.sleep(1000);
            runableDemo1.resume();
            System.out.println("Resuming First Thread");

            runableDemo2.suspend();
            System.out.println("Suspending thread Two");
            Thread.sleep(1000);
            runableDemo2.resume();
            System.out.println("Resuming thread Two");
        } catch (InterruptedException e) {
            System.out.println("Main Thread Interrupted");
        }
        try {
            System.out.println("Waiting for threads to finish.");
            runableDemo1.t.join();
            runableDemo2.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main Thread Interrupted");
        }
        System.out.println("Main thread exiting");
    }
}
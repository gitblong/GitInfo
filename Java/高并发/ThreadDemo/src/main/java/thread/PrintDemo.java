package thread;

/**
 * Created by Blong on 2018/3/28.
 */
public class PrintDemo {
    public void printCount() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Counter --- "+ i);
            }
        } catch (Exception e) {
            System.out.println("Thread interrupted.");
        }
    }
}

class ThreadDemo4 extends Thread {
    private Thread t;
    private String threadName;
    PrintDemo PD;

    ThreadDemo4(String name, PrintDemo printDemo) {
        threadName = name;
        PD = printDemo;
    }

    @Override
    public void run() {
        synchronized (PD) {
            PD.printCount();
        }
        System.out.println("Thread " + threadName +" exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

class TestThread5{
    public static void main(String args[]) {
        PrintDemo PD = new PrintDemo();
        ThreadDemo4 T1 = new ThreadDemo4("Thread - 1",PD);
        ThreadDemo4 T2 = new ThreadDemo4("Thread - 2",PD);

        T1.start();
        T2.start();

        //wait for threads to end
        try {
            T1.join();//让线程优先执行，在执行main以下的方法
            T2.join();//让线程优先执行，在执行main以下的方法
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

    }
}


package thread;

import com.sun.org.apache.xalan.internal.xsltc.runtime.InternalRuntimeError;

/**
 * Created by Blong on 2018/3/28.
 */
public class Chat {
    boolean flag = false;

    public synchronized void Questing(String msg) {
        if (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(msg);
        flag = true;
        notify();
    }

    public synchronized void Answer(String msg) {
        if (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(msg);
        flag = false;
        notify();
    }
}

class T1 implements Runnable {
    Chat m;
    String[] s1 = {"Hi","How are you?","I am also doing fine!"};

    public T1(Chat m) {
        this.m = m;
        new Thread(this,"Question").start();
    }

    @Override
    public void run() {
        for(int i=0;i<s1.length;i++) {
            m.Questing(s1[i]);
        }
    }
}

class T2 implements Runnable {
    Chat m;
    String[] s2 = {"Hi","I am good,what about you","Great!"};

    public T2(Chat m) {
        this.m = m;
        new Thread(this, "Answer").start();
    }

    @Override
    public void run() {
        for(int i = 0;i<s2.length;i++) {
            m.Answer(s2[i]);
        }
    }
}

class TestThread3 {
    public static void main(String args[]) {
        Chat m = new Chat();
        new T1(m);
        new T2(m);
    }
}
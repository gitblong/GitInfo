package thread;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Blong on 2018/3/28.
 */
public class ThreadConditionDemo {
    public static void main(String args[]) throws InterruptedException {

        ItemQueue itemQueue = new ItemQueue(10);
        //Create a producer and a consumer
        Thread procer = new Producer(itemQueue);
        Thread consumer= new Consumer(itemQueue);

        procer.start();
        consumer.start();

        procer.join();
        consumer.join();
    }

    static class ItemQueue {
        private Object[] items = null;
        private int current = 0;
        private int placeIndex = 0;
        private int removeIndex = 0;

        private final Lock lock;
        private final Condition isEmpty;
        private final Condition isFull;

        public ItemQueue(int capcity) {
            this.items = new Object[capcity];
            lock = new ReentrantLock();
            isEmpty = lock.newCondition();
            isFull = lock.newCondition();

        }
        public void add(Object item) throws InterruptedException {
            lock.lock();
            while (current >= items.length) {
                isFull.await();
            }
            items[placeIndex] = item;
            placeIndex = (placeIndex + 1) % items.length;

            ++current;

            isEmpty.signal();
            lock.unlock();
        }
        public Object remove() throws InterruptedException {
            Object item = null;

            lock.lock();
            while (current <= 0) {
                isEmpty.await();
            }
            item = items[removeIndex];
            removeIndex = (removeIndex + 1) % items.length;
            --current;

            isFull.signal();
            lock.unlock();
            return item;
        }

        public boolean isEmpty() {
            return (items.length == 0);
        }
    }

    static class Producer extends Thread {
        private final ItemQueue queue;

        public Producer(ItemQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
            try {
                for (String number : numbers) {
                    queue.add(number);
                    System.out.println("Producer: "+ number);
                }
                queue.add(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class Consumer extends Thread {
        private final ItemQueue queue;

        public Consumer(ItemQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
            try {
                do {
                    Object number = queue.remove();
                    System.out.println("Consumer: " + number);
                    if (number == null) {
                        return;
                    }
                } while (!queue.isEmpty());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

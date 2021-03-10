package web.services.learn.multiThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    Lock lock = new ReentrantLock();
    volatile static int id = 0;

    public void printThreadName() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() +" "+ ++id);
        } finally {
            lock.unlock();
        }
    }
}

package web.services.learn.multiThread.threadPool;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SerialNumberGenerator {
    private static volatile int currentNumber = 0;
    static Lock lock = new ReentrantLock();

    /**
     * This example shows that ++i is unsafe. So we can add "synchronized" to solve it.
     *
     * @return
     */
    public static int next() {
        lock.lock();
        try {
            ++currentNumber;
        }finally {
            lock.unlock();
        }
        return currentNumber;
    }
}

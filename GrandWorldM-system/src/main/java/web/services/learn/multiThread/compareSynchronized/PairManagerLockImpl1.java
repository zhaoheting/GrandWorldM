package web.services.learn.multiThread.compareSynchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PairManagerLockImpl1 extends PairManager {
    Lock lock = new ReentrantLock();

    /**
     * 不明白为什么这里用了手动锁 却还用加synchronized关键字。
     */
    @Override
    public synchronized void increment() {
        lock.lock();
        try {
            pair.incrementX();
            pair.incrementY();
            store(getPair());
        } finally {
            lock.unlock();
        }
    }
}

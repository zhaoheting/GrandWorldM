package web.services.learn.multiThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EvenGenerator extends IntGenerator {
    private int currentValue = 0;
    Lock lock = new ReentrantLock();

    @Override
    public synchronized Integer next() {
        ++currentValue;
        Thread.yield();
        ++currentValue;
        return currentValue;
    }
}

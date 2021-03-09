package web.services.learn.multiThread.compareSynchronized;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * The purpose of the class is to visit pair thread-safely. So the pair object can not be visited by its reference
 * but only the method except in the subclass.
 */
public abstract class PairManager {
    protected Pair pair = new Pair();
    public AtomicInteger checkCount = new AtomicInteger(0);


    public synchronized Pair getPair() {
        return new Pair(pair.getX(), pair.getY());
    }

    abstract public void increment();
}

package web.services.learn.multiThread.compareSynchronized;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The purpose of the class is to visit pair thread-safely. So the pair object can not be visited by its reference
 * but only the method except in the subclass.
 */
public abstract class PairManager {
    protected Pair pair = new Pair();
    public AtomicInteger checkCount = new AtomicInteger(0);
    private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());

    public synchronized Pair getPair() {
        return new Pair(pair.getX(), pair.getY());
    }

    public void store(Pair pair) {
        this.storage.add(pair);
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    abstract public void increment();
}

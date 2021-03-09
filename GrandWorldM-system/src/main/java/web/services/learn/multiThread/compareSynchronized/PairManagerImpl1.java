package web.services.learn.multiThread.compareSynchronized;

public class PairManagerImpl1 extends PairManager {
    @Override
    public synchronized void increment() {
        pair.incrementX();
        pair.incrementY();
        store(pair);
    }
}

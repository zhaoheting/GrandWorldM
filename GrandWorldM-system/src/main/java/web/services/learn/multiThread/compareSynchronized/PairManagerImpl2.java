package web.services.learn.multiThread.compareSynchronized;

public class PairManagerImpl2 extends PairManager {
    @Override
    public void increment() {
        Pair temp;
        synchronized (this) {
            pair.incrementX();
            pair.incrementY();
            temp = new Pair(pair.getX(), pair.getY());
        }
        //当线程执行store方法时，checker线程是可以抢占cpu的。所以使用此pm的checker要多check很多次。
        store(temp);
    }
}

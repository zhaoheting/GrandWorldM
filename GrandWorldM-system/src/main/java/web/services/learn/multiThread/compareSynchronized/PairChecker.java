package web.services.learn.multiThread.compareSynchronized;

public class PairChecker implements Runnable {
    private PairManager pairManager;

    public PairChecker(PairManager pairManager) {
        this.pairManager = pairManager;
    }

    @Override
    public void run() {
        while (true) {
            pairManager.checkCount.incrementAndGet();
            pairManager.getPair().checkState();
        }
    }
}

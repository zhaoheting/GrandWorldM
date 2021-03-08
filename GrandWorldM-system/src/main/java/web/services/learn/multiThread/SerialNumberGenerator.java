package web.services.learn.multiThread;

public class SerialNumberGenerator {
    private static volatile int currentNumber = 0;

    /**
     * This example shows that ++i is unsafe.
     *
     * @return
     */
    public synchronized static int next() {
        return ++currentNumber;
    }
}

package web.services.learn.multiThread;

public class SerialNumberGenerator {
    private static volatile int currentNumber = 0;

    /**
     * This example shows that ++i is unsafe. So we can add "synchronized" to solve it.
     *
     * @return
     */
    public static int next() {
        return ++currentNumber;
    }
}

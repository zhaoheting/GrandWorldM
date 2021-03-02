package web.services.learn.multiThread;

public class EvenGenerator extends IntGenerator {
    private int currentValue = 0;

    @Override
    public Integer next() {
        ++currentValue;
        ++currentValue;
        return currentValue;
    }
}

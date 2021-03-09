package web.services.learn.multiThread.compareSynchronized;

/**
 * A unsafe class.
 */
public class Pair {
    private int x;
    private int y;

    public Pair() {
        this(0, 0);
    }


    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void incrementX() {
        ++x;
    }

    public void incrementY() {
        ++y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    class NotEqualException extends RuntimeException {
        public NotEqualException() {
            super("x: " + x + "is not equal to y: " + y);
        }
    }

    public void checkState() {
        if (x != y) {
            throw new NotEqualException();
        }
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

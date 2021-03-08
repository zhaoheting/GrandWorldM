package web.services.learn.multiThread;

public class CircularSet {
    private int[] items;
    private int length = 0;
    private int index = 0;

    public CircularSet(int size) {
        this.items = new int[size];
        length = size;
    }

    public synchronized boolean contains(int num) {
        for (int i = 0; i < length; ++i) {
            if (items[i] == num) {
                return true;
            }
        }
        return false;
    }

    public synchronized void add(int num) {
        items[index] = num;
        index = (index +1) % length;
    }
}

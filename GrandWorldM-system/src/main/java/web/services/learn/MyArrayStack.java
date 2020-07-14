package web.services.learn;

public class MyArrayStack<E> {
    private static final int DEFAULT_CAPACITY=10;
    private E[] theItems;
    private int theSize;

    public MyArrayStack() {
        doClear();
    }

    private void doClear() {
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return theSize;
    }

    private void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }
        E[] oldItems = theItems;
        theItems = (E[]) new Object[newCapacity];
        for (int i = 0; i < theSize; i++) {
            theItems[i] = oldItems[i];
        }
    }

    public void push(E e) {
        ensureCapacity(size()*2+1);
        theItems[theSize++] = e;
    }

    public void pop() {
        theItems[theSize--] = null;
    }

    public E top() {
        return theItems[theSize-1];
    }
}

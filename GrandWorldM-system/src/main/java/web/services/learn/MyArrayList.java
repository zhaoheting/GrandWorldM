package web.services.learn;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements Iterable<E> {

    private final static int DEFAULT_CAPACITY = 10;
    //The number of the elements in the list;
    private int theSize;
    //theItems.length means the size of the array,some elements may be null.
    private E[] theItems;

    public MyArrayList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    public void doClear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return theSize == 0;
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    public void add(int index, E e) {
        if (theItems.length == size()) {
            //The +1 is used in case the size is zero.
            ensureCapacity(theSize * 2 + 1);
        }
        for (int i = theSize; i > index; i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[index] = e;
        theSize++;
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

    public boolean add(E e) {
        add(theSize, e);
        return true;
    }

    public E remove(int index) {
        E removedItem = theItems[index];
        for (int i = index; i < size() - 1; i++) {
            theItems[i] = theItems[i + 1];
        }
        theSize--;
        return removedItem;
    }

    private E set(int index, E e) {
        if (index < 0 || index > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E oldItem = theItems[index];
        theItems[index] = e;
        return oldItem;
    }

    public E get(int index) {
        if (index < 0 || index > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[index];
    }

    @Override
    public Iterator iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<E> {

        private int currentIndex;

        @Override
        public boolean hasNext() {
            return currentIndex < size();
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return theItems[currentIndex++];
        }

        @Override
        public void remove() {
            //为什么要--，iterator中的remove方法难道都得在next()方法之后调用么？
            MyArrayList.this.remove(--currentIndex);
        }
    }
}

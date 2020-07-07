package web.services.learn;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class MyLinkedList<E> implements Iterable<E> {

    private Node<E> previousLink;
    private Node<E> nextLink;
    private int modCount;
    private int theSize;

    public int size() {
        return theSize;
    }

    public boolean add(int index) {
        modCount++;
    }

    public boolean remove(int index) {
        modCount--;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    class LinkedListIterator implements Iterator<E> {

        private int expectedModCount = MyLinkedList.this.modCount;

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            if (!checkModCount()) {
                throw new ConcurrentModificationException();
            }
            return null;
        }

        @Override
        public void remove() {
            if (!checkModCount()) {
                throw new ConcurrentModificationException();
            }
        }

        boolean checkModCount() {
            return expectedModCount == MyLinkedList.this.modCount;
        }
    }

    private static class Node<E> {
        private Node<E> previousLink;
        private Node<E> nextLink;
        private E data;

        public Node(Node<E> previousLink, Node<E> nextLink, E data) {
            this.previousLink = previousLink;
            this.nextLink = nextLink;
            this.data = data;
        }
    }

}

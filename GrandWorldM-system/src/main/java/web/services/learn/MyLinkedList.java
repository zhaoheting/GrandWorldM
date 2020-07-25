package web.services.learn;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements Iterable<E> {

    private Node<E> beginMarker;
    private Node<E> endMarker;
    private int modCount = 0;
    private int theSize;

    public MyLinkedList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        theSize = 0;
        beginMarker = new Node<>(null, null, null);
        endMarker = new Node<>(null, beginMarker, null);
        beginMarker.next = endMarker;
        theSize = 0;
        modCount++;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean add(E data) {
        add(size(), data);
        return true;
    }

    public void add(int index, E data) {
        addBefore(data, getNode(index, 0, size()));
    }

    /**
     * Exercise 3.3
     *
     * @param o
     * @return
     */
    public boolean contains(E o) {
        Node<E> currentNode = beginMarker.next;
        while (currentNode != endMarker && !currentNode.data.equals(o)) {
            currentNode = currentNode.next;
        }
        return currentNode != endMarker;
    }

    public E get(int index) {
        return getNode(index).data;
    }

    public E set(int index, E newVal) {
        Node<E> node = getNode(index);
        E oldVal = node.data;
        node.data = newVal;
        return oldVal;
    }

    public E remove(int index) {
        Node<E> node = getNode(index);
        node.previous.next = node.next;
        node.next.previous = node.previous;
        modCount--;
        return node.data;
    }

    public E remove(Node<E> node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
        modCount--;
        return node.data;
    }

    /**
     * This method is used by method {@code get()}, the the upper should be size-1.
     *
     * @param index
     * @return
     */
    public Node<E> getNode(int index) {
        return getNode(index, 0, size() - 1);
    }

    /**
     * When it is called by add method ,the upper should be set as size instead of size-1.
     *
     * @param index
     * @param lower
     * @param upper
     * @return
     */
    public Node<E> getNode(int index, int lower, int upper) {
        if (index < lower || index > upper) {
            throw new IndexOutOfBoundsException();
        }
        Node currentNode;
        if (index < size() / 2) {
            currentNode = beginMarker.next;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = endMarker;
            for (int j = size(); j > index; j--) {
                currentNode = currentNode.previous;
            }
        }
        return currentNode;
    }

    private void addBefore(E data, Node<E> node) {
        Node currentNode = new Node(data, node.previous, node);
        currentNode.previous.next = currentNode;
        node.previous = currentNode;
        theSize++;
        modCount++;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    class LinkedListIterator implements Iterator<E> {

        private int expectedModCount = MyLinkedList.this.modCount;
        private boolean okToRemove = false;//?
        private Node<E> current = beginMarker.next;

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public E next() {
            if (!checkModCount()) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = current.data;
            current = current.next;
            okToRemove = true;//?
            return data;
        }

        @Override
        public void remove() {
            if (!checkModCount()) {
                throw new ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalStateException();
            }
            MyLinkedList.this.remove(current.previous);
            modCount++;
            okToRemove = false;//?
        }

        boolean checkModCount() {
            return expectedModCount == MyLinkedList.this.modCount;
        }
    }

    public static class Node<E> {

        public Node<E> previous;
        public Node<E> next;
        public E data;

        public Node(E data, Node<E> p, Node<E> n) {
            this.previous = p;
            this.next = n;
            this.data = data;
        }
    }

}

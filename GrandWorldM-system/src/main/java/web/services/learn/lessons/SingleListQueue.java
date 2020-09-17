package web.services.learn.lessons;

/**
 * 基于单链表实现队列。
 */
public class SingleListQueue<AnyType> {

    private Node<AnyType> head;
    private Node<AnyType> tail;
    private int theSize;

    public void enqueue(AnyType element) {
        if (head == null) {
            head = new Node<>(element, null);
            tail = head;
        } else {
            tail.next = new Node<>(element, null);
            tail = tail.next;
        }
        theSize++;
    }

    private boolean isEmpty() {
        return theSize == 0;
    }

    public AnyType dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty.");
        }
        AnyType element = head.element;
        head = head.next;
        theSize--;
        return element;
    }

    public int size() {
        return theSize;
    }

    private class Node<E> {
        private E element;
        private Node<E> next;

        private Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}

package web.services.learn.lessons;

/**
 * 基于双向链表实现队列。--与单链表基本类似。
 * 因为队列的插入和删除有特殊性，所以没有必要使用哨兵节点。
 *
 * @param <AnyType>
 */
public class DoubleListQueue<AnyType> {

    private Node<AnyType> head;
    private Node<AnyType> tail;
    private int theSize;

    public void enqueue(AnyType element) {
        if (isEmpty()) {
            head = new Node<>(null, null, element);
            tail = head;
        } else {
            tail.next = new Node<>(tail, null, element);
            tail = tail.next;
        }
        theSize++;
    }

    public AnyType dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty.");
        }
        AnyType element = head.data;
        head = head.next;
        head.pre = null;
        theSize--;
        return element;
    }

    public boolean isEmpty() {
        return theSize == 0;
    }

    private class Node<E> {
        private Node<E> pre;
        private Node<E> next;
        E data;

        private Node(Node<E> pre, Node<E> next, E data) {
            this.pre = pre;
            this.next = next;
            this.data = data;
        }
    }
}

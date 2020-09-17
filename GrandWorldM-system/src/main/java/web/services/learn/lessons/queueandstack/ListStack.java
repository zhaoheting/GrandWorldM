package web.services.learn.lessons.queueandstack;

/**
 * 基于单链表实现栈，自己编写的代码。
 */
public class ListStack<AnyType> {

    private Node<AnyType> head;
    private int size;

    public void push(AnyType element) {
        head = new Node<>(element, head);
        size++;
    }

    public AnyType pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈是空的!");
        }
        AnyType element = head.element;
        head = head.next;
        size--;
        return element;
    }

    private boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return this.size;
    }

    public AnyType top() {
        return head.element;
    }

    private static class Node<E> {
        public E element;
        public Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}

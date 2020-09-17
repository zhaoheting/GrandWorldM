package web.services.learn.lessons.queueandstack;

/**
 * 基于双向链表实现栈。
 */
public class DoubleListStack<AnyType> implements MyStack<AnyType> {

    private Node<AnyType> top;
    private int size;

    @Override
    public void push(AnyType data) {
        top = new Node<>(null, top, data);
        size++;
    }

    @Override
    public AnyType pop() {
        if (isEmpty()) {
            throw new RuntimeException("The stack is empty.");
        }
        AnyType data = top.data;
        top = top.next;
        //断开与上一个节点的连接。
        top.pre = null;
        size--;
        return data;
    }

    @Override
    public AnyType top() {
        if (isEmpty()) {
            throw new RuntimeException("The stack is empty.");
        }
        AnyType data = top.data;
        return data;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    private class Node<E> {
        private Node<E> pre;
        private Node<E> next;
        E data;

        public Node(Node<E> pre, Node<E> next, E data) {
            this.pre = pre;
            this.next = next;
            this.data = data;
        }
    }
}

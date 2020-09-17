package web.services.learn.lessons;

/**
 * 基于数组实现栈，要求可以自动扩容，自己编写的代码，不一定对。
 */
public class ArrayStack<E> {

    private E[] items;
    private int head = -1;
    private int size;

    public ArrayStack() {
        items = (E[]) new Object[4];
    }

    public void push(E e) {
        if (isFull()) {
            E[] oldItems = items;
            int length = oldItems.length;
            items = (E[]) new Object[length * 2];
            for (int i = 0; i < length; i++) {
                items[i] = oldItems[i];
            }
        }
        System.out.println("Current capacity of the stack is: "+items.length);
        head++;
        size++;
        items[head] = e;
    }

    public E pop() {
        if (head == -1) {
            throw new RuntimeException("The stack is empty.");
        }
        E e = items[head];
        items[head] = null;
        head--;
        size--;
        return e;
    }

    public E top() {
        if (head == -1) {
            throw new RuntimeException("The stack is empty.");
        }
        return items[head];
    }

    private boolean isFull() {
        return head == items.length - 1;
    }

    public int size() {
        return size;
    }
}

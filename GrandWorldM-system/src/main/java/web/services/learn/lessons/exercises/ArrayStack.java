package web.services.learn.lessons.exercises;

/**
 * 基于数组实现栈，要求可以自动扩容。
 */
public class ArrayStack<E> {

    private E[] items;
    private int head = -1;

    public ArrayStack(int capacity) {
        items = (E[]) new Object[capacity];
    }

    public void push(E e) {
        if (isFull()) {
            E[] oldItems = items;
            items = (E[]) new Object[oldItems.length * 2 + 1];
            for (int i = 0; i < oldItems.length; i++) {
                items[i] = oldItems[i];
            }
        }
        head++;
        items[head] = e;
    }

    public E pop() {
        if (head == -1) {
            throw new RuntimeException("The stack is empty.");
        }
        E e = items[head];
        items[head] = null;
        head--;
        return e;
    }

    public E top(){
        if (head == -1) {
            throw new RuntimeException("The stack is empty.");
        }
        return items[head];
    }

    private boolean isFull() {
        return head == items.length - 1;
    }
}

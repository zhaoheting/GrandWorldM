package web.services.learn.lessons.exercises;

/**
 * 基于数组实现的环形队列。
 *
 * @param <AnyType>
 */
public class CircularArrayQueue<AnyType> implements MyQueue<AnyType> {

    //final属性的引用只能指向一个地址,当它第一次被赋值后，便不可在指向其他地址；
    private final AnyType[] items;
    private int head;
    private int tail = 0;
    private int size;
    private final int capacity;//常量。

    public CircularArrayQueue(int capacity) {
        this.capacity = capacity;
        items = (AnyType[]) new Object[capacity];//如果将items指向其他数组则会报错。
    }

    @Override
    public void enqueue(AnyType anyType) {
        if (isFull()) {
            throw new RuntimeException("The queue is full, new element can't be enqueued.");
        }
        if (tail == capacity) {
            tail = 0;
        }
        items[tail++] = anyType;
        size++;
    }

    @Override
    public AnyType dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty, no element can't be dequeued.");
        }
        if (head == capacity) {
            head = 0;
        }
        size--;
        return items[head++];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }
}

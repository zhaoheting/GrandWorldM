package web.services.learn.lessons.exercises;

/**
 * 因为栈的入栈和出栈操作都是针对一个位置（栈顶）进行的，所以其只需要一个栈顶的哨兵节点即可。
 * 而队列的入队和出队操作是分别操纵头和尾，所以要两个哨兵节点来个字处理。
 *
 * @param <AnyType>
 */
public class ArrayQueue<AnyType> {

    private AnyType[] items;
    private int size;
    private int head = 0;
    private int tail = -1;
    private int capacity;

    /**
     * 队列最大容量手动指定，不可以让它动态扩容，否则排队等候时间无限增长。
     *
     * @param capacity
     */
    public ArrayQueue(int capacity) {
        this.items = (AnyType[]) new Object[capacity];
        this.capacity = capacity;
    }

    private boolean isFull() {
        return this.capacity == tail + 1;
    }

    private boolean isEmpty() {
        return head == tail + 1;
    }

    public boolean enqueue(AnyType element) {
        if (isFull()) {
            //整个队列都站满了。
            if (head == 0) {
                throw new RuntimeException("The queue is full, new element can't be enqueued.");
            }
            //队列前面有空位置，数据整体前移。
            for (int i = head; i <= tail; i++) {
                items[i - head] = items[i];
                items[i] = null;
            }
            tail = tail - head;
            head = 0;
        }
        this.items[++tail] = element;
        return true;
    }

    public int size() {
        size = tail - head + 1;
        return size;
    }

    public AnyType dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty, no element can't be dequeued.");
        }
        return items[head++];
    }
}

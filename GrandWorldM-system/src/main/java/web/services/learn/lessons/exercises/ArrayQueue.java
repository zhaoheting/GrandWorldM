package web.services.learn.lessons.exercises;

import java.util.Objects;

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
    private int tail = 0;
    private int capacity;

    /**
     * 队列最大容量手动指定，不可以让它动态扩容，否则排队等候时间无限增长。
     *
     * @param capacity
     */
    public ArrayQueue(int capacity) {
        this.items = (AnyType[]) new Objects[capacity];
        this.capacity = capacity;
    }

    private boolean isFull() {
        return this.capacity == tail;
    }

    private boolean isEmpty() {
        return head == tail;
    }

    public boolean enqueue(AnyType element) {
        if (isFull()) {
//            AnyType[] oldItems = this.items;
//            this.items = (AnyType[]) new Objects[oldItems.length * 2];
//            for (int i = 0, length = oldItems.length; i < length; i++) {
//                this.items[i] = oldItems[i];
//            }
            //整个队列都站满了。
            if(head == 0){
                return false;
            }
            //否则数据整体前移。

        }
        if (isEmpty()) {
            head++;
        }
        tail++;
        this.items[tail] = element;
    }

    public void dequeue() {

    }
}

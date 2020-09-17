package web.services.learn.lessons;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 线程安全的无锁队列。基于CAS实现。
 * 网上学到的代码，不一定对，后期完善。
 */
public class LockFreeThreadSafeQueue<AnyType> implements MyQueue<AnyType> {

    private AtomicReference<Node<AnyType>> head;
    private AtomicReference<Node<AnyType>> tail;
    private AtomicInteger size = new AtomicInteger(0);

    /**
     * Constructor.
     * 整个队列只需要有一个标记节点即可。
     */
    public LockFreeThreadSafeQueue() {
        Node<AnyType> newNode = new Node<>(null);
        this.head = new AtomicReference<>(newNode);
        this.tail = new AtomicReference<>(newNode);
    }

    @Override
    public void enqueue(AnyType anyType) {
        Node<AnyType> newNode = new Node<>(anyType);
        /**
         * 如果不定义标记节点，则需要对tail是否为空进行判断。并且在tail为空时，不能使用atomic方法
         */
        Node<AnyType> oldNode = tail.getAndSet(newNode);
        oldNode.next = newNode;
        size.incrementAndGet();
    }

    /**
     * 该方法每次被调用时，改变的是head节点的next的指向，而head永远不变，始终指向一个没有存值的节点。
     *
     * @return
     */
    @Override
    public AnyType dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty.");
        }
        Node<AnyType> headNode, currentNode;
        headNode = head.get();
        AtomicReference<Node<AnyType>> current;
        /**
         * 如果不定义标记节点，则需要对head是否为空进行判断,并且在head为空时，不能使用atomic方法
         */
        do {
            currentNode = headNode.next;
            current = new AtomicReference<>(currentNode);
            //当currentHead不等于队列的head节点时，代表该元素被别的线程拿走的，需要重新获取。
            //当currentHead等于队列的head时，则代表头元素没有被其他元素拿走，并将head节点替换为currentHead.next。
        } while (currentNode != null && !current.compareAndSet(currentNode, currentNode.next));
        AnyType element = currentNode.element;
        currentNode.element = null;
        size.decrementAndGet();//在不需要返回值时，调用decrementAndGet或者getAndDecrement()都一样。
        return element;
    }

    @Override
    public int size() {
        return size.get();
    }

    @Override

    public boolean isEmpty() {
        return size.get() == 0;
    }

    private class Node<E> {

        private E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
        }

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}

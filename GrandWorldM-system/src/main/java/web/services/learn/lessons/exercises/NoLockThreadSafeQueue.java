package web.services.learn.lessons.exercises;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 线程安全的无锁队列。基于CAS实现。
 */
public class NoLockThreadSafeQueue<AnyType> implements MyQueue<AnyType> {

    private AtomicReference<AnyType> head;
    private AtomicReference<AnyType> tail;
    private AtomicInteger size;

    @Override
    public void enqueue(AnyType anyType) {

    }

    @Override
    public AnyType dequeue() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private class Node<E>{

        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}

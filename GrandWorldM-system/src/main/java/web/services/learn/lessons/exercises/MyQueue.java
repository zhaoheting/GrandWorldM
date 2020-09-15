package web.services.learn.lessons.exercises;

public interface MyQueue<E> {

    public void enqueue(E e);

    public E dequeue();

    public int size();

    public boolean isEmpty();
}

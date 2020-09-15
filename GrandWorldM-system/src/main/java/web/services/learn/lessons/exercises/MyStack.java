package web.services.learn.lessons.exercises;

public interface MyStack<E> {
    public void push(E e);

    public E pop();

    public E top();

    public int size();

    public boolean isEmpty();
}

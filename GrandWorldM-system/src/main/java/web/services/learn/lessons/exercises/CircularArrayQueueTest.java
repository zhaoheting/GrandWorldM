package web.services.learn.lessons.exercises;

public class CircularArrayQueueTest {
    public static void main(String[] args) {
        CircularArrayQueue<String> queue = new CircularArrayQueue<>(4);
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.dequeue();
        queue.enqueue("e");
        while (queue.size() > 0) {
            System.out.println(queue.dequeue());
        }
    }
}

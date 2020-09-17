package web.services.learn.lessons;

public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue<String> stringQueue = new ArrayQueue<>(4);
        stringQueue.enqueue("a");
        stringQueue.enqueue("b");
        stringQueue.enqueue("c");
        stringQueue.enqueue("d");
        System.out.println(stringQueue.size());
        System.out.println(stringQueue.dequeue());
        System.out.println(stringQueue.size());
        stringQueue.enqueue("e");
        stringQueue.enqueue("y");
        while (stringQueue.size() > 0) {
            System.out.println(stringQueue.dequeue());
        }
    }
}

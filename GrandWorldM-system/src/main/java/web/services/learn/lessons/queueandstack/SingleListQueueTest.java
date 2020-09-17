package web.services.learn.lessons.queueandstack;

public class SingleListQueueTest {
    public static void main(String[] args) {
        SingleListQueue<String> stringQueue = new SingleListQueue<>();
        stringQueue.enqueue("a");
        stringQueue.enqueue("b");
        stringQueue.enqueue("c");
        stringQueue.enqueue("d");
        while (stringQueue.size() > 0) {
            System.out.println(stringQueue.dequeue());
        }
    }
}

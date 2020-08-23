package web.services.learn.chapter.one;

public class LinkedStack<T> {

    /**
     * End sentinel.
     */
    private Node<T> top = new Node<>();

    static class Node<T> {

        private T data;
        private Node<T> next;

        public Node() {
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private boolean isEnd() {
        return top.data == null && top.next == null;
    }

    public T pop() {
        Node<T> current = top;
        //If without this judgement, null point exception will occur in the 57th line,
        // because the end sentinel is removed.
        if (!isEnd()) {
            top = top.next;
        }
        //If top is the end sentinel, then return a null. There is nothing of the track.
        return current.data;
    }

    public void push(T t) {
        top = new Node<>(t, top);
    }

    public static void main(String[] args) {
        LinkedStack<String> stringLinkedStack = new LinkedStack<>();
        for (String s : "This is a test.".split(" ")) {
            stringLinkedStack.push(s);
        }
        String r;
        while ((r = stringLinkedStack.pop()) != null) {
            System.out.println(r);
        }

        for (String s : "wo cao niu bi.".split(" ")) {
            stringLinkedStack.push(s);
        }

        String r2;
        while ((r2 = stringLinkedStack.pop()) != null) {
            System.out.println(r2);
        }
    }
}

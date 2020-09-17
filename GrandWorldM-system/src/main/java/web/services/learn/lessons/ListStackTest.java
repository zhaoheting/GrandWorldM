package web.services.learn.lessons;

public class ListStackTest {
    public static void main(String[] args) {
        ListStack<String> stringStack = new ListStack<>();
        stringStack.push("a");
        stringStack.push("b");
        stringStack.push("c");
        stringStack.push("d");
        stringStack.push("e");
        while (stringStack.size() > 0) {
            System.out.println(stringStack.pop());
        }
    }
}

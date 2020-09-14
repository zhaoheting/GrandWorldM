package web.services.learn.lessons.exercises;

public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack<String> stringStack = new ArrayStack<>();
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

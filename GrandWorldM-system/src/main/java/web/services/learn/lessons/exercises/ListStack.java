package web.services.learn.lessons.exercises;

import org.omg.CORBA.Any;

import java.util.LinkedList;
import java.util.List;

/**
 * 基于LinkedList实现栈，自己编写的代码。
 */
public class ListStack<AnyType> {

    List<AnyType> items;
    private int head = -1;

    public ListStack() {
        items = new LinkedList<>();
    }

    public void push(AnyType element) {
        items.add(element);
        head++;
    }

    public AnyType pop() {
        AnyType currentElement = items.remove(head);
        head--;
        return currentElement;
    }

    public int size(){
        return items.size();
    }

    public AnyType top() {
        return items.get(head);
    }
}

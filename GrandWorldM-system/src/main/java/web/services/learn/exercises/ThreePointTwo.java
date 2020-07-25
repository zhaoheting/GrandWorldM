package web.services.learn.exercises;

import web.services.learn.MyLinkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * ii: Swap two adjacent cells using two linked lists.
 */
public class ThreePointTwo<E> extends MyLinkedList {

    public static void main(String[] args) {

        ThreePointTwo<Integer> tpt = new ThreePointTwo<>();
        tpt.add(3);
        tpt.add(5);
        tpt.add(7);
        Node node = tpt.getNode(0);
        tpt.swapWithBefore(node);
        Iterator iterator = tpt.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());

        }
    }

    private void swapWithBefore(Node beforeP) {
        Node p = beforeP.next;
        Node afterP = p.next;
        Node afterPNext = afterP.next;
        if (afterPNext != null) {
            p.next = afterPNext;
            afterP.next.previous = p;
        } else {
            p.next = null;
        }
        beforeP.next = afterP;
        afterP.next = p;
        afterP.previous = beforeP;
        p.previous = afterP;
    }
}

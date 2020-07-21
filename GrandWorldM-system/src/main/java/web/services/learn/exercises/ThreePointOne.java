package web.services.learn.exercises;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 3.1
 */
public class ThreePointOne<E> {

    /**
     * You may only use the public collections API container operations.
     *
     * @param elementList
     * @param positionList It is sorted in ascending order as a precondition.
     */
    private void printLots(List<E> elementList, List<Integer> positionList) {
        Iterator<E> elementIterator = elementList.iterator();
        Iterator<Integer> positionIterator = positionList.iterator();
        int currentIndex = 0;
        while (positionIterator.hasNext()) {
            Integer position = positionIterator.next();
            E element = null;
            //Position is not the index.It starts with 1 not 0.
            while (currentIndex < position && elementIterator.hasNext()) {
                currentIndex++;
                element = elementIterator.next();
            }
            if (currentIndex == position) {//In case of the while loop is interrupted when the position is beyond the size of the element list.
                System.out.println("Looking for position: " + position);
                System.out.println(element);
            }

        }
    }

    public static void main(String[] args) {
        List<Integer> elementList = new ArrayList<>();
        elementList.add(10);
        elementList.add(11);
        elementList.add(12);
        elementList.add(13);
        elementList.add(14);
        elementList.add(15);
        elementList.add(26);
        List<Integer> positionList = new ArrayList<>();
        positionList.add(1);
        positionList.add(16);
        new ThreePointOne<Integer>().printLots(elementList, positionList);
    }
}

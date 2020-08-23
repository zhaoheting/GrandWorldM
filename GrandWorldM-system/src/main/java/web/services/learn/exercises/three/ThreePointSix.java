package web.services.learn.exercises.three;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Josephus problem.
 */
public class ThreePointSix {

    public static void main(String[] args) {
        new ThreePointSix().josephus(1, 5);
    }

    private void josephus(int m, int n) {
        List<Integer> personList = new LinkedList();
        for (int i = 1; i <= n; i++) {
            personList.add(i);
        }
        int j = -1;
        while (personList.size() != 1) {
            Iterator<Integer> iterator = personList.iterator();
            while (iterator.hasNext()) {
                Integer current = iterator.next();
                j++;
                if (j == m && personList.size() != 1) {
                    System.out.println("Remove: " + current);
                    iterator.remove();
                    j = -1;
                }
            }
        }
        for (Integer i : personList) {
            System.out.println("The last one is: " + i);
        }
    }
}

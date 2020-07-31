package web.services.learn.exercises.three;

import web.services.learn.exercises.three.entity.Student;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Union two lists that are in ascending order.
 */
public class ThreePointFive {

    public static void main(String[] args) {
        List<Student> list1 = new LinkedList<>();
        Student s1 = new Student();
        s1.setId(1);
        list1.add(s1);
        Student s2 = new Student();
        s2.setId(3);
        list1.add(s2);
        Student s3 = new Student();
        s3.setId(9);
        list1.add(s3);
        Student s4 = new Student();
        s4.setId(19);
        list1.add(s4);
        List<Student> list2 = new LinkedList<>();
        Student s21 = new Student();
        s21.setId(3);
        list2.add(s21);
        Student s22 = new Student();
        s22.setId(5);
        list2.add(s22);
        Student s23 = new Student();
        s23.setId(9);
        list2.add(s23);
        Student s24 = new Student();
        s24.setId(10);
        list2.add(s24);
        List<Student> result = new ThreePointFive().union(list1, list2);
        for (Student student : result) {
            System.out.println(student.getId());
        }
    }

    /**
     * The content of these two lists is in ascending order.
     *
     * @param list1
     * @param list2
     * @param <Student>
     * @return
     */
    private <Student extends Comparable<? super Student>> List<Student> union(List<Student> list1,
                                                                              List<Student> list2) {
        List<Student> resultList = new LinkedList<>();
        Iterator<Student> iterator1 = list1.iterator();
        Iterator<Student> iterator2 = list2.iterator();
        if (iterator1.hasNext() && iterator2.hasNext()) {
            Student s1 = iterator1.next();
            Student s2 = iterator2.next();
            while (s1 != null && s2 != null) {
                int compareResult = s1.compareTo(s2);
                if (compareResult == 0) {
                    resultList.add(s1);
                    s1 = iterator1.hasNext() ? iterator1.next() : null;
                    s2 = iterator2.hasNext() ? iterator2.next() : null;
                } else if (compareResult > 0) {
                    resultList.add(s2);
                    s2 = iterator2.hasNext() ? iterator2.next() : null;
                } else {
                    resultList.add(s1);
                    s1 = iterator1.hasNext() ? iterator1.next() : null;
                }
                if (s1 == null && s2 != null) {
                    resultList.add(s2);
                    while (iterator2.hasNext()) {
                        resultList.add(iterator2.next());
                    }
                }
                if (s1 != null && s2 == null) {
                    resultList.add(s1);
                    while (iterator1.hasNext()) {
                        resultList.add(iterator1.next());
                    }
                }
            }
        }
        return resultList;
    }
}

package web.stream;


import java.util.Comparator;

public class MyComparator implements Comparator<ZhtPerson> {

    public MyComparator() {
    }

    @Override
    public int compare(ZhtPerson o1, ZhtPerson o2) {
        return o1.age-o2.age;
    }
}

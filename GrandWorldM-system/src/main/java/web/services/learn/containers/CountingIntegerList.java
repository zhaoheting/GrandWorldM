package web.services.learn.containers;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class CountingIntegerList extends AbstractList<Integer> {
    private int size;

    public CountingIntegerList(int size) {
        this.size = size;
    }

    @Override
    public Integer get(int index) {
        return Integer.valueOf(index);
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("sss");
        System.out.println(list);
    }
}

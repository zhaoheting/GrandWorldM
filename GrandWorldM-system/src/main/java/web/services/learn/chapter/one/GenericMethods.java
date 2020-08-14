package web.services.learn.chapter.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class GenericMethods {

    public static void main(String[] args)
    {
        List<Integer> intList = new ArrayList<>();
        intList.add(20);
        intList.add(3);
        intList.add(5);

        // 泛型通配符，此处的本质就是泛型协变
        List list = intList;  // ①
        // list是List类型，因此可以添加String类型的元素
        list.add(3);    // ②

    }
}

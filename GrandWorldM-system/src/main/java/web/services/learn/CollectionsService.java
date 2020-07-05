package web.services.learn;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CollectionsService {

    public static void main(String[] args){
        List<String> stringList = new LinkedList<>();
        stringList.add("aaa1");
        stringList.add("aaa2");
        stringList.add("aaa3");
        stringList.add("aaa4");
        stringList.add("aaa5");
        stringList.get(4);
        Iterator iterator = stringList.iterator();
        System.out.println("iterator");
        stringList.parallelStream();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
        }
        System.out.println("foreach:");
        for (String string : stringList) {
            System.out.println(string);
        }

    }

    public void removeElementEveryTwo() {

    }
}

package web.stream;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class StreamLearn {
    public static void main(String[] args) {


        List<Double> numberList = Arrays.asList(3.5, 5.4, 7.6);
        DoubleSummaryStatistics doubleSummaryStatistics = numberList.parallelStream()
                .mapToDouble(x -> x)
                .summaryStatistics();
//        System.out.println(doubleSummaryStatistics.getAverage());

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
//        System.out.println("列表: " + strings);
        List<String> result2 = strings.stream().filter(x -> x.length() == 3).collect(Collectors.toList());
        System.out.println(result2);

        List<Integer> numbers = Arrays.asList(6, 2, 2, 3, 7, 3, 1);
        TreeSet<Integer> result3 = numbers.stream()
                .distinct()
                .sorted((x, y) -> y - x)
                .collect(Collectors.toCollection(TreeSet::new));
//        System.out.println(result3);
        List<ZhtPerson> list = new ArrayList<>();

        list.add(new ZhtPerson("aaa", 16));
        list.add(new ZhtPerson("bbb", 26));
        list.add(new ZhtPerson("ccc", 10));
        list.add(new ZhtPerson("ddd", 36));
        List<String> result = list.stream()
                .sorted(Comparator.comparing(ZhtPerson::getAge))
                .map(x -> x.username)
                .collect(Collectors.toList());
//        System.out.println(result);

        String person2 = Optional.of(new ZhtPerson("", 18))
                .map(ZhtPerson::getUsername).orElse("");

//        String person3 = Optional.of(new ZhtPerson("", 18))
//                .flatMap(ZhtPerson::getAddress).map(Address::getAddressDetail).orElse("");

//        Optional<Address> addressOptional = Optional.empty();
        Address address1 = new Address();
        Optional<Address> addressOptional1 = Optional.ofNullable(address1);
        addressOptional1.ifPresent(System.out::println);
        String[] strings1 = {"eee","ttt","sss"};

        try {
            Method method = StreamLearn.class.getMethod("main",String[].class);
            for (final Parameter parameter : method.getParameters()){
                System.out.println(parameter.getName());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }

    private void testComparator(String[] args) {
        List<ZhtPerson> list = new ArrayList<>();

        list.add(new ZhtPerson("aaa", 16));
        list.add(new ZhtPerson("bbb", 26));
        list.add(new ZhtPerson("ccc", 10));
        list.add(new ZhtPerson("ddd", 36));
        List<String> result = list.stream()
                .sorted(Comparator.comparing(ZhtPerson::getAge))
                .map(x -> x.username)
                .collect(Collectors.toList());
        System.out.println(result);
    }
}

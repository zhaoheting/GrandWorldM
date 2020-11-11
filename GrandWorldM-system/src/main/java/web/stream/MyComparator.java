package web.stream;


import io.swagger.models.auth.In;

@FunctionalInterface
public interface MyComparator<E> {

    Integer compare(E o1, E o2);
}

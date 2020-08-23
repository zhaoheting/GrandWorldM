package web.services.learn.chapter.one;

public class RestrictionsOnGenerics<T> {

    private static int i=10;
    private Object getT(){
        return new Object();
    }

    public static void main(String[] args) {
        RestrictionsOnGenerics r1 = new RestrictionsOnGenerics();
        System.out.println(i);
        System.out.println(++r1.i);
        RestrictionsOnGenerics r2 = new RestrictionsOnGenerics();
        System.out.println(++r2.i);
        String[] strings = new String[4];
        Object[] os= strings;
        String[] ss = (String[])os;
    }
}

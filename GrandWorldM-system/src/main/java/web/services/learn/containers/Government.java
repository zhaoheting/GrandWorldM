package web.services.learn.containers;

public class Government implements Generator<String> {

    String[] foundation = ("A brush with death tends to make one " +
            "cherish the renewed life all the more").split(" ");

    private int index = 0;
    @Override
    public String next() {
        if(index == foundation.length){
            index = 0;
        }
        return foundation[index++];
    }
}

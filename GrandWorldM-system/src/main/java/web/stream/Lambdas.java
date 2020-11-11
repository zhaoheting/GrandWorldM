package web.stream;

public class Lambdas {
    public Runnable r = () -> System.out.println(this);

    public static void main(String[] args) {
        StringBuilder message = new StringBuilder("");
        message.append("cv");
        message = new StringBuilder("g");
        Runnable r = () -> System.out.println(message);
        r.run();
    }

    public String toString() {
        return "Hello's custom toString()";
    }
}



package web.services.learn.chapter.two;

/**
 * 欧几里德算法求最大公约数。
 */
public class CalculateGcd {

    private long gcd(long m, long n) {
        while (n != 0) {
            long mod = m % n;
            m = n;
            n = mod;
        }
        return m;
    }

    public static void main(String[] args) {
        CalculateGcd calculationGcd = new CalculateGcd();
        System.out.println(calculationGcd.gcd(33,95));
    }
}
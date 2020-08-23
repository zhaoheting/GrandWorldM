package web.services.learn.chapter.two;

import java.math.BigInteger;

/**
 * 求幂,时间复杂度为O(logN)
 */
public class CalculatePower {

    /**
     * 判断是否是偶数。
     *
     * @param n
     * @return
     */
    private boolean isEven(int n) {
        return n % 2 == 0;
    }

    /**
     * 递归求幂
     * long型只能放8个字节，而BigInteger能放无限
     *
     * @param x
     * @param n
     * @return
     */
    private BigInteger pow(BigInteger x, int n) {
        if (n == 0) {
            return new BigInteger("1");
        } else if (n == 1) {
            return x;
        } else {
            BigInteger selfMultiply = new BigInteger(x.toString()).multiply(new BigInteger(x.toString()));
            if (isEven(n)) {//偶数
                return pow(selfMultiply, n / 2);
            } else {
                //This line can be replaced by "pow(x,n-1)*x;",but the time complexity of algorithm
                //will rise to N;
                return pow(selfMultiply, n / 2).multiply(new BigInteger(x.toString()));
            }
        }
    }

    public static void main(String[] args) {
        CalculatePower calculatePower = new CalculatePower();
        System.out.println(calculatePower.pow(new BigInteger("2"), 6));
    }
}

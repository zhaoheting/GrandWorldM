package web.services.learn.chapter.two;

/**
 * 联机算法求子序列最大和。
 */
public class CalculateMaxSubSum {

    /**
     * 如果输入序列元素全是负数，那么返回值会是0；所以考虑这个方法在这种情况下不实用，下面有个优化的方法可处理全是负数的情况。
     *
     * @param a
     * @return
     */
    public int maxSubSum(int[] a) {
        int max = 0;
        int currentSum = 0;
        for (int i = 0; i < a.length; i++) {
            currentSum += a[i];
            if (currentSum > max) {
                max = currentSum;
            } else if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return max;
    }

    /**
     * 优化后，数组可以全是负数
     *
     * @param a
     * @return
     */
    public int maxSubSum2(int[] a) {
        int max = a[0];
        int currentSum = 0;
        for (int i = 0; i < a.length; i++) {
            currentSum += a[i];
            if (currentSum > max) {
                max = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        CalculateMaxSubSum calculateMaxSubSum = new CalculateMaxSubSum();
        int[] a = {-2, -1, -3, -2};
        int max = calculateMaxSubSum.maxSubSum2(a);
        System.out.println(max);
    }
}

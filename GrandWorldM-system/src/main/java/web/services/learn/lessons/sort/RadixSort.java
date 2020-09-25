package web.services.learn.lessons.sort;

/**
 * 基数排序。与计数排序很相似。
 */
public class RadixSort {

    /**
     * Just deal with three digits.
     *
     * @param a
     */
    private static void sort(int[] a, int maxDigits) {
        for (int j = 1; j <= maxDigits; j++) {
            int[] c = new int[10];
            // clear the array C.
            for (int m = 0; m < a.length; m++) {
                c[m] = 0;
            }
            //逐个求出数组a中，每个数的当前第j位上的数分别为0~9的数的个数，作为value放入数组c中
            for (int i = 0; i < a.length; i++) {
                int index = getFigure(a[i], j);
                c[index]++;
            }
            for (int n = 1; n < 10; n++) {
                c[n] = c[n] + c[n - 1];
            }
            int[] r = new int[a.length];
            //Traverse every element of A from the end, and put them into the correct position of R according to the content of array C.
            for (int q = a.length - 1; q >= 0; q--) {
                int currentValue = a[q];
                int valueInDigit = getFigure(currentValue, j);
                --c[valueInDigit];
                int indexR = c[valueInDigit];
                r[indexR] = currentValue;
            }
            for (int p = 0; p < r.length; p++) {
                a[p] = r[p];
            }
        }
    }

    /**
     * The Kth digit, counting from right of the element, will be returned.
     *
     * @param element
     * @param k
     * @return
     */
    private static int getFigure(int element, int k) {
        int multi = 1;
        for (int i = 0; i < k - 1; i++) {
            multi *= 10;
        }
        return (element / multi) % 10;
    }

    public static void main(String[] args) {
        int[] a = new int[]{59, 3, 66, 32, 456, 4, 36, 9};
        sort(a, 3);
        for (int n : a) {
            System.out.println(n);
        }
    }
}

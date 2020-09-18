package web.services.learn.lessons.sort;

/**
 * Insertion sort.
 */
public class InsertionSort {

    /**
     * 我写的破代码，从前面比较，后面移动，导致3次循环。
     *
     * @param a
     */
    private static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (a[i] < a[j]) {
                    int m = a[i];
                    for (int k = i; k > j; k--) {
                        a[k] = a[k - 1];
                    }
                    a[j] = m;
                }
            }
        }
    }

    /**
     * 极客时间上的代码。
     *
     * @param a
     */
    private static void sort2(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int current = a[i];
            int j = i - 1;
            /**
             * for循环括号中，j--和--j的执行结果一样。但是j--需要申请一个变量来存放j的值，所以j--多占用内存。
             */
            for (; j >= 0; --j) {
                if (current < a[j]) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 6, 4, 2, 1};
        sort2(a);
        for (int n : a) {
            System.out.println(n);
        }
    }
}

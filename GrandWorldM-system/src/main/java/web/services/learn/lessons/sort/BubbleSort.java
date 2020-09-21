package web.services.learn.lessons.sort;

/**
 * 冒泡排序。
 */
public class BubbleSort {

    private static void sort(int[] a) {
        for (int i = 1, length = a.length; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (a[j] > a[j + 1]) {
                    int mid = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = mid;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{6, 4, 7, 3, 2, 34};
        //传入方法的参数只要是地址，那么方法执行完后，数据的更新会一直存在。如果是基本数据类型，那么就不会
        sort(a);
        for (int n : a) {
            System.out.println(n);
        }
    }
}
package web.services.learn.lessons.sort;

/**
 * 选择排序不是稳定的排序算法。
 */
public class SelectionSort {

    private static void sort(int[] a) {
        int length = a.length;
        for (int j = 0; j < length; j++) {
            int min = a[j];
            int index = j;
            for (int i = j + 1; i < length; i++) {
                if (min > a[i]) {
                    min = a[i];
                    index = i;
                }
            }
            a[index] = a[j];
            a[j] = min;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 6, 4, 2, 1};
        sort(a);
        for (int n : a) {
            System.out.println(n);
        }
    }
}

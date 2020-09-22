package web.services.learn.lessons.sort;

/*
 *希尔排序
 */
public class ShellSort {

    private static void sort(int[] a) {
        int length = a.length;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                int temp = a[i];
                int j = i - step;
                while (j >= 0 && temp < a[j]) {
                    a[j + step] = a[j];
                    j -= step;
                }
                a[j + step] = temp;
            }
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
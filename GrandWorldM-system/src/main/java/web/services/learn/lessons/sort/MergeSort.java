package web.services.learn.lessons.sort;

import io.swagger.models.auth.In;

/**
 * 归并排序。
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 6, 7, 2, 4, 9, 1};
        sort(a);
        for (int n : a) {
            System.out.println(n);
        }
    }

    private static void sort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (end + start) / 2;
        mergeSort(a, start, mid);
        mergeSort(a, mid + 1, end);
        //当start和end之间只有两个元素时，调用combine函数就直接比较出了大小顺序。所以真正的排序发生在combine函数中。
        combineSentinel(a, start, mid, end);
    }

    /**
     * Combine sorted array left and right into a.
     */
    private static void combine(int[] a, int start, int mid, int end) {
        //将start到end之间的元素拆分到两个数组中。
        int[] left = new int[mid - start + 1];
        int[] right = new int[end - mid];
        for (int i = 0; i < mid - start + 1; i++) {
            left[i] = a[start + i];
        }
        for (int j = 0; j < end - mid; j++) {
            right[j] = a[mid + j + 1];
        }
        //将拆分的两个数组中的元素按照大小放入a中。
        int m = 0, n = 0, t = start;
        while (m < mid - start + 1 && n < end - mid) {
            if (left[m] < right[n]) {
                a[t++] = left[m++];
            } else {
                a[t++] = right[n++];
            }
        }
        //若其中一个数组的元素已经被全部放入a中，则另外一个数组中的元素一次性取出。
        if (m == mid - start + 1) {
            for (int d = n; d < end - mid; d++) {
                a[t++] = right[d];
            }
        } else {
            for (int d = m; d < mid - start + 1; d++) {
                a[t++] = left[d];
            }
        }
    }

    private static void combineSentinel(int[] a, int start, int mid, int end){
        //将start到end之间的元素拆分到两个数组中。
        int[] left = new int[mid - start + 2];
        int[] right = new int[end - mid+1];
        for (int i = 0; i < mid - start + 1; i++) {
            left[i] = a[start + i];
        }
        for (int j = 0; j < end - mid; j++) {
            right[j] = a[mid + j + 1];
        }
        left[left.length-1]= Integer.MAX_VALUE;
        right[right.length-1] = Integer.MAX_VALUE;
        //将拆分的两个数组中的元素按照大小放入a中。
        int m = 0, n = 0, t = start;
        while (left[m] != Integer.MAX_VALUE) {
            if (left[m] < right[n]) {
                a[t++] = left[m++];
            } else {
                a[t++] = right[n++];
            }
        }
    }
}

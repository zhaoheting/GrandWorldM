package web.services.learn.lessons.sort;

/**
 * 归并排序，没写出来，有问题
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 6, 7, 2, 4, 9};
        mergeSort(a, 0, a.length - 1);
        for (int n : a) {
            System.out.println(n);
        }
    }

    private static void mergeSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(a, start, mid);
        mergeSort(a, mid + 1, end);
        combine(a, start, end);
    }

    /**
     * Combine sorted array left and right into a.
     */
    private static void combine(int[] a, int start, int end) {
        int length = end - start + 1;
        int mid = start + length / 2;
        int[] left = new int[mid - start + 1];
        int[] right = new int[end - mid];
        for (int i = 0; i < mid - start + 1; i++) {
            left[i] = a[start + i];
        }
        for (int j = 0; j < end - mid; j++) {
            right[j] = a[mid + j + 1];
        }

        int m = 0, n = 0, t = start;
        while (m < mid - start + 1 && n < end - mid) {
            if (left[m] < right[n]) {
                a[t++] = left[m++];
            } else {
                a[t++] = right[n++];
            }
        }
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
}

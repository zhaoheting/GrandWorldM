package web.services.learn.lessons.sort;

/**
 * 归并排序和快速排序的区别：
 * 归并排序先拆再合，合的时候做的比较；
 * 快速排序也是先拆再合，拆的时候比较。
 */
public class QuickSort {

    private static void sort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivotIndex = localPartition(a, start, end);
        quickSort(a, start, pivotIndex - 1);
        quickSort(a, pivotIndex + 1, end);
    }

    /**
     * 原地排序算法，空间复杂度为1。
     * The algorithm is similar with selection sort.The array to be sorted is divided into two parts.
     *
     * @param a
     * @param start
     * @param end
     * @return
     */
    private static int localPartition(int[] a, int start, int end) {
        //Intermedia is an index, all the elements before it are smaller than the pivot,
        // and that after it are larger thant the pivot.
        //The index of the first element that is larger than pivot will be treat as intermedia.
        int pivot = a[end], intermedia = start;
        for (int i = start; i < end; i++) {
            if (a[i] < pivot) {
                int temp = a[i];
                a[i] = a[intermedia];
                a[intermedia] = temp;
                intermedia++;
            }
        }
        a[end] = a[intermedia];
        a[intermedia] = pivot;
        return intermedia;
    }

    /**
     * 非原地排序算法，借助两个新的数组，存放分治的两组数，空间复杂度高。
     *
     * @param a
     * @param start
     * @param end
     * @return
     */
    private static int partition(int[] a, int start, int end) {
        int pivot = a[end];//   /ˈpɪvət/;   private [ˈpraɪvɪt]
        int[] left = new int[end - start];
        int[] right = new int[end - start];
        int m = 0, n = 0;
        for (int i = start; i < end; i++) {
            if (a[i] <= pivot) {
                left[m++] = a[i];
            } else {
                right[n++] = a[i];
            }
        }
        for (int j = 0; j < m; j++) {
            a[j + start] = left[j];
        }
        int newPivot = start + m;
        a[newPivot] = pivot;
        for (int k = 0; k < n; k++) {
            a[start + m + k + 1] = right[k];
        }
        return newPivot;
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 16, 4, 22, 10};
        sort(a);
        for (int n : a) {
            System.out.println(n);
        }
    }
}

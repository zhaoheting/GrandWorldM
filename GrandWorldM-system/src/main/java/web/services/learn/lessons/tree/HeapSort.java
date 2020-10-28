package web.services.learn.lessons.tree;

/**
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {

    }

    /**
     * (1)Create a heap: Traverse from the beginning of the array and
     * then heapify from the bottom to top.
     * (2)Sort like the process of deletion.
     *
     * @param a
     */
    public void sortFromBegin(int[] a) {
        //Build heap.
        for (int i = 1; i < a.length; i++) {
            while ((i - 1) >> 1 > 0 && a[i] > a[(i - 1) >> 1]) {
                int temp = a[i];
                a[i] = a[(i - 1) >> 1];
                a[(i - 1) >> 1] = temp;
                i = (i - 1) >> 1;
            }
        }
        //Sort.
        int n = a.length - 1;
        while (n > 0) {
            int maxVal = a[0];
            a[0] = a[n];
            a[n] = maxVal;
            --n;
            //heapify.
            int k = 0, maxPosition = 0;
            while (true) {
                if (2 * k + 1 <= n && a[k] < a[2 * k + 1]) {
                    maxPosition = 2 * k + 1;
                }
                if (2 * k + 2 <= n && a[maxPosition] < a[2 * k + 2]) {
                    maxPosition = 2 * k + 2;
                }
                if (maxPosition == k) {
                    break;
                }
                int temp = a[k];
                a[k] = a[maxPosition];
                a[maxPosition] = temp;
                k = maxPosition;
            }
        }
    }

    public void sortFromEnd(int[] a) {
        //build heap
        //heapify from top to bottom.
        int n = a.length;
        int i = n >> 1;
        while (i >= 0) {
            int k = i, maxPosition = i;
            while (true) {
                if (k * 2 + 1 <= n && a[k] < a[k * 2 + 1]) {
                    maxPosition = k * 2 + 1;
                }
                if (k * 2 + 2 <= n && a[maxPosition] < a[k * 2 + 2]) {
                    maxPosition = k * 2 + 2;
                }
                if (k == maxPosition) {
                    break;
                }
                int temp = a[k];
                a[k] = a[maxPosition];
                a[maxPosition] = temp;
                k = maxPosition;
            }
            --i;
        }
        //Sort.
        while (n > 0) {
            int maxVal = a[0];
            a[0] = a[n];
            a[n] = maxVal;
            --n;
            //heapify.
            int k = 0, maxPosition = 0;
            while (true) {
                if (2 * k + 1 <= n && a[k] < a[2 * k + 1]) {
                    maxPosition = 2 * k + 1;
                }
                if (2 * k + 2 <= n && a[maxPosition] < a[2 * k + 2]) {
                    maxPosition = 2 * k + 2;
                }
                if (maxPosition == k) {
                    break;
                }
                int temp = a[k];
                a[k] = a[maxPosition];
                a[maxPosition] = temp;
                k = maxPosition;
            }
        }
    }
}

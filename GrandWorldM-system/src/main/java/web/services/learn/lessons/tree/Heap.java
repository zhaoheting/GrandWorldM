package web.services.learn.lessons.tree;

/**
 * 代码未经测试。
 */
public class Heap {
    private int[] origin;
    private int size;

    public Heap(int capacity) {
        origin = new int[capacity];
        this.size = 0;
    }

    public void insert(int x) {
        if (this.size >= origin.length) {
            return;
        }
        //The index starts from 0.
        origin[size++] = x;
        //heapify
        int i = this.size - 1;
        while ((i - 1) >> 1 > 0 && origin[i] > origin[(i - 1) >> 1]) {
            int temp = origin[i];
            origin[i] = origin[(i - 1) >> 1];
            origin[(i - 1) >> 1] = temp;
            i = (i - 1) >> 1;
        }
    }

    public int removeMax() {
        if (this.size == 0) {
            throw new RuntimeException("The heap is null.");
        }
        int removedData = this.origin[0];
        this.origin[0] = this.origin[--this.size];
        //heapify from top to the bottom.
        int maxPosition = 0, i = 0;
        while (true) {
            if (i * 2 + 1 < this.size && origin[i] < origin[i * 2 + 1]) {
                maxPosition = i * 2 + 1;
            }
            if (i * 2 + 2 < this.size && origin[maxPosition] < origin[i * 2 + 2]) {
                maxPosition = i * 2 + 2;
            }
            if (maxPosition == i) {
                break;
            }
            int temp = origin[i];
            origin[i] = origin[maxPosition];
            origin[maxPosition] = temp;
            i = maxPosition;
        }
        return removedData;
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

    public static void main(String[] args) {

    }
}

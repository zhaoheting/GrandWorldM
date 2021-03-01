package web.services.learn.lessons.tree;

/**
 * 代码未经测试。
 */
public class Heap {
    private int[] origin;
    private int size;

    /**
     * Initial a empty heap.
     *
     * @param capacity
     */
    public Heap(int capacity) {
        origin = new int[capacity];
        this.size = 0;
    }

    /**
     * Initial a heap on the basis of a not empty array.
     *
     * @param arr
     */
    public Heap(int[] arr) {
        heapify(arr);
        origin = arr;
        this.size = arr.length;
    }

    //堆化
    private void heapify(int[] arr) {
        downUp(arr);
//        upDown(arr);
    }

    //从下至上
    private void downUp(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < arr.length; ++i) {
            int index = i;
            while (index >= 0) {
                int maxIndex = index;
                if (2 * index + 1 < length && arr[maxIndex] < arr[2 * index + 1]) {
                    maxIndex = 2 * index + 1;
                }
                if (2 * index + 2 < length && arr[maxIndex] < arr[2 * index + 2]) {
                    maxIndex = 2 * index + 2;
                }
                if (maxIndex != index) {
                    //swap
                    int temp = arr[maxIndex];
                    arr[maxIndex] = arr[index];
                    arr[index] = temp;
                }
                index = index - 1 >> 1;
            }
        }
    }

    //从上至下
    private void upDown(int[] arr) {
        int length = arr.length;
        for (int i = length - 1 >> 1; i >= 0; --i) {
            int index = i;
            while (index < length) {
                int maxIndex = index;
                if (2 * index + 1 < length && arr[maxIndex] < arr[2 * index + 1]) {
                    maxIndex = 2 * index + 1;
                    index = maxIndex;
                }
                if (2 * index + 2 < length && arr[maxIndex] < arr[2 * index + 2]) {
                    maxIndex = 2 * index + 2;
                    index = maxIndex;
                }
                if (maxIndex != index) {
                    //swap
                    int temp = arr[maxIndex];
                    arr[maxIndex] = arr[index];
                    arr[index] = temp;
                }
            }
        }
    }

    public int size() {
        return this.size;
    }

    public int getMax() {
        return origin[0];
    }

    public void insert(int x) {
        if (this.size >= origin.length) {
            return;
        }
        //The index starts from 0.
        origin[size++] = x;
        //heapify
        int i = this.size - 1;
        while ((i - 1) >> 1 >= 0 && origin[i] > origin[(i - 1) >> 1]) {
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


}

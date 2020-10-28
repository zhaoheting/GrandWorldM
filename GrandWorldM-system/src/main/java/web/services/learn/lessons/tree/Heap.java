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

    public int size(){
        return this.size;
    }
    public int getMax(){
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


}

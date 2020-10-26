package web.services.learn.lessons.tree;

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
        ++this.size;
        origin[size] = x;
        //heapify
        int i = this.size;
        while (origin[i] > origin[i >> 1]) {
            int temp = origin[i];
            origin[i] = origin[i >> 1];
            origin[i >> 1] = temp;
            i = i >> 1;
        }
    }

    public void removeMax() {
        if (this.size == 0) {
            throw new RuntimeException("The heap is null.");
        }
        this.origin[1] = this.origin[this.size--];
        //heapify from top to the bottom.
        int maxPosition = 1, i = 1;
        while (true) {
            if (i * 2 < this.size && origin[i] < origin[i * 2]) {
                maxPosition = i * 2;
            }
            if (i * 2 + 1 < this.size && origin[maxPosition] < origin[i * 2 + 1]) {
                maxPosition = i * 2 + 1;
            }
            if(maxPosition == i){
                break;
            }
            int temp = origin[i];
            origin[i] = origin[maxPosition];
            origin[maxPosition] = temp;
            i = maxPosition;
        }
    }
}

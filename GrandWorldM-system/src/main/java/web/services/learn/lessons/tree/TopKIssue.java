package web.services.learn.lessons.tree;

import java.util.Random;

/**
 * Print out the top kth larger elements of an array using heap.
 * k is 6.
 */
public class TopKIssue {

    public static void main(String[] args) {
        TopKIssue topKIssue = new TopKIssue();
        int[] a = new int[10];
        Random random = new Random(10);
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(10);
        }
        for (int j = 0; j < a.length; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println();
        topKIssue.printTopK(a,6);
    }

    /**
     * static array.
     *
     * @param a
     */
    public void printTopK(int[] a, int k) {
        if (k > a.length) {
            throw new RuntimeException("There are not so many data in total.");
        }
        Heap heap = new Heap(k);
        for (int i = 0; i < k; i++) {
            heap.insert(a[i]);
        }
        for (int j = k; j < a.length; j++) {
            if (heap.getMax() < a[j]) {
                heap.removeMax();
                heap.insert(a[j]);
            }
        }
        for (int m = 1; m <= heap.size(); k++) {
            System.out.print(heap.removeMax() + " ");
        }
    }

    /**
     * Dynamic array.
     *
     * @param a
     */
    public void printTopKForDynamicData(int[] a) {

    }
}

package web.services.learn.lessons.sort;

import web.services.learn.lessons.tree.Heap;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Build a big top heap to sort array in ascending order.
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 9, 11, 8, 15, 7, 12};
        Heap heap = new Heap(arr);
        StringJoiner stringJoiner = new StringJoiner(" ");
        Arrays.stream(arr).forEach(c -> stringJoiner.add(String.valueOf(c)));
        System.out.println(stringJoiner);
        for (int i = heap.size() - 1; i >= 0; --i) {
            int currentMax = heap.removeMax();
            arr[i] = currentMax;
        }
        StringJoiner stringJoiner2 = new StringJoiner(" ");
        Arrays.stream(arr).forEach(c -> stringJoiner2.add(String.valueOf(c)));
        System.out.println(stringJoiner2);
    }
}

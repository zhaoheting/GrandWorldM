package web.services.learn.lessons;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,2,4,6,8};
        smallestK(arr,4);

    }

    static Comparator<Integer> cmp = (e1, e2) -> e2 - e1;

    public static int[] smallestK(int[] arr, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k, cmp);
        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);
        }
        int length = arr.length;
        for (int j = k; j < length; ++j) {
            if (queue.peek() > arr[k]) {
                queue.poll();
                queue.offer(arr[j]);
            }
        }
        return queue.stream().mapToInt(Integer::intValue).toArray();
    }
}

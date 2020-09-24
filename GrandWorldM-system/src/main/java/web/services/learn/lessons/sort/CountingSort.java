package web.services.learn.lessons.sort;

/**
 * 计数排序
 */
public class CountingSort {

    private static void sort(int[] a) {
        //Find the maximum and minimum.
        //Create an array "C" whose length is maximum+1.
        //Set every value in array C to the occurrence times
        // by which current index occurred in array "a".
        //Create a new array R who has the same size as A.
        //Traverse every value of A from the end.
        // And figure out the correct index in R of current value according to the array C.
        //then put the value into the position. And decrease the current value of C.
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 6, 4, 2, 1};
        sort(a);
        for (int n : a) {
            System.out.println(n);
        }
    }

}

package web.services.learn.lessons.sort;

/**
 * 计数排序
 */
public class CountingSort {

    private static void sort(int[] a) {
        //Find the maximum.
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        //Create an array "C" whose length is maximum+1.
        int[] c = new int[max + 1];
        //Set every value in array C to the occurrence times
        // by which current index occurred in array "a".
        for (int j = 0; j < a.length; j++) {
            ++c[a[j]];
        }
        //关键-The value of every element is the number of the elements of A that are smaller than or equal with the current index.
        for (int n = 1; n < c.length; n++) {
            c[n] = c[n] + c[n - 1];
        }
        //Create a new array R who has the same size as A.
        int[] r = new int[a.length];
        //Traverse every value of A from the end.
        for (int k = a.length - 1; k >= 0; k--) {
            //And decrease the current value of C.
            --c[a[k]];
            // And figure out the correct index in R of current value according to the array C.
            int indexR = c[a[k]];
            //then put the value into the position.
            r[indexR] = a[k];
        }
        for (int m = 0; m < r.length; m++) {
            a[m] = r[m];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 6, 9, 6, 4, 3, 5, 6, 7, 8, 2, 3, 4, 6, 5, 4, 3, 7, 6, 8, 9};
        sort(a);
        for (int n : a) {
            System.out.println(n);
        }
    }
}

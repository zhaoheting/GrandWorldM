package web.services.learn.lessons.tree;

/**
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0]= 3;
        arr[1] = 5;
        arr[2] = 1;
        arr[3] = 6;
        arr[4] = 2;
        HeapSort hs = new HeapSort();
        hs.sortFromEnd(arr);
        for (int x : arr){
            System.out.println(x);
        }
    }

    /**
     * (1)Create a heap: Traverse from the beginning of the array and
     * then heapify from the bottom to top.
     * (2)Sort like the process of deletion.
     *
     * @param arr
     */
    public void sortFromBegin(int[] arr) {
        //build heap from top.
        for (int i = 1; i < arr.length; i++) {
            while (i - 1 >> 1 >= 0 && arr[i - 1 >> 1] < arr[i]) {
                //swap
                int temp = arr[i - 1 >> 1];
                arr[i - 1 >> 1] = arr[i];
                arr[i] = temp;
                i = i - 1 >> 1;
            }
        }

        //sort
        sort(arr);
    }

    public void sortFromEnd(int[] arr) {
        //build heap from bottom.
        int n = arr.length-1;
        int start = n >> 1;
        for (int j = start; j >= 0; --j) {
            int currentIndex = j, i = j;
            while (true) {
                if (2 * i + 1 <= n && arr[currentIndex] < arr[2 * i + 1]) {
                    currentIndex = 2 * i + 1;
                }
                if (2 * i + 2 <= n && arr[currentIndex] < arr[2 * i + 2]) {
                    currentIndex = 2 * i + 2;
                }
                if (currentIndex == i) {
                    break;
                }
                int temp = arr[currentIndex];
                arr[currentIndex] = arr[i];
                arr[i] = temp;
                i = currentIndex;
            }
        }
        //sort.
        sort(arr);
    }

    private void sort(int[] arr) {
        int n = arr.length - 1;
        //swap.
        while (n > 0) {
            int maximum = arr[0];
            arr[0] = arr[n];
            arr[n--] = maximum;
            //heapify.
            int i = 0;
            int currentIndex = 0;
            while (true) {
                if (2 * i + 1  <= n && arr[currentIndex] < arr[2 * i + 1]) {
                    currentIndex = 2 * i + 1;
                }
                if (2 * i + 2 <= n && arr[currentIndex] < arr[2 * i + 2]) {
                    currentIndex = 2 * i + 2;
                }
                if (currentIndex == i) {
                    break;
                }
                int temp = arr[currentIndex];
                arr[currentIndex] = arr[i];
                arr[i] = temp;
                i = currentIndex;
            }
        }
    }
}

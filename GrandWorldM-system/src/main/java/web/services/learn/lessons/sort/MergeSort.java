package web.services.learn.lessons.sort;

/**
 * 归并排序。
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 6, 6, 2, 4, 9, 1};
//        int[] a = new int[]{2, 5, 3, 4};
        sort(a);
        for (int n : a) {
            System.out.println(n);
        }
    }

    private static void sort(int[] a) {
        divide(a, 0, a.length - 1);
    }

    private static void divide(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (end + start) / 2;
        divide(a, start, mid);
        divide(a, mid + 1, end);
        //当start和end之间只有两个元素时，调用combine函数就直接比较出了大小顺序。所以真正的排序发生在combine函数中。
        combineSentinel(a, start, mid, end);
    }

    /**
     * Combine sorted array left and right into a.
     */
    private static void combine(int[] a, int start, int mid, int end) {
        //将start到end之间的元素拆分到两个数组中。
        int[] left = new int[mid - start + 1];
        int[] right = new int[end - mid];
        for (int i = 0; i < mid - start + 1; i++) {
            left[i] = a[start + i];
        }
        for (int j = 0; j < end - mid; j++) {
            right[j] = a[mid + j + 1];
        }
        //将拆分的两个数组中的元素按照大小放入a中。
        int m = 0, n = 0, t = start;
        while (m < mid - start + 1 && n < end - mid) {
            if (left[m] < right[n]) {
                a[t++] = left[m++];
            } else {
                a[t++] = right[n++];
            }
        }
        //若其中一个数组的元素已经被全部放入a中，则另外一个数组中的元素一次性取出。
        if (m == mid - start + 1) {
            for (int d = n; d < end - mid; d++) {
                a[t++] = right[d];
            }
        } else {
            for (int d = m; d < mid - start + 1; d++) {
                a[t++] = left[d];
            }
        }
    }

    /**
     * Merge sort, using sentinel to simplify the judgement.
     *
     * @param a
     * @param start
     * @param mid
     * @param end
     */
    private static void combineSentinel(int[] a, int start, int mid, int end) {
        //将start到end之间的元素拆分到两个数组中。
        int[] left = new int[mid - start + 2];
        int[] right = new int[end - mid + 1];
        for (int i = 0; i < mid - start + 1; i++) {
            left[i] = a[start + i];
        }
        for (int j = 0; j < end - mid; j++) {
            right[j] = a[mid + j + 1];
        }
        left[left.length - 1] = Integer.MAX_VALUE;
        right[right.length - 1] = Integer.MAX_VALUE;
        //将拆分的两个数组中的元素按照大小放入a中。
        int m = 0, n = 0, t = start;
        //此处循环条件必须是对左侧数组的最大值判断。不能是对右侧数组的最大值判断。在左侧数组先被遍历完的情况，
        // 因为右侧数组原本就在原数组的右侧位，所以这种情况右侧数组剩余的大的值也不用挪到原数组中，他们原来的位置就是对的位置。
        //另外不等于判断的性能要优于等于判断，因为不等于判断只需要找到一个不同的二进制位即可，而等于判断要比较完所有的二进制位。
        while (left[n] != Integer.MAX_VALUE) {
            // The equal sign guarantees the stability of the algorithm.
            if (left[m] <= right[n]) {
                a[t++] = left[m++];
            } else {
                a[t++] = right[n++];
            }
        }
    }
}

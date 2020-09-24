package web.services.learn.lessons.sort;

/**
 * 用快排思想在O(n)时间复杂度内查找第K大元素。
 */
public class FindKByQuickSort {

    /**
     * 注意不要混淆“第K大”和"索引为K"。
     *
     * @param a
     * @param start
     * @param end
     * @param k
     * @return
     */
    private static int findK(int[] a, int start, int end, int k) {
        if (k > end + 1 || k < start + 1) {
            throw new RuntimeException("The array doesn't contain such an element.");
        }
        int pivotIndex = partition(a, start, end);
        if (k == pivotIndex + 1) {
            return a[pivotIndex];
        } else if (k < pivotIndex + 1) {
            return findK(a, start, pivotIndex - 1, k);
        } else {
            return findK(a, pivotIndex + 1, end, k);
        }
    }

    /**
     * 原地分区。
     *
     * @param a
     * @param start
     * @param end
     * @return
     */
    private static int partition(int[] a, int start, int end) {
        int pivot = a[end];
        int j = start;
        for (int i = start; i < end; i++) {
            if (a[i] < pivot) {
                int temp = a[i];
                a[i] = a[j];
                a[j++] = temp;
            }
        }
        a[end] = a[j];
        a[j] = pivot;
        return j;
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 16, 4, 22, 10};
        int result = findK(a, 0, a.length - 1, 3);
        System.out.println(result);
    }
}
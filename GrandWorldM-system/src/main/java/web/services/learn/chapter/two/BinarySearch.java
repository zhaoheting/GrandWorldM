package web.services.learn.chapter.two;

/**
 * Binary search.
 * 在有序序列中执行contains操作，算法复杂度是O(logN),但是其他操作比如插入和删除，算法复杂度为O(N).
 */
public class BinarySearch {

    /**
     * get a int from a sequence.
     * 如果想用折半查找，查找其他类型的数据，则可以通过实现Comparable接口来进行比较。
     *
     * @return
     */
    private int getFromSequence(int x, int[] a) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            int middleElement = a[mid];
            if (x == middleElement) {
                return mid;
            } else if (x < middleElement) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] a = {2, 4, 6, 8, 9, 12};
        System.out.println(binarySearch.getFromSequence(19, a));
    }
}

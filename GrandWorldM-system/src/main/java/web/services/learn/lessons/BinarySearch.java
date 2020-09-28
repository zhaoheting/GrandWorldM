package web.services.learn.lessons;

/**
 * 二分查找，又叫折半查找。
 */
public class BinarySearch {

    /**
     * Implementation of binary search on the basis of while loop.
     *
     * @param a
     * @param x
     * @return
     */
    private static int search(int[] a, int x) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
//            int mid = (high + low) / 2;
            int mid = low + ((high - low) >> 1);
            if (a[mid] == x) {
                return mid;
            } else if (a[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Implementation of binary search on the basis of recursion.
     *
     * @param a
     * @param x
     * @return
     */
    private static int searchByRecursion(int[] a, int x) {
        int low = 0;
        int high = a.length - 1;
        return recurse(a, low, high, x);
    }

    private static int recurse(int[] a, int low, int high, int x) {
        if (low <= high) {
            int mid = low + (high - low >> 1);
            if (a[mid] == x) {
                return mid;
            } else if (a[mid] < x) {
                return recurse(a, mid + 1, high, x);
            } else {
                return recurse(a, low, mid - 1, x);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 5, 6, 7, 9, 33, 55, 65, 76, 87, 99};
        System.out.println(searchByRecursion(a, 5));
    }
}

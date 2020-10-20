package web.services.learn.lessons.sort;

import java.util.LinkedList;

/**
 *
 */
public class BinarySearchTransform {

    /**
     * Find the first element equal to x,based on loop.
     *
     * @param a
     * @param x
     * @return
     */
    private static int findFirst(int[] a, int x) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low >> 1);
            if (a[mid] < x) {
                low = mid + 1;
            } else if (a[mid] > x) {
                high = mid - 1;
            } else {
                if (mid == 0 || a[mid - 1] != x) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * Find the first element equal to x, based on recursion.
     *
     * @param a
     * @param x
     * @return
     */
    private static int findFirstByRecursion(int[] a, int low, int high, int x) {
        int mid = low + (high - low >> 1);
        if (a[mid] < x) {
            return findFirstByRecursion(a, mid + 1, high, x);
        } else if (a[mid] > x) {
            return findFirstByRecursion(a, low, mid - 1, x);
        } else {
            if (mid == 0 || a[mid - 1] != x) {
                return mid;
            } else {
                return findFirstByRecursion(a, low, mid - 1, x);
            }
        }
    }

    private static int findFirstLargerOrEqual(int[] a, int x) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low >> 1);
            if (a[mid] >= x) {
                if (mid == 0 || a[mid - 1] < x) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //Find the first element equal to x.
        int[] a = new int[]{3, 5, 6, 7, 9, 9, 55, 65, 76, 87, 99};
        System.out.println(findFirst(a, 9));
        int[] b = new int[]{3, 5, 6, 7, 9, 9, 55, 65, 76, 87, 99};
        System.out.println(findFirstByRecursion(b, 0, b.length - 1, 9));

        //Find the first element that is larger than x.
        int[] c = new int[]{3, 5, 6, 7, 9, 9, 55, 65, 76, 87, 99};
        System.out.println(findFirstLargerOrEqual(c, 9));
    }
}

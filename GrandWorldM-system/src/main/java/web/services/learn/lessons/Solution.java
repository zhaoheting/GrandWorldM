package web.services.learn.lessons;

import io.swagger.models.auth.In;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[4];
        nums[0] = 7;
        nums[1] = 5;
        nums[2] = 6;
        nums[3] = 4;
        int result = new Solution().reversePairs(nums);
        System.out.println(result);
    }
    public int reversePairs(int[] nums) {
        return divide(nums, 0, nums.length-1);
    }

    private int divide(int[] arr, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int middle = start + end >> 1;
        int result = divide(arr, start, middle);
        result += divide(arr, middle + 1, end);
        return result + merge(arr, start, middle, end);
    }

    private int merge(int[] arr, int start, int mid, int end) {
        int result = 0;
        int[] left = new int[mid - start + 2];
        int[] right = new int[end - mid + 1];
        for (int i = 0; i < left.length - 1; i++) {
            left[i] = arr[start + i];
        }
        left[left.length - 1] = Integer.MAX_VALUE;
        for (int j = 0; j < right.length-1; j++) {
            right[j] = arr[mid + 1 + j];
        }
        right[right.length -1] = Integer.MAX_VALUE;
        int m = 0, n = 0, k = start;
        while (left[m] != Integer.MAX_VALUE) {
            if (left[m] <= right[n]) {
                arr[k++] = left[m++];
            } else {
                arr[k++] = right[n++];
                result += mid - m + 1;
            }
        }
        return result;
    }
}

package web.services.learn.lessons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {1, -1, -1, 0};
        List<List<Integer>> result = threeSum(nums);
        System.out.print(result);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (length < 3) {
            return result;
        }
        if (nums[0] > 0 || nums[length - 1] < 0) {
            return result;
        }
        for (int i = 0; i < length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int leftIndex = i + 1;
            int rightIndex = length - 1;
            while (leftIndex < rightIndex) {
                int currentSum = nums[i] + nums[leftIndex] + nums[rightIndex];
                if (currentSum == 0) {
                    List<Integer> currentList = new ArrayList<>();
                    currentList.add(nums[i]);
                    currentList.add(nums[leftIndex]);
                    currentList.add(nums[rightIndex]);
                    result.add(currentList);
                    while (leftIndex + 1 < rightIndex && nums[leftIndex + 1] == nums[leftIndex]) {
                        ++leftIndex;
                    }
                    while (rightIndex - 1 >= leftIndex && nums[rightIndex - 1] == nums[rightIndex]) {
                        --rightIndex;
                    }
                    ++leftIndex;
                    --rightIndex;
                } else if (currentSum < 0) {
                    ++leftIndex;
                } else {
                    --rightIndex;
                }
            }
        }
        return result;
    }
}

package web.services.learn.lessons.fouralgorithm;

/**
 * 最长递增子序列。
 */
public class MaxIncrementSubSequence {
    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4,-5,-6};
        MaxIncrementSubSequence m = new MaxIncrementSubSequence();
        System.out.println(m.dpTable(nums));
    }

    public int lengthOfLIS(int[] nums) {
        return dpTable(nums);
    }

    private int dpTable(int[] nums) {
        int length = nums.length;
        int[] states = new int[length];
        //init. Any number can be treated as a sequence whose length is 1.
        for (int i = 0; i < length; ++i) {
            states[i] = 1;
        }
        for (int i = 0; i < length-1; ++i) {
            for (int j = i + 1; j < length; ++j) {
                if (nums[j] > nums[i]) {
                    states[j] = Math.max(states[j], states[i] + 1);
                }
            }
        }
        int result = 0;
        for (int m = 0; m < length; ++m) {
            result = Math.max(result, states[m]);
        }
        return result;
    }
}

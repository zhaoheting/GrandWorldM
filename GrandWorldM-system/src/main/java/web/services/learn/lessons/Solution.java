package web.services.learn.lessons;

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3};
        String result = new Solution().getLargest(nums);
    }

    /**
     * the interview question of microsoft.
     * @param nums
     * @return
     */
    private String getLargest(Integer[] nums) {
        Arrays.sort(nums, new MyComparator());
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < nums.length; ++i){
            s.append((nums[i]));
        }
        return s.toString();
    }

    class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            String[] s1 = String.valueOf(o1).split("");
            String[] s2 = String.valueOf(o2).split("");
            int i = 0;
            for (; i < s1.length && i < s2.length; ++i) {
                if (Integer.valueOf(s1[i]) > Integer.valueOf(s2[i])) {
                    return 1;
                } else if (Integer.valueOf(s1[i]) < Integer.valueOf(s2[i])) {
                    return -1;
                }
            }
            if (i == s1.length && i == s2.length) {
                return 0;
            } else if (i == s1.length) {
                return Integer.valueOf(s2[i]) > Integer.valueOf(s2[0]) ? -1 : 1;
            } else {
                return Integer.valueOf(s1[i]) > Integer.valueOf(s1[0]) ? 1 : -1;
            }
        }
    }

}

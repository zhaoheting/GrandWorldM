package web.services.learn.lessons;

import java.util.Arrays;

class Solution {

    /**
     * 找出正整数数组中最大的元素数量等于元素本身的元素，爱立信面试题(自己写的不一定对)。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 2, 3, 3,3,4,4,4};
        Arrays.sort(arr);
        int[] variables = new int[3];//variables[0] is current number. variables[1] is the count of current number.
        //variable[2] is the result;
        variables[0] = arr[0];
        variables[2] = Integer.MIN_VALUE;
        Arrays.stream(arr).forEach(x -> {
            if (x == variables[0]) {
                ++variables[1];
            } else {
                if (variables[0] == variables[1]) {
                    variables[2] = Math.max(variables[2], variables[0]);
                } else {
                    variables[2] = Math.max(variables[2], -1);
                }
                variables[0] = x;
                variables[1] = 1;
            }
        });
        if (variables[0] == variables[1] && variables[0] != variables[2]) {
            variables[2] = variables[0];
        }
        System.out.println(variables[2]);
    }

}

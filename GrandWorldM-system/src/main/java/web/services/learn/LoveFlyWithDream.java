package web.services.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoveFlyWithDream {

    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3};
        LoveFlyWithDream loveFlyWithDream = new LoveFlyWithDream();
        int result = loveFlyWithDream.sss(prices, 2);
        System.out.println(result);
    }

    private int sss(int[] prices, int k) {
        int length = prices.length;
        int[][] dp = new int[k + 1][2];
        //base case.
        // K must be larger than 1, or it is meaningless. So we just define dp[0][0][0] specially for calculating state.
        dp[0][0] = 0; //This line can be omitted, because the default value is 0.
        for (int m = k; m >= 1; --m) {
            dp[m][0] = 0;
            dp[m][1] = -prices[0];
        }
        //dp[i][k][0] = max(dp[i-1][k][0], dp[i-][k][1] + prices[i]);
        //dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0]-prices[i];
        for (int i = 1; i < length; ++i) {
            for (int j = k; j >= 1; --j) {
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + prices[i]);
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - prices[i]);
            }
        }
        return dp[k][0];
    }

    private static class Node {
        int val;
        Node next;

        public Node() {
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}

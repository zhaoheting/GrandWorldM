package web.services.learn.lessons.fouralgorithm;

/**
 * How to get a designated amount value, using minimum amount of coins that worth different values.
 * For example, we have three kinds of coins that respectively  worth 1,3,5. And we want to get 9 RMB.
 */
public class MinimumCoin {
    public static void main(String[] args) {
        MinimumCoin minimumCoin = new MinimumCoin();
        int[] arr = {1, 3, 5};
//        int result = minimumCoin.coinChange(arr, 9);
        int result = minimumCoin.dpTable(arr, 9);
        System.out.println(result);
    }

    public int coinChange(int[] coins, int amount) {
        int result = dpExpression(coins, amount, new int[amount + 1]);
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }

    /**
     * 动态转移方程法
     *
     * @param coins
     * @param amount
     * @param states
     * @return
     */
    public int dpExpression(int[] coins, int amount, int[] states) {
        if (amount == 0) {
            return 0;
        }
        int length = coins.length;
        int currentMin = Integer.MAX_VALUE;
        for (int i = 0; i < length; ++i) {
            if (amount - coins[i] >= 0) {
                //如果状态表中的当前值大于零，说明之前计算过凑够该数量的钱需要的最小硬币数量。
                if (states[amount - coins[i]] > 0) {
                    currentMin = Math.min(currentMin, states[amount - coins[i]]);
                } else {
                    int tempMin = dpExpression(coins, amount - coins[i], states);
                    states[amount - coins[i]] = tempMin;
                    currentMin = Math.min(currentMin, tempMin);
                }
            }
        }
        return currentMin == Integer.MAX_VALUE ? currentMin : currentMin + 1;
    }

    /**
     * 动态转移表法
     *
     * @param coins
     * @param amount
     * @return
     */
    public int dpTable(int[] coins, int amount) {
        boolean[] states = new boolean[amount + 1];
        //Init states array.Because we have 1,3,5, so we only need one coin if we want to get amount of 1,3,5.
        for (int value : coins) {
            //If we want to get amount 4, we should not use the coin that worth 5.
            if (value < amount) {
                states[value] = true;
            }
            if (value == amount) {
                return 1;
            }
        }
        //calculate the maximum amount that we can obtain when we use 2,3,4,5...amount 个 coins.
        for (int number = 2; number <= amount; ++number) {
            for (int i = amount; i >= 0; --i) {
                if (states[i]) {
                    int length = coins.length;
                    for (int j = 0; j < length; ++j) {
                        if (i + coins[j] < amount) {
                            states[i + coins[j]] = true;
                        }
                        //Return current number of used coins when obtain the designated amount.
                        if (i + coins[j] == amount) {
                            return number;
                        }
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 回溯
     *
     * @param coins
     * @param amount
     * @return
     */
    public int backTrack(int[] coins, int amount) {
        coinChange(coins, amount, 0, new boolean[amount + 1][amount + 1]);
        return minCoinNum == Integer.MAX_VALUE ? -1 : minCoinNum;
    }

    public int minCoinNum = Integer.MAX_VALUE;

    public void coinChange(int[] coins, int amount, int currentCoinNum, boolean[][] states) {
        if (amount == 0) {
            minCoinNum = Math.min(minCoinNum, currentCoinNum);
            return;
        }
        int length = coins.length;
        if (!states[currentCoinNum][amount] && currentCoinNum < minCoinNum) {
            states[currentCoinNum][amount] = true;
            for (int i = 0; i < length; ++i) {
                if (amount - coins[i] >= 0) {
                    coinChange(coins, amount - coins[i], currentCoinNum + 1, states);
                }
            }
        }
    }
}

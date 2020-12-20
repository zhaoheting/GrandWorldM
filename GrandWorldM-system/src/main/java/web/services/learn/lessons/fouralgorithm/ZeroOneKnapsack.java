package web.services.learn.lessons.fouralgorithm;

/**
 * 0-1 背包问题多种方法求解。
 */
public class ZeroOneKnapsack {
    int[] itemArray = {2, 2, 4, 6, 3};
    int maxWeight = 9;
    int resultWeight = Integer.MIN_VALUE;
    boolean[][] isVisited = new boolean[5][10];

    public static void main(String[] args) {
        ZeroOneKnapsack zeroOneKnapsack = new ZeroOneKnapsack();
//        zeroOneKnapsack.backTrack(0, 0);
        zeroOneKnapsack.dynamicProgram2();
        System.out.println(zeroOneKnapsack.resultWeight);
    }

    /**
     * 回溯算法求解。
     *
     * @param index            当前即将放入第几个物品，从0开始。
     * @param currentWeightSum 放入此物品前的背包总重量。
     */
    private void backTrack(int index, int currentWeightSum) {
        if (index == itemArray.length || currentWeightSum == maxWeight) {
            if (currentWeightSum > resultWeight) {
                resultWeight = currentWeightSum;
            }
            return;
        }
        if (isVisited[index][currentWeightSum]) {
            return;
        }
        isVisited[index][currentWeightSum] = true;
        backTrack(index + 1, currentWeightSum);
        int newWeightSum = currentWeightSum + itemArray[index];
        if (newWeightSum <= maxWeight) {
            backTrack(index + 1, newWeightSum);
        }
    }

    /**
     * 动态规划求解。
     */
    private void dynamicProgram() {
        int itemAmount = itemArray.length;
        boolean[][] stateArr = new boolean[itemAmount][maxWeight + 1];
        //第一个物品要单独处理，然后其他物品根据第一个物品的结果动态处理。
        stateArr[0][0] = true;
        if (itemArray[0] <= maxWeight) {
            stateArr[0][itemArray[0]] = true;
        }
        //当前物品不放入背包
        for (int i = 1; i < itemAmount; ++i) {
            for (int j = 0; j <= maxWeight; ++j) {
                if (stateArr[i - 1][j]) {
                    stateArr[i][j] = stateArr[i - 1][j];
                }
            }
            //当前物品放入背包
            int currentWeight = itemArray[i];
            for (int j = 0; j <= maxWeight - currentWeight; ++j) {
                if (stateArr[i - 1][j]) {
                    stateArr[i][j + currentWeight] = stateArr[i - 1][j];
                }
            }
        }
        //取得最接近maxWeight的值。
        for (int k = maxWeight; k >= 0; --k) {
            if (stateArr[itemAmount - 1][k]) {
                resultWeight = k;
                return;
            }
        }
    }

    /**
     * 动态规划求解方法2，用一个二维数组，每轮只记录当前物品放置结果。
     */
    private void dynamicProgram2() {
        boolean[] stateArray = new boolean[maxWeight + 1];
        stateArray[0] = true;
        if (itemArray[0] <= maxWeight) {
            stateArray[itemArray[0]] = true;
        }
        for (int item = 0, length = itemArray.length; item < length; ++item) {
            for (int j = maxWeight - itemArray[item]; j >= 0; --j) {
                if (stateArray[j]) {
                    stateArray[j + itemArray[item]] = stateArray[j];
                }
            }
        }
        for (int i = maxWeight; i >= 0; --i) {
            if (stateArray[i]) {
                resultWeight = i;
                return;
            }
        }
    }
}

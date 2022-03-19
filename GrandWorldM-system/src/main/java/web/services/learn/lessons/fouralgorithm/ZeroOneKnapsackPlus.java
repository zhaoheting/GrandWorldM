package web.services.learn.lessons.fouralgorithm;

import java.util.Arrays;

/**
 * 0-1 背包问题升级。在满足物品总和不超过背包最大允许重量前提下，求出最大价值。(部分代码有问题，没时间修复。)
 */
public class ZeroOneKnapsackPlus {

    int[] itemWeightArray = {2, 2, 4, 6};
    int[] itemValueArray = {3, 4, 8, 9};
    int maxWeight = 10;
    int resultValueSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        ZeroOneKnapsackPlus zeroOneKnapsackPlus = new ZeroOneKnapsackPlus();
//        zeroOneKnapsackPlus.backtrack(0, 0, 0);
        zeroOneKnapsackPlus.dynamicProgram2();
        System.out.println(zeroOneKnapsackPlus.resultValueSum);
    }

    /**
     * 回溯算法。（无法利用"备忘录"（布尔类型数组），来避免重复计算"index相同，
     * currentWeightSum相同，而currentValueSum小于已经计算出的数值的情况，
     * 即如果已经计算过f(2,2,4）,则不必计算f(2,2,3).
     *
     * @param index
     * @param currentWeightSum
     * @param currentValueSum
     */
    private void backtrack(int index, int currentWeightSum, int currentValueSum) {
        if (index == itemWeightArray.length || currentWeightSum == maxWeight) {
            if (currentValueSum > resultValueSum) {
                resultValueSum = currentValueSum;
            }
            return;
        }
        backtrack(index + 1, currentWeightSum, currentValueSum);
        if (itemWeightArray[index] + currentWeightSum <= maxWeight) {
            backtrack(index + 1, itemWeightArray[index] + currentWeightSum,
                    currentValueSum + itemValueArray[index]);
        }
    }

    /**
     * 动态规划。二维数组。
     */
    private void dynamicProgram() {
        //不再使用boolean类型数组，而用整形来记录物品放入后的价值。
        int itemAmount = itemWeightArray.length;
        int[][] stateArray = new int[itemAmount][maxWeight + 1];
        stateArray[0][0] = 0;//好像没用，默认是零。
        if (itemWeightArray[0] <= maxWeight) {
            stateArray[0][itemWeightArray[0]] = itemValueArray[0];
        }
        for (int itemIndex = 1; itemIndex < itemAmount; ++itemIndex) {
            //不放当前物品
            for (int j = 0; j <= maxWeight; ++j) {
                stateArray[itemIndex][j] = stateArray[itemIndex - 1][j];
            }
            //放当前物品
            int currentWeight = itemWeightArray[itemIndex];
            for (int j = 0; j <= maxWeight - currentWeight; ++j) {
                int currentValueSum = stateArray[itemIndex - 1][j] + itemValueArray[itemIndex];
                if (stateArray[itemIndex][j + currentWeight] < currentValueSum) {
                    stateArray[itemIndex][j + currentWeight] = currentValueSum;
                }
            }
        }
        for (int k = 0; k <= maxWeight; ++k) {
            int currentState = stateArray[itemAmount - 1][k];
            if (resultValueSum < currentState) {
                resultValueSum = currentState;
            }
        }
    }

    /**
     * 动态规划。空间复杂度优化，一维数组。
     */
    private void dynamicProgram2() {
        int itemAmount = itemWeightArray.length;
        int[] stateArr = new int[maxWeight + 1];
        Arrays.fill(stateArr, -1);
        stateArr[0] = 0;
        for (int item = 0; item < itemAmount; ++item) {
            int currentWeight = itemWeightArray[item];
            for (int j = maxWeight - currentWeight; j >= 0; --j) {
                if (stateArr[j] >= 0) {
                    int currentValueSum = stateArr[j] + itemValueArray[item];
                    if (currentValueSum > stateArr[j + currentWeight]) {
                        stateArr[j + currentWeight] = currentValueSum;
                    }
                }
            }
        }
        for (int k = 0; k <= maxWeight; ++k) {
            int currentState = stateArr[k];
            if (resultValueSum < currentState) {
                resultValueSum = currentState;
            }
        }
    }
}

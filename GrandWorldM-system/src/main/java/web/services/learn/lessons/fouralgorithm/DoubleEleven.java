package web.services.learn.lessons.fouralgorithm;

/**
 * 求，双十一满200减若干，的购物车中商品最小花费组合，并输出选择的商品。
 */
public class DoubleEleven {

    private int[] itemPriceArray = {67, 120, 39, 55, 37};
    private int minPriceSum = 200;
    private int resultPrice = Integer.MIN_VALUE;

    public static void main(String[] args) {
        DoubleEleven doubleEleven = new DoubleEleven();
        doubleEleven.doubleElevenAdvance();
        if (doubleEleven.resultPrice == Integer.MIN_VALUE) {
            System.out.println("Can't find a appropriate solution.");
        } else {
            System.out.print(doubleEleven.resultPrice);
        }
    }

    /**
     * 动态规划求出，双十一满200减若干，的购物车中商品最小花费组合，并输出选择的商品。
     */
    private void doubleElevenAdvance() {
        int itemAmount = itemPriceArray.length;
        boolean[][] stateArray = new boolean[itemAmount][2 * minPriceSum + 1];
        stateArray[0][0] = true;
        if (itemPriceArray[0] <= 2 * minPriceSum) {
            stateArray[0][itemPriceArray[0]] = true;
        }
        for (int index = 1; index < itemAmount; ++index) {
            //Don't buy current item.
            for (int j = 0; j <= 2 * minPriceSum; ++j) {
                if (stateArray[index - 1][j]) {
                    stateArray[index][j] = true;
                }
            }
            //Buy current item.
            int currentPrice = itemPriceArray[index];
            for (int j = 0; j <= 2 * minPriceSum - currentPrice; ++j) {
                if (stateArray[index - 1][j]) {
                    stateArray[index][j + currentPrice] = true;
                }
            }
        }
        //get the minimum price summary.
        int k = minPriceSum, maxAcceptedPrice = 2 * minPriceSum;
        for (; k <= maxAcceptedPrice; ++k) {
            if (stateArray[itemAmount - 1][k]) {
                resultPrice = k;
                break;
            }
        }
        if (k == maxAcceptedPrice + 1) {
            return;
        }
        //print the chosen items.
        for (int m = itemAmount - 1; m >= 1; --m) {
            //If both the stateArray[m-1][k-itemPriceArray[m]] and
            //stateArray[m-1][k] are true, here we choose the forward one to output.
            //how should we do if we want to print out every solution.
            if (k - itemPriceArray[m] >= 0 && stateArray[m - 1][k - itemPriceArray[m]]) {
                System.out.print(itemPriceArray[m] + " ");
                k -= itemPriceArray[m];
            }//else current item is not included.
        }
        //if k is 0, the first item is not included.
        if (k != 0) {
            System.out.print(itemPriceArray[0]);
        }
        System.out.print("\n");
    }
}

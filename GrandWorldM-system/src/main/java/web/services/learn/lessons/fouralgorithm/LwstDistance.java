package web.services.learn.lessons.fouralgorithm;

/**
 * 搜索引擎拼写纠错功能第一种实现---莱文斯坦距离（回溯和动态规划）。
 */
public class LwstDistance {
    private char[] aArr = "mitcmu".toCharArray();
    private char[] bArr = "mtacnu".toCharArray();
    int aLen = aArr.length;
    int bLen = bArr.length;
    int minEditDistance = Integer.MAX_VALUE;

    public static void main(String[] args) {
        LwstDistance lwstDistance = new LwstDistance();
        lwstDistance.lwstBackTrack(0, 0, 0);
//        lwstDistance.lwstDynamicProgram();
        System.out.println(lwstDistance.minEditDistance);
    }

    /**
     * 极客时间上的回溯算法。
     *
     * @param aIndex
     * @param bIndex
     */
    public void lwstBackTrack(int aIndex, int bIndex, int currentEditDistance) {
        //One of the strings is traversed completely at least.
        if (aIndex == aLen || bIndex == bLen) {
            if (aIndex < aLen) {
                currentEditDistance += aLen - aIndex;
            }
            if (bIndex < bLen) {
                currentEditDistance += bLen - bIndex;
            }
            if (minEditDistance > currentEditDistance) {
                minEditDistance = currentEditDistance;
            }
            return;
        }
        //None of the strings is traversed completely.
        //If current two characters are same.
        if (aArr[aIndex] == bArr[bIndex]) {
            lwstBackTrack(aIndex + 1, bIndex + 1, currentEditDistance);
        } else {//Current two characters are different.
            lwstBackTrack(aIndex + 1, bIndex, currentEditDistance + 1);
            lwstBackTrack(aIndex, bIndex + 1, currentEditDistance + 1);
            lwstBackTrack(aIndex + 1, bIndex + 1, currentEditDistance + 1);
        }
    }

    /**
     * 自己想到的回溯思路。
     *
     * @param aIndex
     * @param bIndex
     * @param currentEditDistance
     */
    public void lwstBackTrack2(int aIndex, int bIndex, int currentEditDistance) {
        if (aIndex == aLen && bIndex == bLen) {
            minEditDistance = Math.min(minEditDistance, currentEditDistance);
            return;
        }
        if (aArr[aIndex] == bArr[bIndex]) {
            if (aIndex + 1 <= aLen && bIndex + 1 <= bLen) {
                lwstBackTrack2(aIndex + 1, bIndex + 1, currentEditDistance);
            }
        } else {
            if (aIndex + 1 <= aLen) {
                lwstBackTrack(aIndex + 1, bIndex, currentEditDistance + 1);
            }
            if (bIndex + 1 <= bLen) {
                lwstBackTrack(aIndex, bIndex + 1, currentEditDistance + 1);
            }
            if (aIndex + 1 <= aLen && bIndex + 1 <= bLen) {
                lwstBackTrack(aIndex + 1, bIndex + 1, currentEditDistance + 1);
            }
        }
    }

    /**
     * 动态规划计算莱文斯坦距离。
     */
    public void lwstDynamicProgram() {
        //First row.
        int[][] distance = new int[aLen][bLen];
        for (int column = 0; column < bLen; ++column) {
            if (column == 0) {
                distance[0][0] = aArr[0] == bArr[column] ? 0 : 1;
            } else {
                distance[0][column] = distance[0][column - 1] + 1;
            }
        }
        //First column.
        for (int row = 1; row < aLen; ++row) {
            distance[row][0] = distance[row - 1][0] + 1;
        }
        //Fill the remainder values.
        for (int row = 1; row < aLen; ++row) {
            for (int column = 1; column < bLen; ++column) {
                /*
                 * 这段话很重要！！！
                 *（1）文中对递归树中的状态三元组(i, j, edist)的解释是，“状态包含三个变量 (i, j, edist)，其中，edist表示处理到 a[i] 和 b[j] 时，已经执行的编辑操作的次数。
                 * ”这里的“处理到a[i]和b[j]时”，其实是在说将要处理但还并未处理a[i]和b[j]。
                 * edist并不包括对a[i]和[j]的编辑操作。递归树图片后紧接着的图片中，(i, j, min_edist)的min_edist也并不包括对a[i]和[j]的编辑操作。
                 *（2）而二维状态表图片中每格的值和动态规划的实现代码中minDist[i][j]两者均代表：到处理完a[i]和b[j]之后为止，已经执行的编辑操作的最少次数。
                 * 根据这个意思，可知状态转移方程中的min_edist(i, j)也是包括对a[i]和[j]的编辑操作的。
                 * 如果按照（1）中的意思，状态转移方程中的min_edist(i, j)就不应该包括对a[i]和[j]的编辑操作，
                 * 也不应该判断a[i]和b[j]是否相等，而应该判断的是a[i - 1]和b[j - 1]是否相等；
                 * 并且动态规划的实现代码中循环终止条件就不应是小于n或m，而应是小于等于n或m。
                 *
                 */
                if (aArr[row] != bArr[column]) {
                    distance[row][column] = min(distance[row - 1][column] + 1, distance[row][column - 1] + 1, distance[row - 1][column - 1] + 1);
                } else {
                    distance[row][column] = min(distance[row - 1][column] + 1, distance[row][column - 1] + 1, distance[row - 1][column - 1]);
                }
            }
        }
        minEditDistance = distance[aLen - 1][bLen - 1];
    }

    /**
     * Calculate the minimum among three integers.
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    private int min(int x, int y, int z) {
        int result = x > y ? y : x;
        return result > z ? z : result;
    }
}

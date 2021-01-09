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
//        lwstDistance.lwstBackTrack(0, 0, 0);
        lwstDistance.lwstDynamicProgram();
        System.out.println(lwstDistance.minEditDistance);
    }

    /**
     * 回溯算法。
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

package web.services.learn.lessons.fouralgorithm;

/**
 * Calculate the length of the longest common substring.
 * 一般递归方法中的每个状态值f(i,j)都是没有处理第i,j, 即完成对i-1,j-1的处理后的状态值。
 * 而动态规划中的每一个状态值，都是表示处理完当下的数据后得到的值。比如这个最长公共子串问题，
 * 运用递归解题时，f(i,j)表示在比较aArra[i]和bArra[j]之前，求得的最长子串长度。而运用动态规划解题时，stateArray[i][j]表示比较完aArra[i]和bArra[j]之后，求得的最长子串长度
 */
public class LongestCommonSubstringLen {

    private char[] aArr = "mitcmunu".toCharArray();
    private char[] bArr = "mtacnu".toCharArray();
    int aLen = aArr.length;
    int bLen = bArr.length;
    int maxCommonSubstringLen = Integer.MIN_VALUE;

    public static void main(String[] args) {
        LongestCommonSubstringLen longestCommonSubstringLen = new LongestCommonSubstringLen();
//        longestCommonSubstringLen.dynamicProgram();
        longestCommonSubstringLen.backTrack(0, 0, 0);
        System.out.println(longestCommonSubstringLen.maxCommonSubstringLen);
        int result = longestCommonSubstringLen.dp2(longestCommonSubstringLen.aLen-1,
                longestCommonSubstringLen.bLen-1);
        System.out.println(result);
    }

    public void backTrack(int aIndex, int bIndex, int currentCommonLength) {
        //terminal condition.
        if (aIndex == aLen || bIndex == bLen) {
            if (maxCommonSubstringLen < currentCommonLength) {
                maxCommonSubstringLen = currentCommonLength;
            }
            return;
        }
        if (aArr[aIndex] != bArr[bIndex]) {
            backTrack(aIndex + 1, bIndex, currentCommonLength);
            backTrack(aIndex, bIndex + 1, currentCommonLength);
        } else {
            backTrack(aIndex + 1, bIndex + 1, currentCommonLength + 1);
        }
    }

    /**
     * 动态转移表法
     */
    public void dynamicProgram() {
        int[][] lengthArray = new int[aLen][bLen];
        for (int column = 0; column < bLen; ++column) {
            if (column == 0) {
                lengthArray[0][0] = aArr[0] == bArr[0] ? 1 : 0;
            } else {
                lengthArray[0][column] = lengthArray[0][column - 1];
            }
        }
        for (int row = 1; row < aLen; ++row) {
            lengthArray[row][0] = lengthArray[row - 1][0];
        }
        for (int row = 1; row < aLen; ++row) {
            for (int column = 1; column < bLen; ++column) {
                if (aArr[row] != bArr[column]) {
                    lengthArray[row][column] = max(lengthArray[row - 1][column], lengthArray[row][column - 1], lengthArray[row - 1][column - 1]);
                } else {//
                    //课程中写到：如果：a[i]==b[j]，那么：max_lcs(i, j)就等于：max(max_lcs(i-1,j-1)+1, max_lcs(i-1, j), max_lcs(i, j-1))；。
                    //对于例子mitc和mtac，因为max_lcs(i-1,j-1)+1涵盖了max_lcs(i-1, j)+1的情况，所以其不用加一也不影响结果，
                    // 因为我们求的是最大值，只要最大值正确即可。
                    //而对于例子aba和a，则要求max_lcs(i-1, j)必须不能加一了，所以这里max_lcs(i-1, j)和max_lcs(i, j-1)在a[i]==b[j]时都不能加1.
                    lengthArray[row][column] = max(lengthArray[row - 1][column], lengthArray[row][column - 1], lengthArray[row - 1][column - 1] + 1);
                }
            }
        }
        maxCommonSubstringLen = lengthArray[aLen - 1][bLen - 1];
    }

    /**
     * 动态转移方程法。(目前结果不对！！！！！)
     *
     * @return {@link int}
     */
    public int dp2(int aIndex, int bIndex) {
        if (aIndex == 0 || bIndex == 0) {
            if (aIndex > 0) {
                for (int m = 0; m <= aIndex; ++m) {
                    if (aArr[m] == bArr[0]) {
                        return 1;
                    }
                }
                return 0;
            }
            if (bIndex > 0) {
                for (int m = 0; m <= bIndex; ++m) {
                    if (aArr[0] == bArr[m]) {
                        return 1;
                    }
                }
                return 0;
            }
            return aArr[0] == bArr[0] ? 1 : 0;
        }
        int result;
        if (aArr[aIndex] != bArr[bIndex]) {
            result = max(dp2(aIndex - 1, bIndex - 1), dp2(aIndex, bIndex - 1), dp2(aIndex, bIndex - 1));
        } else {
            result = max(dp2(aIndex - 1, bIndex - 1) + 1, dp2(aIndex, bIndex - 1), dp2(aIndex, bIndex - 1));
        }
        return result;
    }

    private int max(int x, int y, int z) {
        int maxValue = x > y ? x : y;
        return maxValue > z ? maxValue : z;
    }
}

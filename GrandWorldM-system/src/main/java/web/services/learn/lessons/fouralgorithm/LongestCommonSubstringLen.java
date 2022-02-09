package web.services.learn.lessons.fouralgorithm;

/**
 * Calculate the length of the longest common substring.
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
        longestCommonSubstringLen.backTrack(0,0,0);
        System.out.println(longestCommonSubstringLen.maxCommonSubstringLen);
    }

    public void backTrack(int aIndex, int bIndex, int currentCommonLength) {
        //terminal condition.
        if(aIndex == aLen || bIndex == bLen){
            if(maxCommonSubstringLen < currentCommonLength){
                maxCommonSubstringLen = currentCommonLength;
            }
            return;
        }
        if(aArr[aIndex] != bArr[bIndex]){
            backTrack(aIndex+1,bIndex,currentCommonLength);
            backTrack(aIndex,bIndex+1,currentCommonLength);
        } else{
            backTrack(aIndex+1,bIndex+1, currentCommonLength+1);
        }
    }

    /**
     * 动态规划。
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
                    //对于例子mitc和mtac，因为max_lcs(i-1,j-1)+1涵盖了max_lcs(i-1, j)+1的情况，所以其不用加一也不影响结果。
                    //而对于例子aba和a，则要求max_lcs(i-1, j)必须不能加一了，所以这里max_lcs(i-1, j)和max_lcs(i, j-1)在a[i]==b[j]时都不能加1.
                    lengthArray[row][column] = max(lengthArray[row - 1][column], lengthArray[row][column - 1], lengthArray[row - 1][column - 1] + 1);
                }
            }
        }
        maxCommonSubstringLen = lengthArray[aLen - 1][bLen - 1];
    }

    private int max(int x, int y, int z) {
        int maxValue = x > y ? x : y;
        return maxValue > z ? maxValue : z;
    }
}

package web.services.learn.lessons.stringmatch;

public class BM {

    //ASCII码共有256个字符.
    private static final int SIZE = 256;

    public int match(char[] originArr, char[] targetArr) {
        int oLength = originArr.length;
        int tLength = targetArr.length;
        int[] targetAscii = generateBadChar(targetArr);
        int i = 0;//i is used to mark position that the first char of the target array is moved backwards to.
        while (i < oLength - tLength) {
            //compare every char from the end.
            int j = tLength - 1;
            for (; j >= 0; --j) {
                if (originArr[j + i] != targetArr[j]) {
                    break;
                }
            }
            //if all are the same, break.
            if (j < 0) {
                return i;
            }
            //else, get the index current char of origin array and
            i = i + (j - targetAscii[(int) targetArr[j - i]]);
            // move the target array backward by a number related to the current index.
        }
        return -1;
    }

    /**
     * @param arr
     * @return
     */
    private int[] generateBadChar(char[] arr) {
        int[] targetArr = new int[SIZE];
        //initialization.
        for (int i = 0; i < arr.length; i++) {
            targetArr[i] = -1;
        }
        //Key is the ascii of current char. Value is the index of current char.
        for (int i = 0; i < arr.length; i++) {
            int ascii = (int) arr[i];
            targetArr[ascii] = i;
        }
        return targetArr;
    }

    private void generateGoodSuffix(char[] targetArr) {
        int targetLength = targetArr.length;
        int[] suffix = new int[targetLength];
        boolean[] isPrefix = new boolean[targetLength];
        for (int i = 1; i < targetLength; ++i) {
            suffix[i] = -1;
            isPrefix[i] = false;
        }
        for (int i = 0; i < targetLength - 1; ++i) {
            int j = i;
            int k = 0;
            while (j >= 0 && targetArr[j] == targetArr[targetLength - 1 - k]) {
                --j;
                ++k;
                suffix[k] = j + 1;
            }
            if(j == -1){
                isPrefix[k] = true;
            }
        }
    }
}

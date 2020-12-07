package web.services.learn.lessons.stringmatch;

public class BM {

    //ASCII码共有256个字符.
    private static final int SIZE = 256;

    public int match(char[] originArr, char[] targetArr) {
        int oLength = originArr.length;
        int tLength = targetArr.length;
        int i = 0;//i is used to mark position that the first char of the target array is moved backwards to.
        while (i < oLength - tLength) {
            //compare every char from the end.
            int j = tLength - 1+i;
            for (; j >= 0; --j) {
                if()
            }
            //if all are the same, break.
            //else, get the index current char of origin array and
            // move the target array backward by a number related to the current index.
        }
    }

    /**
     * @param arr
     * @return
     */
    private int[] genTargetArr(char[] arr) {
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
}

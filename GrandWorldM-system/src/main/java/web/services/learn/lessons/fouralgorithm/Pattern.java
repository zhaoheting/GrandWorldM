package web.services.learn.lessons.fouralgorithm;

/**
 * Back track for regular expression.
 */
public class Pattern {
    private boolean isMatched = false;
    private char[] pattern;
    private int pLength;

    public Pattern(char[] pattern) {
        this.pattern = pattern;
        pLength = pattern.length;
    }

    public boolean match(char[] text) {
        int tLength = text.length;
        recurse(0, 0, text, tLength);
        return isMatched;
    }

    private void recurse(int tIndex, int pIndex, char[] text, int tLength) {
        //pruning。如果某一种情况下，text已经匹配表达式，那么其他的递归分支立刻终止。
        if (isMatched) {
            return;
        }
        //terminal condition.
        if (pIndex == pLength) {
            if (tIndex == tLength) {
                isMatched = true;
            }
            return;
        }
        //*, The letter behind * also need to be conformed.
        if (pattern[pIndex] == '*') {
            for (int i = 0; i < tLength - tIndex; ++i) {
                recurse(tIndex + i, pIndex + 1, text, tLength);
            }
        }
        //?. It can be conformed with a single letter or empty.
        if (pattern[pIndex] == '?') {
            recurse(tIndex + 1, pIndex + 1, text, tLength);
            recurse(tIndex, pIndex + 1, text, tLength);
        }
        //explicit letter.
        if (tIndex < tLength && text[tIndex] == pattern[pIndex]) {
            recurse(tIndex + 1, pIndex + 1, text, tLength);
        }
    }

    public static void main(String[] args) {
        Pattern pattern = new Pattern("acd?cabf".toCharArray());
        boolean result = pattern.match("acdcabf".toCharArray());
        System.out.println(result);
    }
}

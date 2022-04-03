package web.services.learn;

import java.util.ArrayList;
import java.util.List;

public class LoveFlyWithDream {

    /**
     * 微策略面试题，判断字符串是否平衡。
     *
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "{()}[]";
        List<String> result = new ArrayList<>();
        result.add(s1);
        LoveFlyWithDream loveFlyWithDream = new LoveFlyWithDream();
        List<String> res = loveFlyWithDream.braces(result);
        System.out.println(res);
    }


    private List<String> braces(List<String> values) {
        int length = values.size();
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < length; ++i) {
            String current = values.get(i);
            if (current.length() % 2 != 0) {
                resultList.add("NO");
            }
            if (isBalance(current)) {
                resultList.add("YES");
            } else {
                resultList.add("NO");
            }
        }
        return resultList;
    }

    private boolean isBalance(String value) {
        int length = value.length();
        boolean[][] isBan = new boolean[length][length];
        ///init
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < length; ++j) {
                if (i == j) {
                    isBan[i][j] = false;
                }
                if (i > j) {
                    isBan[i][j] = true;
                }
            }
        }

        for (int c = 1; c < length; ++c) {
            for (int r = c - 1; r >= 0; --r) {
                if (((c < 2 || isBan[r][c - 2]) && check(value.charAt(c - 1), value.charAt(c))) || (isBan[r + 1][c - 1] && check(value.charAt(r), value.charAt(c)))) {
                    isBan[r][c] = true;
                }
            }
        }
        return isBan[0][length - 1];
    }

    private boolean check(char left, char right) {
        return left == '(' && right == ')' || left == '{' && right == '}' || left == '[' && right == ']';
    }

    private static class Node {
        int data;
        Node left, right;

        public Node() {
        }

        public Node(int newData) {
            left = right = null;
            int data;
        }
    }
}

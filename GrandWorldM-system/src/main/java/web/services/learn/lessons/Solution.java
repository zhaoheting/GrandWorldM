package web.services.learn.lessons;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        List<String> result = getIP();
        result.stream().forEach(System.out::println);
        System.out.println(result.size());
    }

    private static List<String> getIP() {
        List<String> resultList = new ArrayList<>();
        dfs(0, "25525511135", resultList, new StringBuilder(), 0);
        return resultList;
    }

    private static void dfs(int index, String ipString, List<String> resultList, StringBuilder currentIp, int segment) {
        int len = ipString.length();
        if (index == len) {
            if (isValid(currentIp.toString())) {
                resultList.add(currentIp.toString());
            }
            return;
        }
        if (3 * (4 - segment) < len - index) {
            return;
        }
        for (int i = index + 1; i <= len && i <= index + 3; ++i) {
            int preLen = currentIp.length();
            currentIp.append(ipString, index, i);
            if (i != len) {
                currentIp.append(".");
            }
            dfs(i, ipString, resultList, currentIp, segment + 1);
            int currentLen = currentIp.length();
            currentIp.delete(preLen, currentLen);
        }
    }

    private static boolean isValid(String ipString) {
        String[] ipArr = ipString.split("\\.");
        int len = ipArr.length;
        if (len != 4) {
            return false;
        }
        boolean result = true;
        for (String s : ipArr) {
            int currentNum = Integer.parseInt(s);
            if (s.toCharArray()[0] == '0' && s.length() > 1) {
                return false;
            }
            result = currentNum >= 0 && currentNum <= 255;
            if (!result) {
                return false;
            }
        }
        return true;
    }
}

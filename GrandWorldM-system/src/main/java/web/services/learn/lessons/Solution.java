package web.services.learn.lessons;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    static boolean result = false;

    public static void main(String[] args) {
        String[] param = {"", ""};
    }

    private boolean check(String[] strings) {
        Map<String, Set<String>> map = new HashMap<>();
        int length = strings.length;
        for (int index = 0; index < length; ++index) {
            String key = strings[index].substring(0, strings[index].indexOf("="));
            String[] values = strings[index].substring(strings[index].indexOf("=") + 1).split("");
            Set<String> valueSet = new HashSet<>();
            Set<String> keySet = new HashSet<>();
            for (String value : values) {
                if (map.containsKey(value)) {
                    recurse(map, result, value, keySet);
                } else {
                    valueSet.add(value);
                }
            }
            map.put(key, valueSet);
        }
        return result;
    }

    private boolean recurse(Map<String, Set<String>> map, boolean result, String value, Set<String> keySet) {
        if (!map.containsKey(value)) {
            //recurse.
            return result;
        }
        Set<String> currentSet = map.get(value);
        for (String current : currentSet) {
            keySet.add(current);
            recurse(map, result, current, keySet);
            keySet.remove(current);
        }
        return result;
    }
}

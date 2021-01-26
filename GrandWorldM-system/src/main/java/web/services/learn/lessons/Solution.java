package web.services.learn.lessons;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
//        int[][] arr = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}
//                , {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int[][] graph = {{0, 1}, {0, 2}, {0, 15}, {0, 29}, {0, 30}, {0, 52}, {1, 3}, {1, 6}, {1, 10}, {1, 13}, {1, 56}, {2, 4}, {2, 27}, {3, 9}, {3, 43}, {4, 5}, {4, 20}, {4, 44}, {5, 8}, {5, 37}, {5, 41}, {5, 48}, {6, 7}, {6, 18}, {7, 42}, {8, 19}, {8, 33}, {8, 53}, {9, 11}, {9, 54}, {9, 60}, {10, 12}, {10, 16}, {10, 32}, {10, 49}, {12, 14}, {12, 50}, {13, 17}, {13, 23}, {13, 25}, {14, 63}, {15, 26}, {15, 31}, {15, 58}, {16, 38}, {17, 22}, {19, 21}, {19, 46}, {19, 55}, {20, 24}, {21, 35}, {22, 47}, {22, 62}, {24, 28}, {24, 34}, {25, 40}, {25, 61}, {29, 39}, {32, 57}, {33, 36}, {36, 42}, {42, 45}, {42, 51}, {44, 59}};
        System.out.print(dfs(graph, 41, 5, 64));


    }

    /**
     * @return
     */
    public static boolean dfs(int[][] graph, int start, int end, int n) {
        //build a list containing a few set.
        Map<Integer, Set<Integer>> adjacentListMap = new HashMap();
        for (int[] a : graph) {
            if (adjacentListMap.get(a[0]) == null) {
                adjacentListMap.put(a[0], new HashSet<>());
            }
            adjacentListMap.get(a[0]).add(a[1]);
        }
        boolean[] visited = new boolean[n];
        return backTrack(adjacentListMap, start, end, visited);
    }

//    private static List<List<Integer>> bfs(int[][] graph, int start, int end, int n) {
//
//    }

    private static boolean backTrack(Map<Integer, Set<Integer>> adjacentListMap, int start, int end, boolean[] visited) {
        Set<Integer> set = adjacentListMap.get(start);
        if (set != null && set.contains(end)) {
            return true;
        }
        for (Integer index : set) {
            if (adjacentListMap.containsKey(index)) {
                if (!visited[index]) {
                    return backTrack(adjacentListMap, index, end, visited);
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

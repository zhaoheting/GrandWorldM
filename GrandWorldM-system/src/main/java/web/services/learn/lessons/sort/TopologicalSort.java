package web.services.learn.lessons.sort;

import java.util.*;

/**
 * 微软面试题。
 * Excel is a very successful Microsoft product, used by billions of people around the world. A common problem our customers are facing is that they create Excel sheets which cannot be correctly evaluated. We want to create a "spell checker" to reduce these errors.
 * A simple Excel sheet contains columns AA to ZZ and rows between 00 to 99. For example, AA00 is the top-left cell and MN54 is approximately in the middle.
 * Each cell contains rational numbers or a mathematical expression, potentially referencing other cells. An empty cell can be assumed to contain the number 0.
 * An Excel sheet can be evaluated if it is possible to deterministically expand all mathematical expressions to rational numbers.
 * <p>
 * <p>
 * 总结解题技巧： 如果题目给的是正向临接表，就用BFS；如果给的逆向临接表，就用DFS。
 *
 * @author HeTing.Zhao
 * @since 2022/3/29
 */
public class TopologicalSort {

    public static void main(String[] args) {
        String[] inputData1 = {"AA00 = 10", "AB00 = (AA00 + AA01) * 15", "AA01 = 20 + AB00"};
        String[] inputData2 = {"AA00 = 10", "AA01 = AA00 + AB00", "AB00 = 15"};
        new TopologicalSort().canBeEvaluated(inputData1);
    }

    private void canBeEvaluated(String[] inputData) {
        Map<String, List<String>> stringToAdjacentList = new HashMap<>();
        Map<String, Integer> inDegreeMap = new HashMap<>();
        //bfs
        initForwardAdjacentForBFS(inputData, stringToAdjacentList, inDegreeMap);
        bfs(stringToAdjacentList, inDegreeMap, new ArrayList<>());
        //dfs
//        initReverseAdjacentForDFS(inputData, stringToAdjacentList);
//        Map<String, Boolean> isVisitedMap = new HashMap<>();
//        List<String> resultList = new ArrayList<>();
//        for (String key : stringToAdjacentList.keySet()) {
//            boolean hasCircle = dfs(key, isVisitedMap, stringToAdjacentList, resultList);
//            if (hasCircle) {
//                System.out.println("The Excel sheet cannot be evaluated.");
//                return;
//            }
//        }
//        System.out.println("The Excel sheet can be evaluated.");
    }


    /**
     * 拓扑排序解法1.需要先获取正向临接表和入度数量表。
     *
     * @param stringToAdjacentList
     * @param inDegreeMap
     * @param resultList           根据其数量判断是否有环。
     */
    private void bfs(Map<String, List<String>> stringToAdjacentList, Map<String, Integer> inDegreeMap, List<String> resultList) {
        if (stringToAdjacentList.size() != inDegreeMap.size()) {
            throw new RuntimeException("Some cells may be missed.");
        }
        Queue<String> queue = new LinkedList<>();
        for (String key : inDegreeMap.keySet()) {
            if (inDegreeMap.get(key) == 0) {
                queue.offer(key);
            }
        }
        while (!queue.isEmpty()) {
            String current = queue.poll();
            resultList.add(current);
            List<String> adjacentList = stringToAdjacentList.get(current);
            for (String key : adjacentList) {
                inDegreeMap.put(key, inDegreeMap.get(key) - 1);
                if (inDegreeMap.get(key) == 0) {
                    queue.offer(key);
                }
            }
        }
        if (resultList.size() != inDegreeMap.size()) {
            System.out.println("The Excel sheet can not be evaluated.");
        } else {
            System.out.println("The Excel sheet can evaluated.");
        }
    }

    /**
     * 拓扑排序解法2.如果要按顺序输出答案，则必须先获取逆临接表，才能用DFS。而本题只要判断是否有环，所以不必。不过本题恰巧给出的是逆向的临接表。
     *
     * @param key
     * @param isVisitedMap
     * @param reverseStringToAdjacentList
     * @param resultList                  本题只要判断是否有环，所以该参数可省略。
     * @return {@link boolean}
     */
    private boolean dfs(String key, Map<String, Boolean> isVisitedMap, Map<String, List<String>> reverseStringToAdjacentList, List<String> resultList) {
        if (isVisitedMap.containsKey(key) && isVisitedMap.get(key)) {
            return true;
        }
        List<String> adjacentList = reverseStringToAdjacentList.get(key);
        for (String currentValue : adjacentList) {
            isVisitedMap.put(key, true);
            if (dfs(currentValue, isVisitedMap, reverseStringToAdjacentList, resultList)) {
                return true;
            }
            isVisitedMap.put(key, false);

        }
        if (!resultList.contains(key)) {
            resultList.add(key);
        }
        return false;
    }

    /**
     * 为DFS算法构建逆向临接表。（本题给的就是逆向）
     *
     * @param inputData
     * @param stringToReverseAdjacentList
     */
    private void initReverseAdjacentForDFS(String[] inputData, Map<String, List<String>> stringToReverseAdjacentList) {
        int length = inputData.length;
        for (int i = 0; i < length; ++i) {
            String[] currentStrArray = inputData[i].split("=");
            String key = currentStrArray[0].trim();
            List<String> currentAdjacentList = stringToReverseAdjacentList.getOrDefault(key, new ArrayList<>());
            stringToReverseAdjacentList.putIfAbsent(key, currentAdjacentList);
            String value = currentStrArray[1];
            int valueLen = value.length();
            for (int j = 0; j < valueLen; ++j) {
                if (value.charAt(j) >= 'A' && value.charAt(j) <= 'Z') {
                    String currentCell = value.substring(j, j + 4);
                    //put into reverse adjacent list.
                    currentAdjacentList.add(currentCell);
                    //所有的临接表中的value也需要作为key加入临接表中。
                    stringToReverseAdjacentList.putIfAbsent(currentCell, new ArrayList<>());
                    j = j + 4;
                }
            }
        }
    }

    /**
     * 为BFS算法构建正向临接表。
     *
     * @param inputData
     * @param stringToForwardAdjacentList
     * @param inDegreeMap
     */
    private void initForwardAdjacentForBFS(String[] inputData, Map<String, List<String>> stringToForwardAdjacentList, Map<String, Integer> inDegreeMap) {
        int length = inputData.length;
        for (int i = 0; i < length; ++i) {
            String[] currentStrArray = inputData[i].split("=");
            String key = currentStrArray[0].trim();
            //初始化入度key-value
            inDegreeMap.putIfAbsent(key, 0);
            //初始化正向临接表不可以忽略临接表为空的key
            stringToForwardAdjacentList.putIfAbsent(key, new ArrayList<>());
            String value = currentStrArray[1];
            int valueLen = value.length();
            for (int j = 0; j < valueLen; ++j) {
                if (value.charAt(j) >= 'A' && value.charAt(j) <= 'Z') {
                    String currentCell = value.substring(j, j + 4);
                    //put into adjacent list.
                    List<String> currentAdjacentList = stringToForwardAdjacentList.getOrDefault(currentCell, new ArrayList<>());
                    currentAdjacentList.add(key);
                    stringToForwardAdjacentList.putIfAbsent(currentCell, currentAdjacentList);
                    //所有value也要作为key放入入度map，以便记录为入度为0的key。
                    inDegreeMap.putIfAbsent(currentCell, 0);
                    //根据key统计入度数量
                    inDegreeMap.put(key, inDegreeMap.getOrDefault(key, 0) + 1);
                    j = j + 3;
                }
            }
        }
    }
}

package web.services.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoveFlyWithDream {

    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        backTrack(0, candidates, target, resultList, new ArrayList<>());
        return resultList;
    }

    private void backTrack(int index, int[] candidates, int target, List<List<Integer>> resultList, List<Integer> currentList) {
        int currentSum = currentList.stream().mapToInt(x -> x).sum();
        if (currentSum == target) {
            resultList.add(new ArrayList<>(currentList));
            return;
        }
        int[] currentCandidates = Arrays.copyOfRange(candidates, index, candidates.length);
        int min = Arrays.stream(currentCandidates).min().getAsInt();
        if (target - currentSum < min) {
            return;
        }
        int length = candidates.length;
        for (int i = index; i < length; ++i) {
            if (currentSum + candidates[i] <= target) {
                currentList.add(candidates[i]);
                backTrack(i, candidates, target, resultList, currentList);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    private static class Node {
        int val;
        Node next;

        public Node() {
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}

package web.services.learn.lessons;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        int[] preorder = {1, 2};
        int[] inorder = {2, 1};
        TreeNode root = buildTree(preorder, inorder);
        levelTraverse(root).stream().map(node -> node.val).forEach(System.out::print);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        if (length == 0) {
            return null;
        }
        Map<Integer, Integer> map = initMap(inorder);
        return recurse(map, inorder, preorder, 0, length - 1, 0, length - 1);
    }

    private static TreeNode recurse(Map<Integer, Integer> map, int[] inorder, int[] preorder, int preLeftIndex, int preRightIndex, int inLeftIndex, int inRightIndex) {
        //terminal condition: only one single node in current sub tree.
        if (preLeftIndex > preRightIndex) {
            return null;
        }
        int currentRootVal = preorder[preLeftIndex];
        TreeNode currentRoot = new TreeNode(currentRootVal);
        //get the index of current root node in the inOrder array.
        int currentRootIndex = map.get(currentRootVal);
        currentRoot.left = recurse(map, inorder, preorder, preLeftIndex + 1, preLeftIndex + currentRootIndex - inLeftIndex, inLeftIndex, currentRootIndex - 1);
        currentRoot.right = recurse(map, inorder, preorder, preLeftIndex + currentRootIndex - inLeftIndex + 1, preRightIndex, currentRootIndex + 1, inRightIndex);
        return currentRoot;
    }

    //根据中序遍历的数组，构建一个map，它的key时数组中的元素，value时每个元素的index。以便使用时可以快速定位到根节点的位置。
    private static Map<Integer, Integer> initMap(int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        return map;
    }

    /**
     * 层序遍历。
     *
     * @param root
     * @return
     */
    private static List<TreeNode> levelTraverse(TreeNode root) {
        List<TreeNode> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode current = queue.poll();
                resultList.add(current);
                TreeNode left = current.left;
                TreeNode right = current.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(current);
                }
            }
        }
        return resultList;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

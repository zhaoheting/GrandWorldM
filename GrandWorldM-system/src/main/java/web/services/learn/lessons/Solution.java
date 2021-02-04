package web.services.learn.lessons;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        System.out.println();
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //根据中序遍历的结果得到所有可能的二叉树。
        int length = preorder.length;
        if(length == 0){
            return null;
        }
        Map<Integer, Integer> map = initMap(inorder);
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        root.left = recurse(0,rootIndex-1);
        root.right = recurse(map, inorder, preorder, 1, rootIndex, rootIndex + 1,inorder[length - 1]);

    }

    private void recurse(Map<Integer, Integer> map, int[] inorder, int[] preorder, int preLeftIndex, int preRightIndex, int inLeftIndex, int inRightIndex){
        int currentRootVal = preorder[preLeftIndex];
        int currentRootIndex = map.get(currentRootVal);
    }

    //根据中序遍历的数组，构建一个map，它的key时数组中的元素，value时每个元素的index。以便使用时可以快速定位到根节点的位置。
    private Map<Integer, Integer> initMap(int[] inorder){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; ++i){
            map.put(inorder[i], i);
        }
        return map;
    }

    public static  class TreeNode {
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

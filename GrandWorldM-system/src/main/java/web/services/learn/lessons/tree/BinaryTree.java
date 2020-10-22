package web.services.learn.lessons.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Common module to traverse binary tree.
 *
 * @param <E>
 */
public class BinaryTree<E> {
    BinaryTreeNode<E> root;

    public static void main(String[] args) {
        BinaryTreeNode node10 = new BinaryTreeNode(10, null, null);
        BinaryTreeNode node8 = new BinaryTreeNode(8, null, null);
        BinaryTreeNode node9 = new BinaryTreeNode(9, null, node10);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, node8, node9);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.root = new BinaryTreeNode(1, node2, node3);
        System.out.println("previous order:");
        binaryTree.preOrder();
        System.out.println();
        binaryTree.preOrderNoRecursive();
        System.out.println("\nin order:");
        binaryTree.inOrder();
        System.out.println();
        binaryTree.inOrderNoRecursive();
        System.out.println("\npost order:");
        binaryTree.postOrder();
        System.out.println("\nlevel order:");
        binaryTree.levelOrder();
        System.out.println("\ntraverse the tree in 5 levels:");
        List<List<Integer>> result = binaryTree.levelOrderInMultiList();
        for (int k = 0; k < result.size(); k++) {
            List<Integer> currentLevel = result.get(k);
            for (int j = 0; j < currentLevel.size(); j++) {
                System.out.print(currentLevel.get(j) + "\t");
            }
            System.out.println();
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    //previous order.
    private void preOrder(BinaryTreeNode<E> node) {
        if (node != null) {
            System.out.print(node.getData() + "\t");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    //前序遍历非递归的方式
    public void preOrderNoRecursive() {
        BinaryTreeNode<E> node = root;
        Stack<BinaryTreeNode<E>> nodeStack = new Stack<>();
        while (true) {
            while (node != null) {
                System.out.print(node.getData() + "\t");
                nodeStack.push(node);
                node = node.getLeft();
            }
            if (nodeStack.empty()) {
                break;
            }
            node = nodeStack.pop().getRight();
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    //in order.
    private void inOrder(BinaryTreeNode<E> node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getData() + "\t");
            inOrder(node.getRight());
        }
    }

    public void inOrderNoRecursive() {
        BinaryTreeNode<E> node = root;
        Stack<BinaryTreeNode<E>> nodeStack = new Stack<>();
        while (true) {
            while (node != null) {
                nodeStack.push(node);
                node = node.getLeft();
            }
            if (nodeStack.empty()) {
                return;
            }
            node = nodeStack.pop();
            System.out.print(node.getData() + "\t");
            node = node.getRight();
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    //post order.
    private void postOrder(BinaryTreeNode<E> node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getData() + "\t");
        }
    }

    /**
     * Traverse binary tree in level order and all the numbers of one level are saved in a single array.
     */
    public List<List<E>> levelOrderInMultiList() {
        BinaryTreeNode<E> node = root;
        List<List<E>> result = new ArrayList<>();
        if (node == null) {
            return result;
        }
        Queue<BinaryTreeNode<E>> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            List<E> currentLevel = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                BinaryTreeNode<E> currentNode = queue.poll();
                currentLevel.add(currentNode.getData());
                BinaryTreeNode<E> left = currentNode.getLeft();
                BinaryTreeNode<E> right = currentNode.getRight();
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

    /**
     * Traverse binary tree in level order.
     */
    public void levelOrder() {
        BinaryTreeNode<E> node = root;
        Queue<BinaryTreeNode<E>> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            BinaryTreeNode<E> temp = queue.poll();
            System.out.print(temp.getData() + "\t");
            BinaryTreeNode<E> left = temp.getLeft();
            BinaryTreeNode<E> right = temp.getRight();
            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            }
        }
    }
}

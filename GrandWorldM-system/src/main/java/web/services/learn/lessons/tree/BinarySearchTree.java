package web.services.learn.lessons.tree;

/**
 * Implement operations with iteration.
 * not support lazy deletion and all the duplicated data will be save in the right sub tree(treated as larger data).
 */
public class BinarySearchTree {
    private BinarySearchNode root;

    public void delete(int data) {
        if (root == null) {
            throw new RuntimeException("The tree is null.");
        }
        delete(data, root);
    }

    public void insert(int data) {
        if (root == null) {
            root = new BinarySearchNode(data);
            return;
        }
        BinarySearchNode node = root;
        while (node != null) {
            if (node.data > data) {
                if (node.left == null) {
                    node.left = new BinarySearchNode(data);
                    break;
                }
                node = node.left;
            } else {//the duplicated data will be treated as larger data.
                if (node.right == null) {
                    node.right = new BinarySearchNode(data);
                    break;
                }
                node = node.right;
            }
        }
    }

    public boolean contain(int data) {
        if (root == null) {
            throw new RuntimeException("The tree is empty.");
        }
        BinarySearchNode current = root;
        while (current != null) {
            if (current.data == data) {
                return true;
            } else if (current.data > data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }


    private int findMin(BinarySearchNode node) {
        if (node == null) {
            throw new RuntimeException("The tree is null.");
        }
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    private int findMax(BinarySearchNode node) {
        if (node == null) {
            throw new RuntimeException("The tree is null.");
        }
        while (node.right != null) {
            node = node.right;
        }
        return node.data;
    }

    /**
     * 不会用迭代实现。
     *
     * @param data
     * @param node
     * @return
     */
    private BinarySearchNode delete(int data, BinarySearchNode node) {
        if (node == null) {
            return null;
        }
        if (node.data > data) {
            node.left = delete(data, node.left);
        } else if (node.data < data) {
            node.right = delete(data, node.right);
        } else if (node.left != null && node.right != null) {
            int replaceData = findMin(node.right);
            node.data = replaceData;
            node.right = delete(replaceData, node.right);
        } else {
            node = (node.left != null) ? node.left : node.right;
        }
        return node;
    }

    private class BinarySearchNode {
        private int data;
        private BinarySearchNode left;
        private BinarySearchNode right;

        public BinarySearchNode(int data) {
            this.data = data;
        }

        public BinarySearchNode(int data, BinarySearchNode left, BinarySearchNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}

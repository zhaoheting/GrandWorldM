package web.services.learn.lessons.tree;

public class BinarySearchTree {
    private BinarySearchNode root;

    public BinarySearchNode find(int data) {
        if (root == null) {
            return null;
        }
        BinarySearchNode node = root;
        while (node != null) {
            if (node.data == data) {
                return node;
            } else if (node.data > data) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
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
            } else if (node.data < data) {
                if (node.right == null) {
                    node.right = new BinarySearchNode(data);
                    break;
                }
                node = node.right;
            } else {

            }
        }
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

    public void delete(int data) {
        if (root == null) {
            throw new RuntimeException("The tree is null.");
        }
        BinarySearchNode node = root;
        while (node != null && node.data != data) {
            if (node.data > data) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        if (node == null) {
            throw new RuntimeException("Can't find this data.");
        }
        //there is a single sub node or no sub node.
        if (node.left != null && node.right != null) {
            int replaceData = findMin(node.right);
            node.data = replaceData;
            delete(replaceData);
        }
        //there is two sub nodes.
        if (node.left != null) {
            node = node.left;
        } else if (node.right != null) {
            node = node.right;
        } else {
            node = null;
        }
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

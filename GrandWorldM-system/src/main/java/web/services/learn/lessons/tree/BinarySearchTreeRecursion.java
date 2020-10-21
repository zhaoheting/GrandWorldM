package web.services.learn.lessons.tree;

/**
 * Implement operations with recursion.
 * support lazy deletion and duplicated value in every node.
 */
public class BinarySearchTreeRecursion {
    private Node root;
    private int theSize;
    private int deletedAmount;

    public void insert(int data) {
        insert(data, root);
    }

    public boolean contain(int data) {
        if (root == null) {
            throw new RuntimeException("The tree doesn't contain this data.");
        }
        return contain(data, root);
    }

    public boolean delete(int data) {
        if (root == null) {
            throw new RuntimeException("The tree is empty.");
        }
        return delete(data, root);
    }

    private boolean delete(int data, Node node) {
        checkDeletion();
        if (node == null) {
            return false;
        }
        if (node.data == data) {
            if (node.occurrence != 0) {
                node.occurrence--;
                return true;
            } else {
                return false;
            }
        } else if (node.data > data) {
            return delete(data, node.left);
        } else {
            return delete(data, node.right);
        }
    }

    private void checkDeletion() {
        if (this.deletedAmount == theSize) {
            new Thread(() -> {
                removeNode(root);
            }).start();
        }
    }

    private void removeNode(Node node) {
        if (node != null) {
            Node left = node.left;
            Node right = node.right;
            if (node.occurrence == 0) {
                if (left != null && right != null) {
                    Node min = findMin(right);
                    if (min == null) {
                        node.right = null;
                        removeNode(node);
                    }
                } else {
                    node = (left != null) ? left : right;
                    removeNode(node);
                }
            } else {
                removeNode(left);
                removeNode(right);
            }
        }
    }

    public int findMin() {
        return findMin(root).data;
    }

    private Node findMin(Node node) {
        Node min = null;
        if (node != null) {
            min = findMin(node.left);
            if (min == null) {
                if (node.occurrence != 0) {
                    min = node;
                } else {
                    min = findMin(node.right);
                }
            }
        }
        return min;
    }

    private boolean contain(int data, Node node) {
        if (node == null) {
            return false;
        }
        if (node.data == data) {
            if (node.occurrence != 0) {
                return true;
            } else {
                return false;
            }
        } else if (node.data > data) {
            return contain(data, node.left);
        } else {
            return contain(data, node.right);
        }
    }

    private Node insert(int data, Node node) {
        if (node == null) {
            node = new Node(data);
        } else {
            if (node.data > data) {
                node.left = insert(data, node.left);
            } else if (node.data < data) {
                node.right = insert(data, node.right);
            } else {
                node.occurrence++;
            }
        }
        return node;
    }

    private static class Node {
        private int data;
        private Node left;
        private Node right;
        private int occurrence;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}

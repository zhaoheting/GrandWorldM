package web.services.learn.lessons.tree;

/**
 * The node of binary tree.
 */
public class BinaryTreeNode<E> {
    public E data;
    public BinaryTreeNode<E> left;
    public BinaryTreeNode<E> right;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(E data) {
        this.data = data;
    }

    public BinaryTreeNode(E data, BinaryTreeNode<E> left, BinaryTreeNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public BinaryTreeNode<E> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<E> left) {
        this.left = left;
    }

    public BinaryTreeNode<E> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<E> right) {
        this.right = right;
    }
}

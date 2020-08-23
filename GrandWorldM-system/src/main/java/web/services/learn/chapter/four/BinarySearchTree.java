package web.services.learn.chapter.four;

import org.hibernate.type.AnyType;

/**
 * The property that makes a binary tree into binary search tree is that for every node X, in the tree
 * the values of all the items in the left subtree are smaller than value of X, and the values of
 * all the items in the right subtree are larger than the value of X.
 *
 * @author heting.zhao
 * @since 23/08/2020
 */
public class BinarySearchTree {

    /**
     * Node definition of tree.
     *
     * @param <AnyType>
     */
    private static class BinaryNode<AnyType> {

        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;

        public BinaryNode(AnyType element, BinaryNode<AnyType> left, BinaryNode<AnyType> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }
}

package web.services.learn.chapter.four;

import com.alibaba.druid.sql.visitor.functions.Bin;
import org.hibernate.type.AnyType;

/**
 * The property that makes a binary tree into binary search tree is that for every node X, in the tree
 * the values of all the items in the left subtree are smaller than value of X, and the values of
 * all the items in the right subtree are larger than the value of X.
 *
 * @author heting.zhao
 * @since 23/08/2020
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {

    /**
     * The root node of the tree.
     */
    private BinaryNode<AnyType> root;

    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    private boolean contains(AnyType x, BinaryNode<AnyType> node) {
        if (node == null) {
            return false;
        }
        int compareResult = x.compareTo(node.element);
        if (compareResult > 0) {
            return contains(x, node.right);
        } else if (compareResult < 0) {
            return contains(x, node.left);
        } else {
            return true;
        }
    }

    /**
     * Find minimum using tail recursion.
     *
     * @param node
     * @return
     */
    public BinaryNode<AnyType> findMin(BinaryNode<AnyType> node) {
//        if(node == null){
//            return null;
//        } else {
//            BinaryNode<AnyType> leftChild = node.left;
//            if (leftChild == null) {
//                return node;
//            } else {
//                return findMin(leftChild);
//            }
//        }
        //优化后的代码
        if (node != null && node.left != null) {
            return findMin(node.left);
        }
        return node;
    }

    /**
     * Replace tail recursion with a while loop.
     *
     * @param node
     * @return
     */
    public BinaryNode<AnyType> findMax(BinaryNode<AnyType> node) {
        if (node != null) {
            while (node.right != null) {
                node = node.right;
            }
        }
        return node;
    }

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

package web.services.learn.chapter.four;

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
    /**
     * 当前没被标记为已删除的节点数。
     */
    private int theSize;
    /**
     * 已经被懒惰删除的节点数。（标记为删除，但没有真的删除）
     */
    private int deletedSize;
    private BinaryNode<AnyType> min;
    private BinaryNode<AnyType> max;


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

    public BinaryNode<AnyType> insert(AnyType x) {
        return insert(x, root);
    }

    /**
     * Insert x into a binary search tree root with node.
     *
     * @param x
     * @param node The root node of a binary search tree.
     * @return
     */
    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> node) {
        if (node == null) {
            //节点为空的情况是递归的边界情况，每个insert操作都会终止于当前node为空时。
            node = new BinaryNode<>(x);
        } else {
            int compareResult = x.compareTo(node.element);
            if (compareResult < 0) {
                node.left = insert(x, node.left);
            } else if (compareResult > 0) {
                node.right = insert(x, node.right);
            } else {
                //如果现已在tree中，则将记录出现次数的field自增1。
                //有的情况下compareTo()方法的结果为零并不能代表这两个数据是完全一致的，同一个数据。它们可能只是该方法关注的那个比较条件
                //一样，此时我们可以把这两个对象放到同一个辅助数据结构中，比如说list或者一个新的空树，然后把这个辅助数据结构放到当前节点上。
                //比如hashmap解决哈希冲突的算法，就是这样一个逻辑。
                node.occurrence++;
            }
        }
        return node;
    }

    public BinaryNode<AnyType> remove(AnyType x) {

    }

    /**
     * A inefficient way to remove,comparing with lazy deletion.
     *
     * @return
     */
    private BinaryNode<AnyType> removeNode(AnyType x, BinaryNode<AnyType> node) {
        if (node == null) {
            throw new RuntimeException("The tree is null, can't find x.");
        }
        int comparedResult = x.compareTo(node.element);
        if (comparedResult < 0) {
            removeNode(x, node.left);
        } else if (comparedResult > 0) {
            removeNode(x, node.right);
        } else {
            /**
             * 当前找到的节点，既有左子树，也有右子树。
             */
            if (node.left != null && node.right != null) {

            }else {//包含了当前节点是叶子，以及当前节点只有一个子节点的情况。
                node = (node.left != null) ? node.left: node.right;
            }
        }
    }

    /**
     * Lazy deletion.
     * 懒惰删除（英文：lazy deletion）指的是从一个散列表（也称哈希表）中删除元素的一种方法。
     * 在这个方法中，删除仅仅是指标记一个元素被删除，而不是整个清除它。
     * 被删除的位点在插入时被当作空元素，在搜索之时被当作已占据。
     *
     * @param x
     * @param node
     * @return
     */
    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> node) {

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
        //优化，记录树中该节点出现次数。
        int occurrence;
        int deleteFlag;

        public BinaryNode(AnyType element) {
            this(element, null, null, 1, 1);
        }

        public BinaryNode(AnyType element, BinaryNode<AnyType> left, BinaryNode<AnyType> right) {
            this(element, left, right, 1, 1);
        }

        private BinaryNode(AnyType element, BinaryNode<AnyType> left,
                           BinaryNode<AnyType> right, int occurrence, int deleteFlag) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.occurrence = occurrence;
            this.deleteFlag = deleteFlag;
        }
    }
}

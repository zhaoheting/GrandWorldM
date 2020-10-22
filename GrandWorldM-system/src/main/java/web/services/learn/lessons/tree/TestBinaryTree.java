package web.services.learn.lessons.tree;

/**
 * Test case for binary search tree.
 */
public class TestBinaryTree {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(15);
        tree.insert(13);
        tree.insert(20);
        tree.insert(16);
        tree.preOrder();
        System.out.println();
        tree.inOrder();
        System.out.println();
        tree.postOrder();
        System.out.println();
        System.out.println(tree.contain(15));
        System.out.println(tree.contain(17));
        tree.delete(1);
        System.out.println();
        tree.inOrder();
        tree.delete(20);
        System.out.println();
        tree.inOrder();
        tree.delete(5);
        System.out.println();
        tree.preOrder();
        System.out.println();
        tree.inOrder();
        System.out.println();
        tree.postOrder();
    }
}

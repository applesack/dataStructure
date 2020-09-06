package demo.数据结构.树;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月02日 15:36
 */
public class Test {

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(5);
        tree.insert(3);
        tree.insert(1);
        tree.insert(4);
        tree.insert(7);
        tree.insert(6);
        tree.insert(8);

        tree.printTree();
    }

    @org.junit.Test
    public void testAVL() {
        AVLTree<Integer> AVLtree = new AVLTree<>();
        BinarySearchTree tree = new BinarySearchTree();

        for (int i = 0; i<1000; i++) {
            AVLtree.insert(i);
            tree.insert(i);
        }

//        tree.printTree();
        System.out.println("普通二叉树-------");
        System.out.println("左子树" + tree.getRoot().rightHeight());
        System.out.println("右子树"+tree.getRoot().leftHeight());

        System.out.println("AVL二叉树-------");
        System.out.println("左子树" + AVLtree.getRoot().rightHeight());
        System.out.println("左子树-右子树" + AVLtree.getRoot().left.rightHeight());
        System.out.println("左子树-左子树" + AVLtree.getRoot().left.leftHeight());
        System.out.println("右子树" + AVLtree.getRoot().leftHeight());
    }
}

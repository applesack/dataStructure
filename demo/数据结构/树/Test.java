package 数据结构.树;

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
        AVLTree<Integer> tree = new AVLTree<>();

        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(6);

        tree.printTree();
        System.out.println("在没有做平衡处理前树的高度" +
                tree.getRoot().height());
    }
}

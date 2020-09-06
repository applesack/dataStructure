package offer.part4;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月05日 15:57
 */
public class P27 {

    @Test
    public void testFunc() {
        BinaryNode root = new BinaryNode(8);
        root.left = new BinaryNode(6);
        root.right = new BinaryNode(10);
        root.left.left = new BinaryNode(5);
        root.left.right = new BinaryNode(7);
        root.right.left = new BinaryNode(9);
        root.right.right = new BinaryNode(11);

        System.out.println(root);
        MirrorRecursively(root);
        System.out.println(root.toString());
    }

    private void MirrorRecursively(BinaryNode node) {
        if (node == null)
            return;

        if (node.left == null && node.right == null)
            return;

        // 交换左右节点的位置
        BinaryNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        if (node.left != null)
            MirrorRecursively(node.left);
        if (node.right != null)
            MirrorRecursively(node.right);
    }

    private class BinaryNode {
        int        value;
        BinaryNode left;
        BinaryNode right;

        public BinaryNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "BinaryNode{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}

package part4;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月05日 16:17
 */
public class P28 {

    @Test
    public void testFunc() {
        BinaryNode root = new BinaryNode(8);
        root.left = new BinaryNode(6);
        root.right = new BinaryNode(6);

        root.left.left = new BinaryNode(7);
        root.right.right = new BinaryNode(0);

        System.out.println(isSymmetrical(root));
    }

    private boolean isSymmetrical(BinaryNode node) {
        if (node == null) return true;

        return isSymmetrical(node.left, node.right);
    }

    private boolean isSymmetrical(BinaryNode left, BinaryNode  right) {
        if (left == null && right == null)
            return true;
        // 左右节点其中一个为空
        if (left == null || right == null)
            return false;

        if (left.value != right.value)
            return false;

        return isSymmetrical(left.left, right.right) &&
                    isSymmetrical(left.right, right.left);
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

package part4;

import org.junit.Test;

import java.util.Stack;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月13日 16:55
 */
public class P34 {

    @Test
    public void testFunc() {
        BinaryTreeNode root = new BinaryTreeNode(8);
        root.left = new BinaryTreeNode(6);
        root.right = new BinaryTreeNode(10);
        root.left.left = new BinaryTreeNode(5);
        root.left.right = new BinaryTreeNode(7);
        root.right.left = new BinaryTreeNode(9);
        root.right.right = new BinaryTreeNode(11);
        findPath(root, 19);
    }

    private void findPath(BinaryTreeNode root, int expectedSum) {
        if (root == null)
            return;
        Stack<Integer> path = new Stack<>();
        int res = findPath(root, expectedSum, 0, path);

        if (res != 0)
            System.out.println("path not found");
    }

    private int findPath(BinaryTreeNode node,
                         int expectedSum,
                         int currentSum,
                         Stack<Integer> path)
    {
        currentSum += node.val;
        path.push(node.val);

        boolean isLeaf = (node.left == null) && (node.right == null);
        if (currentSum == expectedSum && isLeaf) {
            System.out.println("A path is found: ");
            while (!path.isEmpty()) {
                System.out.print(path.pop() + " ");
            }
            return 0;
        }

        if (node.left != null)
            return findPath(node.left, expectedSum, currentSum, path);
        if (node.left != null)
            return findPath(node.right, expectedSum, currentSum, path);

        if (!path.isEmpty())
            path.pop();
        return -1;
    }

    private class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int val) {
            this.val = val;
        }
    }
}

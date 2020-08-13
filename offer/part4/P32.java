package part4;

import org.junit.Test;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月13日 16:01
 */
public class P32 {

    @Test
    public void testFunc() {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(5);
        root.right = new BinaryTreeNode(12);
        root.left.left = new BinaryTreeNode(5);
        root.left.right = new BinaryTreeNode(7);
        root.right.left = new BinaryTreeNode(9);
        root.right.right = new BinaryTreeNode(11);

        printFromTopToBottom(root);
    }

    // 题目一: 一行一行打印二叉树
    private void printFromTopToBottom(BinaryTreeNode root) {
        if (root == null) return;

        Deque<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (queue.size() != 0) {
            BinaryTreeNode node = queue.pollFirst();
            System.out.print(node.value + " ");

            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }

    // 题目二: 一列一列打印二叉树
    private void print(BinaryTreeNode root) {
        if (root == null) return;
    }

    private class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }
    }
}

package leetcodes.nums;

import leetcodes.ds.TreeNode;
import leetcodes.ds.util.TreeNodeUtil;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月03日 19:36
 */
public class P111 {

    @Test
    public void testFunc() {
        TreeNode root = TreeNodeUtil.initTree()
                .setRoot(3)
                .addLevel(9, 10)
                .addLevel(null, null, 15, 7)
                .build();
        System.out.println(minDepth(root));
    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        int depth = 1;

        while (!deque.isEmpty()) {
            TreeNode tmp = deque.pollFirst();
            if (tmp.left == null && tmp.right == null)
                return depth;
            if (tmp.left != null)
                deque.addLast(tmp.left);
            if (tmp.right != null)
                deque.addLast(tmp.right);
            depth++;
        }

        return depth;
    }

}

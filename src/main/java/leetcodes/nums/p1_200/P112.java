package leetcodes.nums.p1_200;

import leetcodes.ds.TreeNode;
import leetcodes.ds.util.TreeNodeUtil;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月16日 23:12
 */
public class P112 {

    @Test
    public void testFunc() {
        TreeNode root = TreeNodeUtil.initTree()
                .setRoot(5)
                .addLevel(4, 8)
                .addLevel(11, null, 13, 4)
                .addLevel(7, 2, null, null, null, null, null, 1)
                .build();
        System.out.println(hasPathSum(root, 22));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        return hasPathSumCore(root, 0, sum);
    }

    private boolean hasPathSumCore(TreeNode node, int curSum, int target) {
        curSum += node.val;
        if (node.left == null && node.right == null) {
            return curSum == target;
        }

        boolean l = false, r = false;
        if (node.left != null)
            l = hasPathSumCore(node.left, curSum, target);
        if (node.right != null)
            r = hasPathSumCore(node.right, curSum, target);
        return l || r;
    }

}
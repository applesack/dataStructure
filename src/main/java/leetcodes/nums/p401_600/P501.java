package leetcodes.nums.p401_600;

import leetcodes.adt.TreeNode;
import leetcodes.adt.util.TreeNodeUtil;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年11月05日 19:27
 */
public class P501 {

    @Test
    public void testFunc() {
        TreeNode root = TreeNodeUtil.initTree()
                .setRoot(1)
                .addLevel(null, 2)
                .addLevel(null, null, 2, null)
                .build();
        System.out.println(findMode(root)[0]);
    }

    public int[] findMode(TreeNode root) {
        int[] res = new int[1];
        res[0] = root.val;
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode node, int[] res, int count) {
        if (node.val == res[0]) {
            count++;
        } else {
            count = count == 1 ? 1 : --count;
            res[0] = node.val;
        }

        if (node.left != null)
            dfs(node.left, res, count);
        if (node.right != null)
            dfs(node.right, res, count);
    }

}

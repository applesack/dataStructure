package leetcodes.nums.p601_800;

import leetcodes.adt.TreeNode;
import leetcodes.adt.util.TreeNodeUtil;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年11月07日 12:08
 */
public class P606 {

    @Test
    public void testFunc() {
        TreeNode root = TreeNodeUtil.initTree()
                .setRoot(1)
                .addLevel(2, 3)
                .addLevel(null, null, 4, null)
                .build();
        System.out.println(tree2str(root));
    }

    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        dfs(t, sb);
        return sb.toString();
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        if (node == null)
            return;
        sb.append(node.val);
        if (node.left == null && node.right == null)
            return;
        sb.append('(');
        dfs(node.left, sb);
        sb.append(')');
        if (node.right != null) {
            sb.append('(');
            dfs(node.right, sb);
            sb.append(')');
        }
    }

}

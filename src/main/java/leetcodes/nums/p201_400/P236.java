package leetcodes.nums.p201_400;

import leetcodes.ds.TreeNode;
import leetcodes.ds.util.TreeNodeUtil;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月09日 21:54
 */
public class P236 {

    @Test
    public void testFunc() {
        TreeNode root = TreeNodeUtil.initTree()
                .setRoot(1)
                .addLevel(2, 3)
                .addLevel(4, 5, 6, 7)
                .addLevel(8, 9, 10, 11, 12, 13, 14, 15)
                .build();
        TreeNode p = root.left.left.right;
        TreeNode q = root.left.right.right;
        System.out.println(lowestCommonAncestor(root, p, q).val);
    }

    // 假如此题有解，则ans将指向输入的两个节点的最近公共祖先节点
    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return false;
        boolean lSon = dfs(node.left, p, q);
        boolean rSon = dfs(node.right, p, q);
        /**
         * 条件：
         * (lSon && rSon): 假如左节点或者右节点都含有p和q, 那么当前节点就是答案的解。
         * (node.val == p.val || node.val == q.val) && (lSon || rSon)):
         *      假如左右子树包含p或者q，而当前节点等于另一个节点，那么当前节点满足最近公共祖先的条件。
         */
        if ((lSon && rSon) ||
                (node.val == p.val || node.val == q.val) && (lSon || rSon))
            ans = node;
        //
        return lSon || rSon || node.val == p.val || node.val == q.val;
    }

}

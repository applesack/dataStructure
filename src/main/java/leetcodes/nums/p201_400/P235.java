package leetcodes.nums.p201_400;

import leetcodes.adt.TreeNode;
import leetcodes.adt.util.TreeNodeUtil;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月10日 11:30
 */
public class P235 {

    @Test
    public void testFunc() {
        TreeNode root = TreeNodeUtil.initTree()
                .setRoot(6)
                .addLevel(2, 8)
                .addLevel(0, 4, 7, 9)
                .addLevel(null, null, 3, 5)
                .build();
        TreeNode p, q;
        p = root.left;
        q = root.right;
        System.out.println(lowestCommonAncestor(root, p, q).val);
    }

    /**
     * 当一个节点比任意一个节点(p || q)小，比另外一个节点大，那么当前节点符合条件
     * 或者当前节点比任意节点大或者小，而当前节点正好是另一个节点，则当前节点也符合条件
     * @param root 根节点
     * @param p p
     * @param q q
     * @return 符合条件的节点，假如在树中没有目标节点则返回null
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private TreeNode ans;

    // 深度优先搜索
    private boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return false;
        // 查找左右节点是否有满足条件的结果
        boolean lSon = dfs(node.left, p, q);
        boolean rSon = dfs(node.right, p, q);

        if ((lSon && rSon) || ((lSon || rSon) && (node == p || node == q)))
            ans = node;
        return lSon || rSon || node == p || node == q;
    }

}

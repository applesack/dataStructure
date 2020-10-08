package leetcodes.nums.p201_400;

import leetcodes.ds.TreeNode;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月08日 11:25
 */
public class P226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        invertTreeCore(root);
        return root;
    }

    private void invertTreeCore(TreeNode root) {
        TreeNode tmp;
        // 交换左右节点
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        if (root.left != null)
            invertTreeCore(root.left);
        if (root.right != null)
            invertTreeCore(root.right);
    }
}

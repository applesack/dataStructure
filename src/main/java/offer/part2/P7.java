package offer.part2;

import leetcodes.adt.TreeNode;
import leetcodes.adt.util.TreeNodeUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年11月14日 12:06
 */
public class P7 {

    @Test
    public void testFunc() {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};

        TreeNode root = construct(preorder, inorder);
        TreeNodeUtil.PrintTree(root);
    }

    // 根据前序和中序构建二叉树
    public TreeNode construct(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null)
            return null;
        if (preorder.length != inorder.length)
            return null;
        if (preorder.length <= 0)
            return null;
        return construct0(preorder, inorder);
    }

    private TreeNode construct0(int[] preorder, int[] inorder) {
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        int idx = -1;
        for (int i = 0; i<inorder.length; i++) {
            if (inorder[i] == rootVal) {
                idx = i;
                break;
            }
        }
        // 生成左子树
        if (idx > 0) {
            root.left = construct0(
                    Arrays.copyOfRange(preorder, 1, idx + 1),
                    Arrays.copyOfRange(inorder, 0, idx)
            );
        }
        // 生成右子树
        if (idx < preorder.length - 1) {
            root.right = construct0(
                    Arrays.copyOfRange(preorder, idx + 1, preorder.length),
                    Arrays.copyOfRange(inorder, idx + 1, inorder.length)
            );
        }
        return root;
    }

}

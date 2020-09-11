package leetcodes.nums;

import leetcodes.ds.TreeNode;
import leetcodes.ds.util.TreeNodeUtil;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月03日 12:33
 */
public class P101 {

    @Test
    public void testFunc() {
        TreeNode theTree = TreeNodeUtil.initTree()
                .setRoot(1)
                .addLevel(2, 2)
                .addLevel(3, 4, 4, 3)
                .build();

        System.out.println(isSymmetric(theTree));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode r1, TreeNode r2) {

        if (r1 == null && r2 == null)
            return true;

        if (r1 == null || r2 == null)
            return false;

        if (r1.val != r2.val)
            return false;

        return compare(r1.left, r2.right) && compare(r1.right, r2.left);
    }

}

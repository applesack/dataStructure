package leetcodes.nums;

import leetcodes.nums.ds.TreeNode;
import leetcodes.nums.ds.util.TreeNodeUtil;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月03日 19:13
 */
public class P104 {

    @Test
    public void testFunc() {
        TreeNode root = TreeNodeUtil.initTree()
                .setRoot(3)
                .addLevel(2, 20)
                .addLevel(null, null, 15, 7)
                .addLevel(null, null, null, null, 12, 12, 12)
                .build();
        System.out.println(maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

}

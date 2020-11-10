package leetcodes.nums.p1_200;

import leetcodes.adt.TreeNode;
import leetcodes.adt.util.TreeNodeUtil;
import org.junit.Test;

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
                .addLevel(12, 11, null, null)
                .build();
        System.out.println(minDepth(root));
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1+Math.min(minDepth(root.left), minDepth(root.right));
    }

}

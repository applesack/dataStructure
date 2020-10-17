package leetcodes.nums.p1_200;

import leetcodes.ds.TreeNode;
import leetcodes.ds.util.TreeNodeUtil;
import org.junit.Test;

import java.util.*;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月17日 17:22
 */
public class P94 {

    @Test
    public void testFunc() {
        TreeNode root = TreeNodeUtil.initTree()
                .setRoot(1)
                .addLevel(null, 2)
                .addLevel(null, null, 3, null)
                .build();
        System.out.println(inorderTraversal(root));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            // 将该节点的所有左子节点依次压入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }

        return res;
    }

}

package leetcodes.nums.p1_200;

import leetcodes.ds.TreeNode;
import leetcodes.ds.util.TreeNodeUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月17日 21:52
 */
public class P113 {

    @Test
    public void testFunc() {
        TreeNode root = TreeNodeUtil.initTree()
                .setRoot(5)
                .addLevel(4, 8)
                .addLevel(11, null, 13, 4)
                .addLevel(7, 2, null, null, null, null, 5, 1)
                .build();
        List<List<Integer>> res = pathSum(root, 22);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        pathSumCore(res, root, new LinkedList<>(), 0, sum);
        return res;
    }

    public void pathSumCore(List<List<Integer>> res, TreeNode node,
                            LinkedList<Integer> curPath, int curSum, int target) {
        curSum += node.val;
        curPath.addLast(node.val);
        if (curSum == target && node.left == null && node.right == null) {
            res.add(new ArrayList<>(curPath));
            return;
        }

        if (node.left != null) {
            pathSumCore(res, node.left, curPath, curSum, target);
            curPath.removeLast();
        }
        if (node.right != null) {
            pathSumCore(res, node.right, curPath, curSum, target);
            curPath.removeLast();
        }
    }
}

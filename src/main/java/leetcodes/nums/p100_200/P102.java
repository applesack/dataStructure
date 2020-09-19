package leetcodes.nums.p100_200;

import leetcodes.ds.TreeNode;
import leetcodes.ds.util.TreeNodeUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月17日 9:56
 */
public class P102 {

    @Test
    public void testFunc() {
        TreeNode root = TreeNodeUtil.initTree()
                .setRoot(3)
                .addLevel(9, 20)
                .addLevel(null, null, 15, 7)
                .build();
        List<List<Integer>> res = levelOrder(root);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        int nodeCount = 1;

        while (!deque.isEmpty()) {
            ArrayList<Integer> then = new ArrayList<>();
            int thatCount = 0;
            for (int i = 0; i<nodeCount; i++) {
                TreeNode thatNode = deque.pollFirst();
                then.add(thatNode.val);
                if (thatNode.left != null) {
                    thatCount += 1;
                    deque.addLast(thatNode.left);
                }
                if (thatNode.right != null) {
                    thatCount += 1;
                    deque.addLast(thatNode.right);
                }
            }
            nodeCount = thatCount;
            res.add(then);
        }

        return res;
    }

}

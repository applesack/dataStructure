package leetcodes.nums;

import leetcodes.ds.ListNode;
import leetcodes.ds.TreeNode;
import leetcodes.ds.util.TreeNodeUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月19日 11:10
 */
public class P103 {

    @Test
    public void testFunc() {
        TreeNode root = TreeNodeUtil.initTree()
                .setRoot(3)
                .addLevel(9, 20)
                .addLevel(null, null, 15, 7)
                .build();
        List<List<Integer>> lists = zigzagLevelOrder(root);
        for (List<Integer> line : lists) {
            System.out.println(line);
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();

        if (root == null)
            return res;

        deque.addLast(root);
        int levelCount = 1;

        while (!deque.isEmpty()) {
            int thatLevelCount = 0;
            List<Integer> valueList = new ArrayList<>();

            for (int i = 0; i<levelCount; i++) {
                TreeNode thatNode = deque.pollFirst();
                valueList.add(thatNode.val);

                if (thatNode.left != null) {
                    thatLevelCount += 1;
                    deque.addLast(thatNode.left);
                }
                if (thatNode.right != null) {
                    thatLevelCount += 1;
                    deque.addLast(thatNode.right);
                }
            }

            res.add(valueList);
            levelCount = thatLevelCount;
        }

        if (res.size() <= 1)
            return res;

        for (int i = 0; i<res.size(); i++) {
            // 反转
            if (i % 2 == 1) {
                reverse(res.get(i));
            }
        }

        return res;
    }

    private void reverse(List<Integer> list) {
        if (list.size() <= 1)
            return;
        Integer tmp;
        int mid = list.size() / 2, len = list.size() - 1;
        for (int i = 0; i<mid; i++) {
            tmp = list.get(i);
            list.set(i, list.get(len - i));
            list.set(len - i, tmp);
        }
    }

}

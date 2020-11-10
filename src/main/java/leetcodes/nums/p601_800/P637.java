package leetcodes.nums.p601_800;

import leetcodes.adt.TreeNode;
import leetcodes.adt.util.TreeNodeUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年11月07日 15:53
 */
public class P637 {

    @Test
    public void testFunc() {
        TreeNode root = TreeNodeUtil.initTree()
                .setRoot(3)
                .addLevel(9, 20)
                .addLevel(null, null, 15, 7)
                .build();
        System.out.println(averageOfLevels(root));
    }

    public List<Double> averageOfLevels(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<Double> res = new ArrayList<>();
        int count = 1; // 每层节点的数量，假如根节点不为空则第一层节点数量为1
        int nextCount; // 下一层的节点数量
        int tmp;
        long sum;

        if (root != null)
            deque.push(root);
        while (!deque.isEmpty()) {
            // 初始化
            sum = 0;
            nextCount = 0;
            tmp = count;

            while (count > 0) {
                TreeNode node = deque.removeFirst();
                sum += node.val;
                if (node.left != null) {
                    deque.addLast(node.left);
                    nextCount++;
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                    nextCount++;
                }
                count--;
            }

            // 计算每层的结果
            res.add((double) sum / (double) tmp);
            count = nextCount;
        }

        return res;
    }

}

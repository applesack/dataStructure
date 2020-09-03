package nums;

import nums.ds.ListNode;
import nums.ds.util.ListNodeUtil;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月24日 18:05
 */
public class P23 {

    @Test
    public void testFunc() {
        ListNode[] lists = {
                ListNodeUtil.initNode(new int[]{1, 4, 5}),
                ListNodeUtil.initNode(new int[]{1, 3, 4}),
                ListNodeUtil.initNode(new int[]{2, 6}),
        };
        ListNode root = mergeKLists(lists);
        ListNodeUtil.printListNode(root);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode root = null, tmpNode = null, minNode = null;
        int minVal;
        int nodeSum = getNodeSum(lists);

        while (nodeSum > 0) {
            minVal = Integer.MAX_VALUE;
            for (ListNode node : lists) {
                if (node != null && node.val < minVal)
                    minVal = node.val;
            }

            for (int i = 0; i<lists.length; i++) {
                if (lists[i] != null && lists[i].val == minVal) {

                    if (tmpNode == null) {
                        tmpNode = root = lists[i];
                    } else {
                        tmpNode.next = lists[i];
                        tmpNode = tmpNode.next;
                    }

                    lists[i] = lists[i].next;
                    break;
                }
            }

            nodeSum--;
        }
        return root;
    }

    public int getNodeSum(ListNode[] lists) {
        int sum = 0;
        for (ListNode node : lists) {
            while (node != null) {
                sum++;
                node = node.next;
            }
        }
        return sum;
    }

    public boolean check(ListNode[] lists) {
        for (ListNode node : lists) {
            if (node != null)
                return true;
        }
        return false;
    }
}

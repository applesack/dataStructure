package leetcodes.nums.p100_200;

import leetcodes.ds.ListNode;
import leetcodes.ds.util.ListNodeUtil;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月24日 20:19
 */
public class P21 {

    @Test
    public void testFunc() {
        ListNode l1 = ListNodeUtil.initNode(new int[]{1,2,4});
        ListNode l2 = ListNodeUtil.initNode(new int[]{1,3,4});
        ListNode root = mergeTwoLists(l1, l2);
        ListNodeUtil.printListNode(root);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = null, tmpNode = null;
        ListNode[] lists = {l1, l2};

        int minVal, minIdx;
        while (true) {
            minVal = Integer.MAX_VALUE;
            minIdx = 0;
            if (lists[0] == null && lists[1] == null)
                return root;
            for (int i = 0; i<2; i++) {
                if (lists[i] != null && lists[i].val < minVal) {
                    minIdx = i;
                    minVal = lists[i].val;
                }
            }

            if (tmpNode == null) {
                tmpNode = root = lists[minIdx];
            } else {
                tmpNode.next = lists[minIdx];
                tmpNode = tmpNode.next;
            }

            lists[minIdx] = lists[minIdx].next;
        }
    }
}

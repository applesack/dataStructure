package leetcodes.nums.p1_200;

import leetcodes.adt.ListNode;
import leetcodes.adt.util.ListNodeUtil;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月03日 22:27
 */
public class P148 {

    @Test
    public void testFunc() {
        ListNode root =
//                ListNodeUtil.initNode(4, 2, 1, 3);
                ListNodeUtil.initNode(-1, 5, 3, 4, 0);
        root = sortList(root);
        ListNodeUtil.printListNode(root);
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }

}

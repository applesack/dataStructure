package leetcodes.nums.p201_400;

import leetcodes.adt.ListNode;
import leetcodes.adt.util.ListNodeUtil;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月13日 13:28
 */
public class P203 {

    @Test
    public void testFunc() {
        ListNode root = ListNodeUtil.initNode(6, 6);
        ListNodeUtil.printListNode(root);
        root = removeElements(root, 6);
        ListNodeUtil.printListNode(root);
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode res = new ListNode(-1);
        res.next = head;

        ListNode pos = res;
        while (pos.next != null) {
            if (pos.next.val == val) {
                pos.next = pos.next.next;
            } else {
                pos = pos.next;
            }
        }

        return res.next;
    }

}

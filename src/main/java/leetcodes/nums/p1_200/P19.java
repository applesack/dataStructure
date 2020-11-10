package leetcodes.nums.p1_200;

import leetcodes.adt.ListNode;
import leetcodes.adt.util.ListNodeUtil;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月12日 17:57
 */
public class P19 {

    @Test
    public void testFunc() {
        ListNode head = ListNodeUtil.initNode(1, 2, 3, 4, 5);
        head = removeNthFromEnd(head, 2);
        ListNodeUtil.printListNode(head);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = getSize(head);
        ListNode vHead = new ListNode(-1);
        vHead.next = head;

        int count = 0;
        n = size - n;
        ListNode pre = vHead;
        while (count < n) {
            pre = pre.next;
            count++;
        }
        if (pre.next.next == null) {
            pre.next = null;
        } else {
            pre.next = pre.next.next;
        }

        vHead = vHead.next;
        return vHead;
    }

    private int getSize(ListNode head) {
        int size = 0;
        if (head == null)
            return size;
        while (head.next != null) {
            head = head.next;
            size++;
        }
        return size + 1;
    }

}

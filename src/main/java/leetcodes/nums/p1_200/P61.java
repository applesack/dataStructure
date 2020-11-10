package leetcodes.nums.p1_200;

import leetcodes.adt.ListNode;
import leetcodes.adt.util.ListNodeUtil;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月12日 22:31
 */
public class P61 {

    @Test
    public void testFunc() {
        ListNode head = ListNodeUtil.initNode(1, 2, 3, 4, 5);
        ListNodeUtil.printListNode(head);
        ListNodeUtil.printListNode(rotateRight(head, 5));
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        Deque<ListNode> deque = new LinkedList<>();
        while (head != null) {
            deque.addLast(head);
            head = head.next;
        }

        k = k % deque.size();
        while (k > 0) {
            deque.addFirst(deque.pollLast());
            k--;
        }

        ListNode vHead = new ListNode(-1);
        ListNode point = vHead;
        while (!deque.isEmpty()) {
            point.next = deque.pollFirst();
            point = point.next;
        }

        point.next = null;

        return vHead.next;
    }

}

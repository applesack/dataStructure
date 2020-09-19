package leetcodes.nums;

import leetcodes.ds.ListNode;
import leetcodes.ds.util.ListNodeUtil;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月19日 10:21
 */
public class P82 {

    @Test
    public void testFunc() {
        ListNode head = ListNodeUtil.initNode(1, 1, 1, 2, 3);
        head = deleteDuplicates(head);
        ListNodeUtil.printListNode(head);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ArrayList<ListNode> list = new ArrayList<>();

        if (head.val != head.next.val)
            list.add(head);

        int preVal = head.val;
        head = head.next;

        while (head != null) {
            if (head.next == null) {
                if (head.val == preVal)
                    break;
                else
                    list.add(head);
            } else {
                if (head.val != preVal) {
                    if (head.val != head.next.val)
                        list.add(head);
                    preVal = head.val;
                }
            }
            head = head.next;
        }

        if (list.isEmpty())
            return null;

        ListNode rHead = list.get(0), rTail = rHead;
        for (ListNode listNode : list) {
            rTail.next = listNode;
            rTail = rTail.next;
        }
        rTail.next = null;
        return rHead;
    }

}

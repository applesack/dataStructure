package leetcodes.nums.p1_200;

import leetcodes.ds.ListNode;
import leetcodes.ds.util.ListNodeUtil;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年09月18日 21:57
 */
public class P86 {

    @Test
    public void testFunc() {
        ListNode head = ListNodeUtil.initNode(1, 4, 3, 2, 5, 2);
        head = partition(head, 3);
        ListNodeUtil.printListNode(head);
    }

    public ListNode partition(ListNode head, int x) {

        ListNode height = new ListNode(-1);
        ListNode low = new ListNode(-1);
        ListNode curNode, lowTail = low, heightTail = height;

        while (head != null) {
            curNode = head;
            if (curNode.val < x) {
                lowTail.next = curNode;
                lowTail = lowTail.next;
            } else {
                heightTail.next = curNode;
                heightTail = heightTail.next;
            }
            head = head.next;
        }

        lowTail.next = null;
        heightTail.next = null;
        height = height.next;
        low = low.next;

        if (low == null) {
            return height;
        } else {
            lowTail.next = height;
            return low;
        }
    }

}

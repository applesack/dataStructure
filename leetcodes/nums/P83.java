package nums;

import nums.ds.ListNode;
import nums.ds.util.ListNodeUtil;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月03日 12:18
 */
public class P83 {

    @Test
    public void testFunc() {
        ListNode root = ListNodeUtil.initNode(new int[]{1, 1, 2, 3, 3});
        deleteDuplicates(root);
        ListNodeUtil.printListNode(root);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode point = head;
        ListNode next = null;
        while (point.next != null) {
            next = point.next;
            if (point.val == next.val) {
                point.next = next.next;
            } else {
                point = point.next;
            }
        }

        return head;
    }

}

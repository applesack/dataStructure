package leetcodes.nums.p201_400;

import leetcodes.ds.ListNode;
import leetcodes.ds.util.ListNodeUtil;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月12日 18:33
 */
public class P206 {

    @Test
    public void testFunc() {
        ListNode root = ListNodeUtil.initNode(1, 2, 3, 4, 5);
        ListNodeUtil.printListNode(root);
        root = reverseList(root);
        ListNodeUtil.printListNode(root);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

}

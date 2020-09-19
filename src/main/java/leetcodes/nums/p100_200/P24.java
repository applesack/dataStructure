package leetcodes.nums.p100_200;

import leetcodes.ds.ListNode;
import leetcodes.ds.TreeNode;
import leetcodes.ds.util.ListNodeUtil;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月18日 18:37
 */
public class P24 {

    @Test
    public void testFunc() {
        ListNode head = ListNodeUtil.initNode(1, 2, 3, 4, 5);
        ListNodeUtil.printListNode(head);
        head = swapPairs(head);
        ListNodeUtil.printListNode(head);
    }

    public ListNode swapPairs(ListNode head) {
        ListNode pHead = null;
        ListNode curNode = null, nextNode = null, tail = null;

        if (head == null || head.next == null) {
            return head;
        } else {
            pHead = head.next;
            nextNode = head.next; // 2
            curNode = head;       // 1
            head = head.next.next;

            nextNode.next = curNode;
            tail = curNode;
        }

        while (head != null) {
            curNode = head;
            if (head.next == null) {
                tail.next = curNode;
                tail = curNode;
                break;
            } else {
                nextNode = curNode.next;
                head = head.next.next;

                nextNode.next = curNode;
                tail.next = nextNode;
                tail = curNode;
            }
        }

        tail.next = null;

        return pHead;
    }

}

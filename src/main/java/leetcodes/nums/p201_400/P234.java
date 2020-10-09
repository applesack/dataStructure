package leetcodes.nums.p201_400;

import leetcodes.ds.ListNode;
import leetcodes.ds.util.ListNodeUtil;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月09日 18:10
 */
public class P234 {

    @Test
    public void testFunc() {
        ListNode head = ListNodeUtil.initNode(1, 2, 2, 1);
        System.out.println(isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(head.val);
        while (head.next != null) {
            deque.addLast(head.next.val);
            head = head.next;
        }

        Integer left, right;
        while (deque.size() > 1) {
            left = deque.pollFirst();
            right = deque.pollLast();
            if (!left.equals(right))
                return false;
        }

        return true;
    }

}

package medium;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月17日 21:46
 */
public class 两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) return null;
        if (l1 == null || l2 == null)
            return l1 == null? l2 : l1;

        ListNode node = new ListNode(0);
        int sum;

        ListNode clues = l1;

        do {

        } while (clues.next == null);

        return null;
    }

    @Test
    public void Run() {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

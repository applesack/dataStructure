package leetcodes.zleetcodes.medium;

import leetcodes.ds.ListNode;
import leetcodes.zleetcodes.util.LeetCodes;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月17日 21:46
 */

@LeetCodes(
        id = 2,
        level = LeetCodes.LEVEL.MEDIUM,
        status = LeetCodes.Status.FINISHED,
        createDate = "2020/05/17"
)
public class 两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) return null;
        if (l1 == null || l2 == null)
            return l1 == null? l2 : l1;

        ListNode rslNode = null;
        ListNode tempNode;
        ListNode head = null;
        boolean isCarry = false;
        int sum;

        ListNode clues = l1;

        while (clues != null || isCarry) {
            sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            } else {
                clues = l2;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            } else {
                clues = l1;
            }

            if (clues == null && !isCarry && sum == 0) break;

            // 计算
            if (isCarry) {
                sum += 1;
                isCarry = false;
            }
            if (sum >= 10) {
                sum %= 10;
                isCarry = true;
            }

            if (rslNode == null) {
                rslNode = new ListNode(sum);
                head = rslNode;
                continue;
            }

            tempNode = new ListNode(sum);
            rslNode.next = tempNode;
            rslNode = rslNode.next;
        }

        return head;
    }

    @Test
    public void Run() {

        ListNode l1 = null;
        ListNode l2 = null;

        l1 = addElement(l1, new int[]{1,9});
        l2 = addElement(l2, new int[]{9});

        printNode(l1);
        printNode(l2);

        ListNode newNode = addTwoNumbers(l1, l2);
        System.out.println("\n结果:");
        printNode(newNode);
    }

    private static void printNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println();
    }

    private static ListNode addElement(ListNode node, int[] arr) {
        int i = 0;
        if (node == null) {
            node = new ListNode(arr[0]);
            i = 1;
        }

        ListNode temp = node;
        for (; i<arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }

        return node;
    }

}

package offer.part2;

import org.junit.Test;

import java.util.Stack;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月01日 20:00
 */
public class P6 {
    /**
     * 从尾到头打印链表
     */

    // 用栈的方式
    private void printListReversing_Iteratively(LinkNode pHead) {
        Stack<Integer> stack = new Stack<>();
        LinkNode pNode = pHead;

        while (pNode != null) {
            stack.push(pNode.val);
            pNode = pNode.next;
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    // 用递归的方式
    private void printLinkReversing_Recursively(LinkNode pHead) {
        if (pHead.next != null)
            printLinkReversing_Recursively(pHead.next);
        System.out.println(pHead.val);
    }

    @Test
    public void testRecursiveWay() {
        LinkNode pHead = new LinkNode(1);
        pHead.next = new LinkNode(2);
        pHead.next.next = new LinkNode(3);
        pHead.next.next.next = new LinkNode(4);

        printLinkReversing_Recursively(pHead);
    }

    @Test
    public void testStackWay() {
        LinkNode pHead = new LinkNode(1);
        pHead.next = new LinkNode(2);
        pHead.next.next = new LinkNode(3);
        pHead.next.next.next = new LinkNode(4);

        printListReversing_Iteratively(pHead);
    }

    private class LinkNode {
        public int val;
        public LinkNode next;

        public LinkNode(int val) {
            this.val = val;
        }
    }
}

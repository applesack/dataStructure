package leetcodes.ds.util;

import leetcodes.ds.ListNode;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月24日 19:03
 */
public class ListNodeUtil {

    public static void printListNode(ListNode node) {
        System.out.print('[');
        while (node != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }
        System.out.println(']');
    }

    public static ListNode initNode(int ... data) {
        ListNode root = null;
        if (data == null || data.length == 0)
            return root;

        root = new ListNode(data[0]);
        ListNode tmp = root;
        for (int i = 1; i<data.length; i++) {
            tmp.next = new ListNode(data[i]);
            tmp = tmp.next;
        }

        return root;
    }
}

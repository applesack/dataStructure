package leetcodes.nums.p201_400;

import leetcodes.ds.ListNode;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月13日 10:10
 */
public class P237 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}

package leetcodes.nums.p1_200;

import leetcodes.ds.TreeNode;
import leetcodes.ds.util.TreeNodeUtil;
import org.junit.Test;

import java.util.LinkedList;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月27日 9:24
 */
public class P173 {

    @Test
    public void testFunc() {
        TreeNode root = TreeNodeUtil.initTree()
                .setRoot(7)
                .addLevel(3, 15)
                .addLevel(null, null, 9, 20)
                .build();
        BSTIterator iterator = new BSTIterator(root);
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());

    }

    static class BSTIterator {

        private LinkedList<TreeNode> path = new LinkedList<>();

        public BSTIterator(TreeNode root) {
            if (root != null) {
                path.addLast(root);
                while (root.left != null) {
                    root = root.left;
                    path.addLast(root);
                }
            }
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode node = path.getLast();
            if (node.left == null && node.right == null) {
                return path.removeLast().val;
            } else if (node.left == null) {
                TreeNode lastNode = path.removeLast();
                if (lastNode.right != null)
                    path.addLast(lastNode.right);
                return lastNode.val;
            } else {
                while (node.left != null) {
                    node = node.left;
                    path.addLast(node);
                }
                return next();
            }
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return path.isEmpty();
        }
    }

}

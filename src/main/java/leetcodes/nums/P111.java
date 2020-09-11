package leetcodes.nums;

import leetcodes.ds.TreeNode;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月03日 19:36
 */
public class P111 {

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.min(minDepth(root.left) + 1, minDepth(root.right) + 1);
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
    }

}

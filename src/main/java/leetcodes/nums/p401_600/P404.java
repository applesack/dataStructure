package leetcodes.nums.p401_600;

import leetcodes.ds.TreeNode;
import leetcodes.ds.util.TreeNodeUtil;

public class P404 {
    
    private static final P404 solution = new P404();

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.initTree()
                    .setRoot(0)
                    .addLevel(2, 4)
                    .addLevel(1, null, 3, -1)
                    .addLevel()
                    .build();
        System.out.println(solution.sumOfLeftLeaves(root));
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }
    public int sumOfLeftLeaves(TreeNode root, boolean flag){
        if(root == null){
            return 0;
        }
        if(flag && root.left == null && root.right == null){
            return root.val;
        }
        int leftSum = sumOfLeftLeaves(root.left, true);
        int rightSum = sumOfLeftLeaves(root.right, false);
        return leftSum + rightSum;
    }
}

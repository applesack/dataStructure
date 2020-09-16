package leetcodes.zleetcodes.easy;


import leetcodes.ds.TreeNode;
import leetcodes.zleetcodes.util.LeetCodes;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月17日 21:14
 */

@LeetCodes(
        id = 100,
        status = LeetCodes.Status.FINISHED,
        createDate = "2020/04/17"
)
public class 相同的树 {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    @Test
    public void Run() {

    }
}

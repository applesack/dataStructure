package leetcodes.nums.p201_400;

import leetcodes.ds.TreeNode;
import leetcodes.ds.util.TreeNodeUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月10日 11:47
 */
public class P257 {

    @Test
    public void testFunc() {
        TreeNode root = TreeNodeUtil.initTree()
                .setRoot(1)
                .addLevel(2, 3)
                .addLevel(null, 5, null, null)
                .build();
        System.out.println(binaryTreePaths(root));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(root, path, paths);
        return paths;
    }

    private void dfs(TreeNode node, LinkedList<Integer> path, List<String> paths) {
        if (node == null)
            return;
        path.push(node.val);
        if (node.left == null && node.right == null) {
            paths.add(createPath(path));
            path.pop();
            return;
        }

        dfs(node.left, path, paths);
        dfs(node.right, path, paths);
        path.pop();
    }

    private static final String ARROW = "->";
    private static final StringBuilder sb = new StringBuilder();
    private String createPath(LinkedList<Integer> path) {
        sb.setLength(0);
        path.forEach(item -> sb.insert(0, item).insert(0, ARROW));
        sb.delete(0, 2);
        return sb.toString();
    }
}

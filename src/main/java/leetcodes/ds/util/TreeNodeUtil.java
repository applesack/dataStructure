package leetcodes.ds.util;

import leetcodes.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月03日 12:39
 */
public class TreeNodeUtil {

    public static Builder initTree() {
        return new Builder();
    }

    public static class Builder {

        private final ArrayList<Integer> nodeList;
        private int offset;
        private int level;

        public Builder() {
            nodeList = new ArrayList<>();
            offset = 0;
            level = 0;
        }

        public Builder setRoot(int val) {
            if (nodeList.size() == 0) {
                nodeList.add(val);
                level = 1;
            } else {
                nodeList.set(0, val);
            }
            return this;
        }

        public Builder addLevel(Integer ... values) {
            // 每次偏移量提升一倍
            level += 1;
            offset = offset * 2 + 1;
            int maxNum = (int) Math.pow(2,  level - 1);

//            System.out.println("第" + level + "层, 最大容量" + maxNum + ", 偏移量位置" + offset);

            if (values.length > maxNum) {
                System.out.println("第" + level + "层有多余的数据，将被修剪");
            }

            // 填充默认数据
            for (int i = 0; i<maxNum; i++)
                nodeList.add(null);

            for (int i = 0; i<maxNum; i++) {
                if (i > values.length - 1)
                    break;
                nodeList.set(offset + i, values[i]);
            }
            return this;
        }

        public TreeNode build() {
            return list2tree(this.nodeList);
        }
    }

    public static TreeNode list2tree(List<Integer> nodeList) {

        TreeNode root = new TreeNode(nodeList.get(0));

        list2treeCore(nodeList, root, 1);

        return root;
    }

    private static void list2treeCore(List<Integer> nodeList,  TreeNode node, int offset) {

        if (offset < nodeList.size() && nodeList.get(offset) != null) {
            node.left = new TreeNode(nodeList.get(offset));
            list2treeCore(nodeList, node.left, offset*2 + 1);
        }

        if (offset < nodeList.size() && nodeList.get(offset + 1) != null) {
            node.right = new TreeNode(nodeList.get(offset + 1));
            list2treeCore(nodeList, node.right,  (offset + 1)*2 + 1);
        }
    }

    public static void PrintTree(TreeNode root) {
        PrintTree(root, "pre");
    }
    public static void PrintTree(TreeNode root, String way) {
        System.out.print("[");

        way = way.toLowerCase();
        switch (way) {
            case "pre":
                PreOrderTraversal_Print(root);
                break;
            case "post":
                PostOrderTraversal_Print(root);
                break;
            case "in":
                InOrderTraversal_Print(root);
                break;
        }
        System.out.print("]");
    }

    // 前序
    private static void PreOrderTraversal_Print(TreeNode node) {
        // 中，左，右
        System.out.print(node.val + ",");

        if (node.left != null)
            PreOrderTraversal_Print(node.left);
        if (node.right != null)
            PreOrderTraversal_Print(node.right);
    }

    // 中序遍历
    private static void InOrderTraversal_Print(TreeNode node) {
        // 左，中，右
        if (node.left != null)
            InOrderTraversal_Print(node.left);

        System.out.print(node.val + ",");

        if (node.right != null)
            InOrderTraversal_Print(node.right);
    }

    // 后续遍历
    private static void PostOrderTraversal_Print(TreeNode node) {
        // 左，右，中
        if (node.left != null)
            PostOrderTraversal_Print(node.left);
        if (node.right != null)
            PostOrderTraversal_Print(node.right);
        System.out.print(node.val + ",");
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.initTree()
                .setRoot(1)
                .addLevel(2, 3)
                .addLevel(4, 5, 6, 7)
                .addLevel(8, 9, null, null)
                .build();

        TreeNodeUtil.PrintTree(root, "pre");

    }

}

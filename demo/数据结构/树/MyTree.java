package 数据结构.树;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月01日 21:31
 */
public class MyTree<T extends Comparable> {

    // 根节点
    private TreeNode<T> root;
    private int size;

    public MyTree() {
        size = 0;
    }

//    public boolean add(T t) {
//        if (root == null)
//            this.root.value = new TreeNode<>(t);
//    }

    public TreeNode add(TreeNode node, T t) {

        return null;
    }
}

class TreeNode<T extends Comparable> {

    public T value;
    public T left;
    public T right;

    public TreeNode(T value) {
        this.value = value;
    }
}

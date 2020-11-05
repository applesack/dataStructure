package demo.myImpl.dataStructrue.tree;

import java.nio.BufferUnderflowException;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月02日 21:27
 */

/**
 * 平衡二叉树
 * @param <AnyType>
 */
public class AVLTree<AnyType extends Comparable<? super AnyType>> {

    private BinaryNode<AnyType> root;
    private int size = 0;

    public AVLTree() {
        root = null;
    }

    // 置空当前树
    public void makeEmpty() {
        root = null;
    }
    public boolean isEmpty() {
        return root==null;
    }

    public boolean contains(AnyType x) {
        return contains(x, root);
    }
    public AnyType finMin() {
        if (isEmpty()) throw new BufferUnderflowException();
        return findMin(root).element;
    }
    public AnyType findMax() {
        if (isEmpty()) throw new BufferUnderflowException();
        return findMax(root).element;
    }
    public BinaryNode<AnyType> getRoot() {
        return root;
    }

    public void insert(AnyType x) {
        root = insert(x, root);

        // 在插入完成后判断是否应该旋转树, sub > 1:右子树大于左子树，sub < -1:右子树小于左子树
        int sub = (root.rightHeight() - root.leftHeight());
        if (sub > 1) { // 执行左旋转
            // 如果它的右子树的 左子树 大于 它的右子树
            if (root.right != null && root.right.leftHeight() > root.right.rightHeight()) {
                // 先对当前节点的右子树进行 右旋转
                root.right.rightRotate();
                // 再对当前节点进行左旋转
                root.leftHeight();
            } else {
                // 直接左旋转即可
                root.leftRotate();
            }
        } else if (sub < -1) { // 执行右旋转
            // 如果它的左子树的 右子树 大于 它的左子树
            if (root.left != null && root.left.rightHeight() > root.left.leftHeight()) {
                // 先对当前节点的左子树 进行左旋转
                root.left.leftRotate();
                // 再对当前节点进行右旋转
                root.rightHeight();
            } else {
                // 直接右旋转即可
                root.rightRotate();
            }
        }
    }
    public void remove(AnyType x) {
        root = remove(x, root);
    }
    public void printTree() {
        printTree(root);
    }

    // 判断该树是否包含 x
    private boolean contains(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) // 假如当前节点为空，则要查找的元素不此本树内
            return false;

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0) // 比较结果小于0，则查找该树的左子树
            return contains(x, t.left);
        else if (compareResult > 0) // 比较结果大于0，则查找该树的右子树
            return contains(x, t.right);
        else // 相等，则x等于当前元素，即该树包含x
            return true;
    }

    // 找到最小元素
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
        if (t != null)
            while (t.left != null) // 当左节点不为空，则向左子树直找
                t = t.left;

        return t;
    }

    // 找到最大元素
    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
        if (t != null)
            while (t.right != null) // 当右节点不为空，则向右子树一直找
                t = t.right;

        return t;
    }

    // 插入
    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) // 当前元素为空，则将元素安放在这里
            return new BinaryNode<>(x, null, null);

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0) // 向左边插入
            t.left = insert(x, t.left);
        else if (compareResult > 0) // 向右边插入
            t.right = insert(x, t.right);
        else // 相等，要插入的元素已经在树中存在
            ; // 什么都不做

        return t;
    }

    // 删除
    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) // 当前节点为空，没有要删除的元素，什么都不做
            return t;

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            t.left = remove(x, t.left);
        else if (compareResult > 0)
            t.right = remove(x, t.right);
        else if (t.left != null && t.right != null) { // 这个节点同时有左孩子和右孩子
            t.element = findMin(t.right).element; // 在右边找一个最小的元素插到当前的节点
            t.right = remove(t.element, t.right); // 在右边删除这个元素
        } else
            t = (t.left != null) ? t.left : t.right;

        return t;
    }

    // 打印树的所有元素 中序
    private void printTree(BinaryNode<AnyType> t) {
        if (t == null)
            return;

        // 左
        if (t.left != null)
            printTree(t.left);

        // 中
        System.out.println(t.element);

        // 右
        if (t.right != null)
            printTree(t.right);
    }

    // 二叉树结点
    public static class BinaryNode<AnyType> {

        BinaryNode(AnyType theElement) {
            this(theElement, null, null);
        }

        BinaryNode(AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt) {
            element = theElement;
            left = lt;
            right = rt;
        }

        // 返回右子树的高度
        public int leftHeight() {
            if (left == null) {
                return 0;
            }
            return left.height();
        }

        // 返回右子树的高度
        public int rightHeight() {
            if (right == null) {
                return 0;
            }
            return right.height();
        }

        // 以该节点为跟节点的树的高度
        public int height() {
            return Math.max(
                    (left == null) ? 0 : left.height(),
                    (right == null) ? 0 : right.height()) + 1;
        }

        /**
         * 左旋转
         * 1. 创建新节点，新节点的值是当前跟节点的值
         * 2. 把新节点的左子树 设置为 当前节点的左子树
         * 3. 把新节点的右子树 设置为 当前节点的右子树 的左子树
         * 4. 把当前节点的值 替换成 右子节点的值
         * 5. 把当前节点的右子树 换成 右子树的右子树
         * 6. 把当前节点的左子树 设置为新节点
         */
        private void leftRotate() {
            BinaryNode newNode = new BinaryNode<>(element); // 1
            newNode.left = this.left; // 2
            newNode.right = this.right.left; // 3
            this.element = this.right.element; // 4
            this.right = this.right.right; // 5
            this.left = newNode; // 6
        }

        // 右旋转
        public void rightRotate() {
            BinaryNode newNode = new BinaryNode(element);
            newNode.right = this.right;
            newNode.left = this.left.right;
            this.element = this.left.element;
            this.left = this.left.left;
            this.right = newNode;
        }

        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;
    }
}

package 数据结构.树;

import java.util.TreeSet;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月01日 21:26
 */
public class 顺序存储二叉树 {

    public static void main(String[] args) {
        // 构建一个二叉树
        TreeSet<Integer> tree = new TreeSet<>();
        int[] arr = {1,2,3,4,5};

        for (int i : arr) {
            tree.add(i);
        }
    }
}

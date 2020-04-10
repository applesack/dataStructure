package 递归的应用.回溯算法;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年04月09日 18:12
 */
public class 八皇后 {

    // 定义一个max表示共有多少个皇后
    private int max = 8;

    // 定义数组array, 保存皇后放置的结果，数组下标代表行，下标对应的值对应列
    private int[] array = new int[max];
    private int count = 0; // 计数

    public static void main(String[] args) {

        // 测试
        八皇后 queue8 = new 八皇后();
        queue8.check(0);
    }

    // 放置第n个皇后
    private void check(int n) {

        if (n == max) { // 表示前7个皇后已经放好, 已经得到一次结果
            System.out.printf("第%2d个结果: ", ++count);
            print();
            return;
        }

        // 依次放入皇后, 并判断是否冲突
        for (int i = 0; i<max; i++) {
            // 判断每个位置是否正确
            array[n] = i;
            if (judge(n)) { // 不冲突
                // 接着放n+1个递归
                check(n+1);
            }
        }
    }

    // 检查前n行所摆放的皇后和第n行的皇后位置有没有冲突
    private boolean judge(int n) {
        for (int i = 0; i<n; i++) {
            /**
             * 1. array[i] == array[n]: 判断第i行的皇后是否和第n行的皇后处于同一列
             * 2. Math.abs(n - i) == Math.abs(array[i] - array[i])
             *      判断第i行的皇后和第n行的皇后是否处于同一条斜线上
             *      假如它们处于同一条斜线, 那么它们 行的差 和 列的差 的绝对值相等
             */
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i]))
                return false;
        }
        return true;
    }

    // 将皇后摆放的位置输出
    private void print() {
        for (int i = 0; i<array.length; i++) {
            System.out.printf(" %d\t", array[i]);
        }
        System.out.println();
    }
}

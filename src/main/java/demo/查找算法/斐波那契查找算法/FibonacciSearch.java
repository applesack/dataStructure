package demo.查找算法.斐波那契查找算法;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年04月24日 21:52
 */
public class FibonacciSearch {

    private static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1234};

        System.out.println(fibonacciSearch(arr, 1000));
    }

    /**
     * 斐波那契查找算法 非递归方式
     * @param arr 需要查找的算法
     * @param key 需要查找的值
     * @return 值出现的位置的下标，没有找到则返回-1
     */
    public static int fibonacciSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0; // 表示斐波那契分割数值的下标
        int mid = 0; // 存放mid值
        int[] f = fib(); // 获取到斐波那契数列

        // 获取斐波那契数列分割值的下标
        while (high > f[k] - 1) {
            k++;
        }

        // 因为f[k]的值可能大于a的长度，所以我们需要一个Arrays类，构造一个新的数组，并指向a[]
        int[] temp = Arrays.copyOf(arr, f[k]);
        for (int i = high + 1; i<temp.length; i++) {
            temp[i] = arr[high];
        }

        // 使用while循环处理，找到key
        while (low <= high) { // 只要这个条件满足，就继续找
            mid = low + f[k-1]-1;
            if (key < temp[mid]) { // 应该向数组的左边查找
                high = mid - 1;
                /**
                 * 说明:
                 *      1. 全部元素 = 前面的元素 + 后面的元素
                 *      2. f[k] = f[k-1] + f[k-2]
                 * 因为前面有f[k-1]个元素，所以可以继续拆分，f[k-1] = f[k-2] + f[k-3]
                 * 即在f[k-1]的前面继续查找k--
                 * 即下次循环mid = f[k-1-1]-1
                 */
                k--;
            } else if (key > temp[mid]) { // 应该向数组右边查找
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }

        return -1;
    }

    // 获取一个斐波那契数组,大小为maxSize
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i<maxSize; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }
}

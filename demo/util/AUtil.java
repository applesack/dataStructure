package util;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月14日 17:19
 */
public class AUtil {

    public static int Partition(int[] data) {
        return Partition(data, 0, data.length - 1);
    }

    /**************************具体实现*****************************/

    /**
     * 将数组由一个点分为两个部分，左边的部分都小于中间值，右边的部分都大于中间值
     * @param data
     * @param left
     * @param right 有边界的实际数组下标
     * @return 返回中间值的下标
     */
    public static int Partition(int[] data, int left, int right) {
        int index = left;
        Swap(data, index, right);

        int small = left - 1;
        for (index = left; index < right; index++) {
            if (data[index] < data[right]) {
                small++;
                if (small != index) {
                    // Swap
                    Swap(data, index, small);
                }
            }
        }

        small++;
        Swap(data, right, small);

        return small;
    }

    /**
     * 交换数组两个下标的值
     * @param data 数组
     * @param idx1 下标1
     * @param idx2 下标2
     */
    public static void Swap(int[] data, int idx1, int idx2) {
        int tmp = data[idx1];
        data[idx1] = data[idx2];
        data[idx2] = tmp;
    }

    private AUtil() {}
}

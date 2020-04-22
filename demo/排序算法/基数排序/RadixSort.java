package 排序算法.基数排序;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年04月22日 19:51
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};

        System.out.println(Arrays.toString(radexSort(arr)));
    }

    // 假如数组内有负数，则需要对代码进行修改
    public static int[] radexSort(int[] arr) {
        /**
         * 定义一个二维数组，表示10个桶，每个桶是一维数组
         * 说明:
         *      1. 二维数组包含10个一维数组
         *      2. 为了防止在放入数的时候，数据溢出，则每一个一维数组(桶)，大小定为arr.length
         *      3. 基数排序需要占用大量的额外空间，是使用空间换时间的经典算法。
         */
        int[][] bucket = new int[10][arr.length];

        // 为了记录每个桶中，实际存放了多少个数据，需要定义一个一维数组来记录各个桶的每次存放的数据个数
        int[] bucketElementCounts = new int[10];

        // 找到这个数组中最大的数
        int max = arr[0];
        for (int i = 1; i<arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        // 得到这个最大数的位数
        int maxlength = (max + "").length();

        // 循环 最大数的位数 次
        for (int i = 0, n = 1; i<maxlength; i++, n*=10) {
            // 针对每个元素的对应位进行排序处理， 第一次是个位，第二次是十位，第三次是百位 ...
            for (int j = 0; j<arr.length; j++) {
                // 取出每个元素 第i位 的值
                int digitOfElement = (arr[j]/n) % 10;
                // 放入对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            // 原数组的下标
            int index = 0;
            // 遍历每个桶，根据每个桶内的值依次放入原数组
            for (int k = 0; k<bucketElementCounts.length; k++) {
                if (bucketElementCounts[k] != 0) {
                    // 循环该桶，(第k个桶)
                    for (int l = 0; l<bucketElementCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                // 第 i 轮处理后，需要将每个bucketElementCounts = 0 **重点**
                bucketElementCounts[k] = 0;
            }
        }

        return arr;
    }
}

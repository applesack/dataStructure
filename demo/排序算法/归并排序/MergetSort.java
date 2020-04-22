package 排序算法.归并排序;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年04月11日 9:40
 */
public class MergetSort {

    public static void main(String[] args) {
        int[] array = new int[] {8,4,5,7,1,3,6,2};
        int[] temp = new int[array.length];

        mergeSort(array, 0, array.length - 1, temp);
        System.out.println("归并排序后: " + Arrays.toString(array));
    }

    /**
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            // mid 中间
            int mid = (left + right) / 2;
            // 向左递归进行分解
            mergeSort(arr, left, mid, temp );
            // 向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            // 合并
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 归并排序
     * @param arr 待排序的数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 作中转的数组
     * @return
     */
    public static int[] merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left; // 初始化i
        int j = mid + 1;
        int t = 0;

        /**
         *
         */
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        while (i <= mid) {
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }

        while (j <= right) {
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
        return arr;
    }
}

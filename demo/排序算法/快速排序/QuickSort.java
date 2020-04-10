package 排序算法.快速排序;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年04月10日 20:12
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{-1,-3,101,34,119,1,0};

        System.out.println(Arrays.toString(quickSort(array, 0, array.length-1)));
    }

    public static int[] quickSort(int[] arr, int left, int right) {
        int l = left; // 左下标
        int r = right; // 右下标

        int temp; // 临时变量

        // pivot中轴值
        int pivot = arr[(left + right) / 2];

        /**
         * while循环的目的是让比pivot值小的放到左边, 比pivot大的放在右边
         */
        while (l < r) {
            // 在pivot左边找，当找到比pivot大的值，退出
            while (arr[l] < pivot) {
                l += 1;
            }
            // 在pivot右边找，当找到比pivot小的值，退出
            while (arr[r] >= pivot) {
                r -= 1;
            }
            // 如果 l>=r : 说明pivot左边都比pivot小，右边都比pivot大
            if (l >= r) {
                break;
            }

            // 交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 如果交换完后， 发现arr[l]等于pivot
            if (arr[l] == pivot) {
                r -= 1;
            }
            if (arr[r] == pivot) {
                l += 1;
            }
        }

        // 如果 l == r, 必须l++, r--, 否则会出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }

        // 向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        // 向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }

        return arr;
    }
}

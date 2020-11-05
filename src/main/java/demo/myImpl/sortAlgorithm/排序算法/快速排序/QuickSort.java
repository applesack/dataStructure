package demo.myImpl.sortAlgorithm.排序算法.快速排序;

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
            /**
             * 在pivot左边找，当找到比pivot大的值，退出 (代码42,46行)
             * 当while循环一圈后 l 代表大于pivot的元素的下标(r同理)
             * 这个时候将 r 和 l 对调，保证小的在左边，大的在右边
             * 但是也要考虑其他的情况:
             *      由于 l 会越来越靠右移动, r 会越来越靠左移动: (代码50行)
             *          最后 l 至多会等于pivot对应的下标,
             *          而 r 至多会对应pivot下标-1(因为对于r的while设定是 arr[r] >= pivot ), 这个现象可以用 l >= r 描述,
             *          此时可以退出本次循环 => 左边的所有元素都小于pivot, 右边所有元素都大于等于pivot
             *      找出 l 和 r 后, l 或者 r 的值与pivot相等: (代码60,63行)
             *          arr中有重复的值, l 和 r 向pivot的方法移动一格(每次循环只找出一个 l 和 r , 所以只需要移动一个单位)
             */
            while (arr[l] < pivot) {
                l += 1;
            }
            // 在pivot右边找，当找到比pivot小的值，退出
            while (arr[r] > pivot) {
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
        /**
         * 对于第69行开始代码的分析:
         * [6,5,4,(3),2,1,0]  l = r
         * [6,5,(4),3,(2),1,0]  l+=1, r-=1,    arr[l] = 2,  arr[r] = 4
         * 向左递归拿到的left-r的区间是   [[6,5,4],3,2,1,0]
         * 向右递归拿到的right-l的区间是  [6,5,4,3,[2,1,0]]
         *
         * 这个现象是向左递归的r会向左移动, 向右递归l会向右移动, 直到分到的区间为1为止(排序完成)
         */
    }
}

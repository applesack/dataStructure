package demo.排序算法.选择排序;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年04月10日 8:27
 */
public class SelectSort {

    public static void main(String[] args) {

        int[] array = new int[]{101,34,119,1,-1,-4};

        System.out.println(Arrays.toString(sort(array)));
    }

    // 从小到大
    public static int[] sort(int[] array) {

        int minIndex; // 最小值
        int temp;
        for (int i = 0; i<array.length-1; i++) {
            minIndex = i;
            for (int j = i; j<array.length; j++) {
                if (array[minIndex] > array[j])
                    minIndex = j;
            }
            // 将最小值与当前i下标交换,使得每i个元素都是最小的
            if (minIndex != i) {
                temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }

        return array;
    }

    /**
     * 选择排序一共有数组大小-1轮排序
     * 每一轮排序，又是一组循环，循环规则
     *      先假定当前这个数最小
     *      然后用这个数和其他数进行比较，如果发现有比当前数更小的数，
     *          就重新确定最小数，并得到下标
     *      交换
     */
}

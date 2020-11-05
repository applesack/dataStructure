package demo.myImpl.sortAlgorithm.排序算法.插入排序;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年04月10日 9:16
 */
public class InsertSort {

    public static void main(String[] args) {
        // 101, 119, 34, 1
        // 101, 119, 119, 1
        int[] array0 = new int[]{};
        int[] array1 = new int[]{5,4,3,2,1};
        int[] array2 = new int[]{101,34,119,1,0};

        System.out.println(Arrays.toString(insertSort(array0)));
        System.out.println(Arrays.toString(insertSort(array1)));
        System.out.println(Arrays.toString(insertSort(array2)));
    }

    public static int[] insertSort(int[] array) {

        int index, temp;
        for (int i = 1; i<array.length; i++) {
            index = i-1;
            temp = array[i];
            while (index >= 0 && array[index] > temp) { // 升序/降序只需要把右边的符号换一下即可
                array[index+1] = array[index];
                index--;
            }
            if (index+1 != i) // 经过判断后再赋值，减少赋值次数以提升运行效率
                array[index+1] = temp;
        }
        return array;
    }
    /**
     * 实例[101,34,119,1,0]
     * 将一个数组视为两个列表：左边的是排好序的有序列表，右边是待排序的无序列表
     *      从下标1开始，因为下标0(只有一个元素，视为有序)
     * 第一趟[101,101,119,1,0] -> [34,101,119,1,0]
     *      ... ...
     * 算法参见代码
     */
}

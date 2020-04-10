package 排序算法.插入排序;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年04月10日 9:16
 */
public class InsertSort {

    public static void main(String[] args) {
        // 101, 119, 34, 1
        // 101, 119, 119, 1
        int[] array = new int[]{101, 119, 34, 1};

        System.out.println(Arrays.toString(insertSort(array)));
    }

    public static int[] insertSort(int[] array) {

        if (array.length <= 1) return array;

        int pre;
        int index;
        for (int i = 1; i<array.length; i++) {
            index = i;
            while (index >= 1 && array[index-1] < array[i]) {
                array[index+1] = array[index];
                index--;
            }
            array[index-1] = array[i];
        }
        return array;
    }
}

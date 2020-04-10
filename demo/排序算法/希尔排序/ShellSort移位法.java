package 排序算法.希尔排序;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年04月10日 17:26
 */
public class ShellSort移位法 {

    public static void main(String[] args) {
        int[] array = new int[]{101,34,119,1,0};

        System.out.println(Arrays.toString(shellSort(array)));
    }

    public static int[] shellSort(int[] arr) {
        /**
         * 对交换式做了一些改良，效率大大提高了
         *
         */
        int index, value;
        for (int step = arr.length/2; step>0; step /= 2) {
            for (int i = step; i<arr.length; i++) {
                index = i;
                value = arr[i];
                if (arr[index] < arr[index - step]) {
                    while (index - step >= 0 && arr[index -step] > value) {
                        // 移动
                        arr[index] = arr[index - step];
                        index -= step;
                    }
                    arr[index] = value;
                }
            }
        }
        return arr;
    }
}

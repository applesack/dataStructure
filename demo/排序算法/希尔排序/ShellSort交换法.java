package 排序算法.希尔排序;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年04月10日 16:02
 */
public class ShellSort交换法 {

    public static void main(String[] args) {
        int[] array = new int[]{101,34,119,1,0};

        System.out.println(Arrays.toString(shellSort(array)));
    }

    public static int[] shellSort(int[] arr) {
        /**
         * step: 步长，每循环一次除2
         *
         */
        int temp;
        for (int step = arr.length/2; step>0; step /= 2) {
            for (int i = step; i<arr.length; i++) {
                for (int j = i-step; j>=0; j -= step) {
                    if (arr[j] > arr[j + step]) {
                        temp = arr[j];
                        arr[j] = arr[j + step];
                        arr[j + step] = temp;
                    }
                }
            }
        }

        return arr;
    }
}

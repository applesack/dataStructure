package myImpl.sortAlgorithm;

import org.junit.Test;
import util.ProxyUtil;
import util.RandomUtil;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月12日 9:30
 */
public class MyShellSort implements Sortable {

    @Test
    public void testSortFunc() {
        MyShellSort qs = (MyShellSort) new ProxyUtil(this.getClass()).getInstance();
        int[] input = RandomUtil.getRandomArr(10000000, -100000, 2000000);
        qs.sort(input);
    }

    @Override
    public int[] sort(int[] arr) {

        int len = arr.length, temp;
        for (int step = len/2; step>0; step /= 2) {
            for (int i = step; i < len; i++) {
                for (int j = i - step; j>=0; j -= step) {
                    if (arr[j] > arr[j + step]) {
                        // swap
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

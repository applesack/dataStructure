package demo.myImpl.sortAlgorithm;

import org.junit.Test;
import demo.util.ProxyUtil;
import demo.util.RandomUtil;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年08月12日 14:40
 */
public class IntervalSort implements Sortable {

    @Test
    public void testSortFunc() {
        int max = 55;
        int min = 18;
        int[] input = RandomUtil.getRandomArr(13500000, min, max);
        IntervalSort intervalSort = (IntervalSort) new ProxyUtil(IntervalSort.class).getInstance();
        intervalSort.sort(input, max, min);
    }

    @Override
    public int[] sort(int[] arr) {
        return sort(arr, 0, 100);
    }

    public int[] sort(int[] arr, int max, int min) {
        if (max < min)
            throw new IllegalArgumentException("["+max+", "+min+"] Max not more than the Min");

        int len = max - min;
        int[] tmp = new int[len];
        for (int item : arr) {
            if ((item > max - 1) || (item < min))
                throw new IllegalArgumentException("["+max+", "+min+"] " + item);
            tmp[item - min] = tmp[item - min] + 1;
        }

        int count, value, res_index = 0;
        for (int i = 0; i<tmp.length; i++) {
            count = tmp[i];
            value = i + min;
            while (count > 0) {
                arr[res_index++] = value;
                count--;
            }
        }

        return arr;
    }
}

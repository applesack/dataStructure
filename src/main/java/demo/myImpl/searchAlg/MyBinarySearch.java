package demo.myImpl.searchAlg;

import org.junit.Test;
import demo.util.RandomUtil;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月12日 16:36
 */
public class MyBinarySearch implements SearchAble {

    @Test
    public void testSearchFunc() {
        int[] input = RandomUtil.getOrderlyRandomArr(100000000, 10, 200000);
//        System.out.println(Arrays.toString(input));
        System.out.println(check(input, 11));
    }

    @Override
    public int contain(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;
        if (arr.length == 1 && arr[0] == target) return 0;

        int left  = 0;
        int right = arr.length - 1;
        int mid;

        int tmp;
        while (left != right && left < right) {
            if (right - left <= 5) {
                for (int i = left; i<right; i++) {
                    if (arr[i] == target)
                        return i;
                }
                return -1;
            }

            mid = (left + right) / 2;
            tmp = arr[mid];
            if (target < tmp) {
                right = mid;
            } else if (target > tmp) {
                left = mid;
            } else {
                return mid;
            }
        }

        return -1;
    }
}

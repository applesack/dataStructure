package leetcodes.nums.p100_200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月19日 11:51
 */
public class P167 {

    @Test
    public void testFunc() {
        int[] in = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(in, 9)));
    }

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i<numbers.length; i++) {
            if (numbers[i] > target / 2)
                break;
            int tIdx = binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (tIdx != -1) {
                return new int[] {i + 1, tIdx + 1};
            }
        }

        return new int[] {-1, -1};
    }

    private int binarySearch(int[] arr, int left, int right, int target) {

        int mid, midVal;
        while (left <= right) {
            mid = (left + right) / 2;
            midVal = arr[mid];
            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

}

package part2;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月01日 14:23
 */
public class P3 {

    /**
     * 判断一个数组中是否有重复的数字
     * @param numbers 数组中的每个数都属于 0~n-1
     * @return 重复 ? true : false
     */
    private boolean duplicate(int[] numbers) {
        if (numbers == null || numbers.length == 0) return false;

        for (int num : numbers) {
            if (num < 0 || num > numbers.length-1)
                return false;
        }

        for (int i = 0; i < numbers.length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]])
                    return true;
                int temp = numbers[i];
                numbers[temp] = numbers[i];
                numbers[i] = temp;
            }
        }

        return false;
    }

    @Test
    public void Test() {
        int[] input = {2,3,1,0,2,5,3};
        System.out.println(duplicate(input));
    }

    /**
     * 排序连续的数字
     * @param nums 待排序的数组
     * @param start 开始
     * @param end 结束
     * @return 排好序的数组
     * @throws ArrayIndexOutOfBoundsException
     */
    private int[] sortConsecutiveNumbers(int[] nums, int start, int end)
            throws ArrayIndexOutOfBoundsException {

        if (start >= end) return new int[0];
        if ((end-start) != nums.length-1) return new int[0];

        for (int num : nums) {
            if (num < start || num > end)
                throw new ArrayIndexOutOfBoundsException(num);
        }

        for (int i = 0; i<nums.length; i++) {
            while (nums[i] != (i + start)) {
                if (nums[i] == nums[nums[i] - start])
                    throw new ArrayIndexOutOfBoundsException(nums[i]);

                int temp = nums[i];
                nums[i] = nums[temp - start];
                nums[temp - start] = temp;
            }
        }

        return nums;
    }

    @Test
    public void testSortFunction() {
        int[] input = {15,10, 12, 11, 14, 13};
        System.out.println(Arrays.toString(sortConsecutiveNumbers(input, 10, 15)));
    }
}

package leetcodes.nums.p601_800;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年11月07日 16:16
 */
public class P643 {

    @Test
    public void testFunc() {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(findMaxAverage(nums, k));
    }

    public double findMaxAverage(int[] nums, int k) {
        int pos = 0;
        int sum = 0;
        int max;
        for ( ;pos<k; pos++) {
            sum += nums[pos];
        }

        max = sum;
        int size = nums.length;
        for ( ;pos<size; pos++) {
            sum += nums[pos];
            sum -= nums[pos - k];
            if (sum > max)
                max = sum;
        }

        return (double) max / k;
    }

}

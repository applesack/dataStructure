package leetcodes.nums.p1_200;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月17日 23:04
 */
public class P164 {

    @Test
    public void testFunc() {
        int[] in = {3, 6, 9, 1};
        System.out.println(maximumGap(in));
    }

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        Arrays.sort(nums);

        int max = Integer.MIN_VALUE;
        for (int i = 1; i<nums.length; i++) {
            int curVal = nums[i] - nums[i - 1];
            if (curVal > max) {
                max = curVal;
            }
        }

        return max;
    }

}

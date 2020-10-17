package leetcodes.nums.p1_200;

import org.junit.Test;

import java.util.Arrays;

/**
 * 缺失的第一个正整数
 *
 * @author : flutterdash@qq.com
 * @since : 2020年10月16日 22:53
 */
public class P41 {

    @Test
    public void testFunc() {
        int[] nums =
//                {1, 2, 0}
//                {3, 4, -1, 1}
                {7, 8, 9, 11, 12}
                ;
        System.out.println(firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);

        // 找到最接近0的正数
        int closeNum = Integer.MIN_VALUE;
        int closeIdx = 0;
        for (int i = 0; i<nums.length; i++) {
            if (nums[i] > 0) {
                closeNum = nums[i];
                closeIdx = i;
                break;
            }
        }

        if (closeNum != 1)
            return 1;

        for (int i = closeIdx; i<(nums.length - 1); i++) {
            if (nums[i + 1] - nums[i] > 1) {
                return nums[i] + 1;
            }
        }

        return nums[nums.length - 1] + 1;
    }

}

package leetcodes.easy;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月17日 18:40
 */
public class 最大子序和 {


    public static int test(int[] nums) {
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length+1];
        for (int i = 1; i<=nums.length; i++) {

            // 新加进来的数(nums[i-2]和之前的数)是否有增加(>0)，有则保持原状，不是则不增加
            dp[i] += Math.max(0, dp[i-1]) + nums[i-1];
            if (dp[i] > max)
                max = dp[i];
        }
        return max;
    }

    @Test
    public void run() {
        System.out.println(test(new int[]{1,2,-3,-4,-5,2,3}));
    }
}

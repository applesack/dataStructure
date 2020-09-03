package nums;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月02日 10:56
 */
public class P1716 {

    @Test
    public void testFunc() {
        int[] input =
//                {1, 2, 3, 1};
//                {2, 7, 9, 3, 1};
                {2, 1, 1, 2};
        System.out.println(massage(input));
    }

    public int massage(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length <= 2)
            return Arrays.stream(nums).max().getAsInt();

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i<nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }

}

package leetcodes.nums.p201_400;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月27日 15:27
 */
public class P368 {

    @Test
    public void testFunc() {
        int[] nums =
//                {1, 2, 4, 8}
//                {1, 2, 3}
//                {1, 2}
//                {1}
                {3, 4, 16, 8}
                ;
        System.out.println(largestDivisibleSubset(nums));
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return ans;

        Arrays.sort(nums);
        // dp[i][0] 存放当前位置最大子集长度; dp[i][1]存放子集前一个元素的下标
        int[][] dp = new int[nums.length][2];
        dp[0][1] = -1;
        for (int i = 1; i<nums.length; i++) {
            int max = -1;
            int maxIdx = 0;
            for (int j = 0; j<i; j++) {
                if (dp[j][0] >= max && nums[i] % nums[j] == 0) {
                    max = dp[j][0];
                    maxIdx = j;
                }
            }
            dp[i][1] = max == -1 ? -1 : maxIdx;
            dp[i][0] = max + 1;
        }

        int max = 0, maxIdx = 0;
        for (int i = 0; i<nums.length; i++) {
            if (dp[i][0] > max) {
                maxIdx = i;
                max = dp[i][0];
            }
        }

        while (maxIdx >= 0) {
            ans.add(nums[maxIdx]);
            maxIdx = dp[maxIdx][1];
        }

        return ans;
    }

}

package leetcodes.zleetcodes.easy;

import leetcodes.zleetcodes.util.LeetCodes;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年04月08日 11:10
 */

@LeetCodes(
        id = 70,
        level = LeetCodes.LEVEL.EASY,
        status = LeetCodes.Status.FINISHED,
        tags = {"动态规划"},
        createDate = "2020/05/22",
        finishTime = "1h"
)
public class 爬楼梯 {

    public static int climbStairs(int n) {

        if (n <= 2) return n;

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i<dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }

    @Test
    public void Run() {
        int input = 3;
        System.out.println("输入: " + input);
        System.out.println("输出: " + climbStairs(input));
    }
}

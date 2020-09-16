package leetcodes.nums;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月15日 11:33
 */
public class P322 {

    @Test
    public void testFunc() {
        int in = 63;
        int[] coins = {1, 5, 10, 21, 25, 50};
        System.out.println(coinChange(coins, in));
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp,amount + 1);

        dp[0] = 0;
        for (int i = 0; i<dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }

}

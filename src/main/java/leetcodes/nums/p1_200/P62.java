package leetcodes.nums.p1_200;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月17日 10:16
 */
public class P62 {

    @Test
    public void testFunc() {
        System.out.println(uniquePaths(1, 1));
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];

        // 初始化最上边和最左边
        for (int c = 0; c< m; c++)
            dp[0][c] = 1;
        for (int r = 0; r< n; r++)
            dp[r][0] = 1;

        // 动态规划
        for (int r = 1; r< n; r++) {
            for (int c = 1; c< m; c++) {
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }

        return dp[n - 1][m - 1];
    }

}

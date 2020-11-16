package leetcodes.nums.p1_200;

import org.junit.Test;

import java.util.stream.IntStream;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年11月11日 11:07
 */
public class P72 {

    @Test
    public void testFunc() {
        String word1 = "blua";
        String word2 = "black";
        System.out.println(minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        // base case
        for (int i = 1; i <= m; i++)
            dp[i][0] = i;
        for (int j = 1; j <= n; j++)
            dp[0][j] = j;

        // 自顶向上
        for (int i = 1; i<=m; i++) {
            for (int j = 1; j<=n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(
                            dp[i][j - 1],
                            dp[i - 1][j],
                            dp[i - 1][j - 1]
                    ) + 1;
                }
            }
        }
        return dp[m][n];
    }

    private int min(int num1, int num2, int num3) {
        return Math.min(num1, Math.min(num2, num3));
    }
}

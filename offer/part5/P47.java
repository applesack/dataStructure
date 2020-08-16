package part5;

import org.junit.Test;

import java.util.List;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月16日 9:58
 */
public class P47 {

    @Test
    public void testFunc() {
        int[][] input = {
                {1 , 10, 3 , 8 },
                {12, 2 , 9 , 6 },
                {5 , 7 , 4 , 11},
                {3 , 7 , 16, 5 }
        };
        /**
         * 1 , 11, 14, 22,
         * 13, 15, 24, 30,
         * 18, 25, 29, 41,
         * 21, 32, 48, 53
         */
        System.out.println(r_2(input));
    }

    private int r_2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return -1;
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row][column];
        int max;
        for (int r = 0; r<row; r++) {
            for (int c = 0; c<column; c++) {
                if (r - 1 < 0 && c - 1 < 0) {
                    dp[r][c] = matrix[r][c];
                    continue;
                }
                if (r - 1 < 0)
                    max = dp[r][c - 1];
                else if (c - 1 < 0)
                    max = dp[r - 1][c];
                else {
                    max = Math.max(dp[r - 1][c],
                                    dp[r][c - 1]);
                }
                dp[r][c] = max + matrix[r][c];
            }
        }

        return dp[row - 1][column - 1];
    }

}

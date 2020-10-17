package leetcodes.nums.p1_200;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月17日 10:22
 */
public class P63 {

    @Test
    public void testFunc() {
        int[][] obstacleGrid = {
//                {0, 0, 0},
//                {0, 1, 0},
//                {0, 0, 0}
                {0, 1}
        };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;

        int[][] dp = new int[row][column];

        // 初始化最上边和最左边
        // 参照dp数组上一个位置和网格对应的当前位置，假如之前或者现在存在障碍，那么现在的位置无法到达
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int r = 1; r<row; r++) {
            dp[r][0] = dp[r - 1][0] == 0 || obstacleGrid[r][0] == 1
                    ? 0 : 1;
        }
        for (int c = 1; c<column; c++) {
            dp[0][c] = dp[0][c - 1] == 0 || obstacleGrid[0][c] == 1
                    ? 0 : 1;
        }

        // 动态规划遍历
        for (int r = 1; r<row; r++) {
            for (int c = 1; c<column; c++) {
                // 假如当前位置有障碍，则当前位置不可达，也就是可以到达此处的路径数为0
                if (obstacleGrid[r][c] == 1) {
                    dp[r][c] = 0;
                    continue;
                }
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }

        return dp[row - 1][column - 1];
    }

}

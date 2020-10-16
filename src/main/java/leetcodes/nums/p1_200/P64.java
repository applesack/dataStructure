package leetcodes.nums.p1_200;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月16日 15:05
 */
public class P64 {

    @Test
    public void testFunc() {
        int[][] input = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(minPathSum(input));
    }

    public int minPathSum(int[][] grid) {
        final int row = grid.length;
        final int column = grid[0].length;

        // 初始化最上边和最左边的值
        for (int r = 1; r<row; r++) {
            grid[r][0] += grid[r - 1][0];
        }
        for (int c = 1; c<column; c++) {
            grid[0][c] += grid[0][c - 1];
        }

        for (int r = 1; r<row; r++) {
            for (int c = 1; c<column; c++) {
                grid[r][c] += Math.min(grid[r - 1][c], grid[r][c - 1]);
            }
        }

        return grid[row - 1][column - 1];
    }

}

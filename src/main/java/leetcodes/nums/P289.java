package leetcodes.nums;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月18日 17:30
 */
public class P289 {

    @Test
    public void testFunc() {
        int[][] in = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        gameOfLife(in);
        for (int[] line : in) {
            System.out.println(Arrays.toString(line));
        }
    }

    public void gameOfLife(int[][] board) {

        int row = board.length;
        int column = board[0].length;

        boolean[][] next_round =  new boolean[row][column];

        for (int r = 0; r<row; r++) {
            for (int c = 0; c<column; c++) {
                next_round[r][c] = check(board, r, c);
            }
        }

        for (int r = 0; r<row; r++) {
            for (int c = 0; c<column; c++) {
                board[r][c] = next_round[r][c] ? 1 : 0 ;
            }
        }
    }

    /**
     * 检查围绕当前坐标的周围8个位置，判定当前坐标的细胞是否能够存活
     * @param board 地图
     * @param r 行坐标
     * @param c 列坐标
     * @return 能存活 true
     */
    private boolean check(int[][] board, int r, int c) {
        int count = 0;
        boolean isLiving = board[r][c] == 1;

        /**
         * # # #
         * * o *
         * * * *
         */
        if (r >= 1) {
            // 上 中
            if (board[r - 1][c] == 1)
                count += 1;
            // 左 上
            if (c >= 1 && board[r - 1][c - 1] == 1)
                count += 1;
            // 右 上
            if (c < board[0].length - 1) {
                if (board[r - 1][c + 1] == 1)
                    count += 1;
            }
        }

        // 左 中
        if (c >= 1 && board[r][c - 1] == 1)
            count += 1;
        // 右 中
        if (c < board[0].length - 1 && board[r][c + 1] == 1)
            count += 1;

        /**
         * * * *
         * * o *
         * # # #
         */
        if (r < board.length - 1) {
            // 下 中
            if (board[r + 1][c] == 1)
                count += 1;
            // 下 左
            if (c >= 1 && board[r + 1][c - 1] == 1)
                count += 1;
            // 下 右
            if (c < board[0].length - 1 && board[r + 1][c + 1] == 1)
                count += 1;
        }

        if (isLiving) {
            return count >= 2 && count < 4;
        } else {
            return count == 3;
        }
    }

}

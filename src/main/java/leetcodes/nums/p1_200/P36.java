package leetcodes.nums.p1_200;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月26日 9:38
 */
public class P36 {

    @Test
    public void testFunc() {
        char[][] part = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(part));
    }

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return false;

        // 九宫格，一共有九个区域
        int x = 0, y = 0;
        for (int i = 0; i<9; i++) {
            // 检查行
            if (!checkRow(board, i))
                return false;
            if (!checkColumn(board, i))
                return false;

            // 检查分区
            if (!checkPart(board, x, y))
                return false;

            x += 3;
            if (x != 0 && x % 9 == 0) {
                x = 0;
                y += 3;
            }
        }

        return true;
    }

    private boolean checkRow(char[][] board, int row) {
        int[] nums = new int[9];
        int index;
        for (int i = 0; i<9; i++) {
            index = board[row][i] - '1';
            if (index == -3)
                continue;
            if (nums[index] == 1)
                return false;
            else
                nums[index] = 1;
        }
        return true;
    }

    private boolean checkColumn(char[][] board, int column) {
        int[] nums = new int[9];
        int index;
        for (int i = 0; i<9; i++) {
            index = board[i][column] - '1';
            if (index == -3)
                continue;
            if (nums[index] == 1)
                return false;
            else
                nums[index] = 1;
        }
        return true;
    }

    private boolean checkPart(char[][] board, int x, int y) {

        int[] nums = new int[9];
        int index, o_x = x, o_y = y;
        for (int i = 0; i<9; i++) {

            index = board[y][x] - '1';
            if (index != -3) {
                if (nums[index] == 1)
                    return false;
                else
                    nums[index] = 1;
            }

            x++;
            if (i != 0 && (i+1) % 3 == 0) {
                x  = o_x;
                y += 1;
            }
        }

        return true;
    }
}

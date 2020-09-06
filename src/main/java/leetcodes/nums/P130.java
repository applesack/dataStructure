package leetcodes.nums;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月05日 9:56
 */
public class P130 {

    @Test
    public void testFunc() {
        char[][] input = {
//                {'X', 'X', 'X', 'X'},
//                {'X', 'O', 'O', 'X'},
//                {'X', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'X'}

//                {'X', 'X', 'X'},
//                {'X', 'O', 'X'},
//                {'X', 'X', 'X'}

                {'X', 'O', 'O', 'O', 'O', 'X'},
                {'O', 'X', 'X', 'X', 'X', 'O'},
                {'O', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'X', 'X', 'X', 'X', 'O'},
                {'X', 'O', 'O', 'O', 'O', 'X'}
        };
        solve(input);
        Arrays.stream(input)
                .map(Arrays::toString)
                .forEach(System.out::println);
    }

    public void solve(char[][] board) {
        // 为空，不包含元素
        if (board == null || board.length == 0)
            return;

        int row = board.length;
        int column = board[0].length;

        // 存放临时的路径
        int[][] tmpPath = new int[row][column];
        boolean isValid = false;

        // 遍历二维数组每个元素，找到含有字母O的位置
        for (int r = 0; r<board.length; r++) {
            for (int c = 0; c<column; c++) {
                if (board[r][c] == 'O') {
                    System.out.println(r +", "+ c);
                    if (tmpPath[r][c] == -1)
                        continue;
                    isValid = search(board, r, c, tmpPath);
                    Arrays.stream(tmpPath).map(Arrays::toString)
                            .forEach(System.out::println);
                    System.out.println("----------------------------");
                    if (isValid) {
                        // 将tmpPath标记的位置设置为X
                        replace(board, tmpPath, row, column);
                    }
                }
            }
        }

    }

    // 将标记为true的位置替换成X，并将标记清除
    private void replace(char[][] board, int[][] path, int row, int column) {
        System.out.println(row + ", " + column);

        for (int r = 0; r<row; r++) {
            for (int c = 0; c<column; c++) {
                if (path[r][c] == 1) {
                    board[r][c] = 'X';
//                    path[r][c] = 0;
                }
            }
        }
    }

    // 假如路径有效，能形成闭合区间，则返回true
    private boolean search(char[][] board, int r, int c, int[][] tmpPath) {
        // 标记当前位置
        tmpPath[r][c] = 1;

        // 检查当前位置有没有开口, 假如触碰到边界，则清除标记
        boolean up = true, down = true, left = true, right = true;

        // 上
        if (r - 1 >= 0 && tmpPath[r - 1][c] != -1) {
            if (board[r - 1][c] == 'O')
                up = search(board, r - 1, c, tmpPath);
            else
                up = false;
        } else { // 触碰到上边界
            tmpPath[r][c] = -1;
            return false;
        }

        // 下
        if (r + 1 < board.length && tmpPath[r + 1][c] != -1) {
            if (board[r + 1][c] == 'O')
                down = search(board, r + 1, c, tmpPath);
        } else { //触碰到下边界
            tmpPath[r][c] = -1;
            return false;
        }

        // 左
        if (c - 1 >= 0 && tmpPath[r][c - 1] != -1) {
            if (board[r][c - 1] == 'O')
                left = search(board, r, c - 1, tmpPath);
        } else { // 触碰到左边界
            tmpPath[r][c] = -1;
            return false;
        }

        // 右
        if (c + 1 < board[0].length && tmpPath[r][c + 1] != -1) {
            if (board[r][c + 1] == 'O')
                right = search(board, r, c + 1, tmpPath);
        } else { // 触碰到右边界
            tmpPath[r][c] = -1;
            return false;
        }

        if (up && down && left && right)
            return true;
        else {
            tmpPath[r][c] = -1;
            return false;
        }
    }

}

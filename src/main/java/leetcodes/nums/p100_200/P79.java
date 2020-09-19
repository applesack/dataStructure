package leetcodes.nums.p100_200;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月12日 19:06
 */
public class P79 {

    @Test
    public void testFunc() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        System.out.println(exist(board, "ABCESEEEFS"));
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0)
            return false;

        int r = board.length;
        int c = board[0].length;

        if (r * c < word.length())
            return false;

        char[] c_word = word.toCharArray();
        boolean[][] path = new boolean[r][c];
        for (int i = 0; i<r; i++) {
            for (int j = 0; j<c; j++) {
                if (board[i][j] == c_word[0]) {
                    if (findPath(board, c_word, i, j, 1, path))
                        return true;
                }
            }
        }

        return false;
    }

    private boolean findPath(char[][] board, char[] tPath,
                             int r, int c,
                             int curVal, boolean[][] path) {
        if (curVal == tPath.length)
            return true;

        boolean up, down, left, right;
        up = down = left = right = false;

        // 向上方查找
        if (r - 1 >= 0 && !path[r - 1][c]) {
            if (board[r - 1][c] == tPath[curVal]) {
                path[r - 1][c] = true;
                up = findPath(board, tPath, r - 1, c, curVal + 1, path);
            }
        }

        // 向下方查找
        if (r + 1 < board.length && !path[r + 1][c]) {
            if (board[r + 1][c] == tPath[curVal]) {
                path[r + 1][c] = true;
                down = findPath(board, tPath, r + 1, c, curVal + 1, path);
            }
        }

        // 向左方查找
        if (c - 1 >= 0 && !path[r][c - 1]) {
            if (board[r][c - 1] == tPath[curVal]) {
                path[r][c - 1] = true;
                left = findPath(board, tPath, r, c - 1, curVal + 1, path);
            }
        }

        // 向右方查找
        if (c + 1 < board[r].length && !path[r][c + 1]) {
            if (board[r][c + 1] == tPath[curVal]) {
                path[r][c + 1] = true;
                right = findPath(board, tPath, r, c + 1, curVal + 1, path);
            }
        }

        if (up || down || left || right)
            return true;
        else
            path[r][c] = false;
        return false;
    }

}

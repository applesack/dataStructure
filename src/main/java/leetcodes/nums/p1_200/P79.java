package leetcodes.nums.p1_200;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @since  : 2020年09月12日 19:06
 */
public class P79 {

    @Test
    public void testFunc() {
        char[][] board = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'E', 'S'},
//                {'A', 'D', 'E', 'E'}
                {'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'b'}
        };
        String word = "aaaaaaaaaaaaaaaa";
        System.out.println(exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0)
            return false;

        int r = board.length;
        int c = board[0].length;

        if (r * c < word.length())
            return false;

        char[] target = word.toCharArray();
        boolean[][] path = new boolean[r][c];
        for (int i = 0; i<r; i++) {
            for (int j = 0; j<c; j++) {
                if (board[i][j] == target[0]) {
                    if (findPath(board, target, i, j, 0, path))
                        return true;
                }
            }
        }

        return false;
    }

    // r, c : 上右下左
    private static final int[][] DIRECTION = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private boolean findPath(char[][] board, char[] target,
                             int r, int c,
                             int curPos, boolean[][] path) {
        if (curPos == target.length)
            return true;
        // 检查当前位置是否有效
        if (!(r >= 0 && r < board.length && c >= 0 && c < board[0].length))
            return false;
        if (path[r][c] || board[r][c] != target[curPos])
            return false;

        path[r][c] = true;
        for (int[] direct : DIRECTION) {
            if (findPath(board, target, r + direct[0], c + direct[1], curPos + 1, path))
                return true;
        }
        path[r][c] = false;

        return false;
    }

}

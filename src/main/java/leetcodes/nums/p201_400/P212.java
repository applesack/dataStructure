package leetcodes.nums.p201_400;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月08日 21:33
 */
public class P212 {

    @Test
    public void testFunc() {

    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> rList = new ArrayList<>();

        Map<Character, String> prefixMap =
                Arrays.stream(words).collect(
                        Collectors.toMap(item -> item.charAt(0), Function.identity()));

        int row = board.length, column = board[0].length;
        boolean[][] tmp = new boolean[row][column];
        for (int r = 0; r<row; r++) {
            for (int c = 0; c<column; c++) {
                String curStr = prefixMap.get(board[r][c]);
                if (curStr != null) {
                    if (canFindWordFromBoard(board, r, c, 0, curStr, tmp))
                        rList.add(curStr);
                }
            }
        }

        return rList;
    }

    // (r, c)
    private static final int[][] DIRECTION = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    private boolean canFindWordFromBoard(char[][] board, int r, int c, int curIdx,
                                         String target, boolean[][] path) {
        // 检查是否超出边界
        if ((r < 0 || r > board.length) || (c < 0 || c > board[0].length))
            return false;
        if (board[r][c] == target.charAt(curIdx)) {
            if (!path[r][c]) {
                path[r][c] = true;
                curIdx++;
            } else return false;
        }
        if (curIdx == target.length())
            return true;

        for (int[] position : DIRECTION) {
            if (canFindWordFromBoard(board, r + position[0], c + position[1], curIdx, target, path))
                return true;
        }

        path[r][c] = false;
        return false;
    }

}

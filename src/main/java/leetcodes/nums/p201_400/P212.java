package leetcodes.nums.p201_400;

import org.junit.Test;

import java.util.*;
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
        char[][] board = {
//                {'o', 'a', 'a', 'n'},
//                {'e', 't', 'a', 'e'},
//                {'i', 'h', 'k', 'r'},
//                {'i', 'f', 'l', 'v'}
                {'a', 'b'},
                {'c', 'd'}
        };
        String[] words = {
//                "oath", "pea", "rain", "eat"
                "ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"
        };
        System.out.println(findWords(board, words));
    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> rSet = new HashSet<>();

        Map<Character, Set<String>> prefixMap =
                Arrays.stream(words).collect(
                        Collectors.groupingBy(str -> str.charAt(0), Collectors.toSet()));

        int row = board.length, column = board[0].length;
        boolean[][] tmp = new boolean[row][column];
        for (int r = 0; r<row; r++) {
            for (int c = 0; c<column; c++) {
                Set<String> curSet = prefixMap.get(board[r][c]);
                if (curSet != null) {
                    for (String someone : curSet) {
                        if (canFindWordFromBoard(board, r, c, 0, someone, tmp)) {
                            rSet.add(someone);
                            clear(tmp, row, column);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(rSet);
    }

    // (r, c)
    private static final int[][] DIRECTION = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    private boolean canFindWordFromBoard(char[][] board, int r, int c, int curIdx,
                                         String target, boolean[][] path) {
        // 检查是否超出边界
        if ((r < 0 || r > board.length - 1) || (c < 0 || c > board[0].length - 1))
            return false;
        if (board[r][c] == target.charAt(curIdx)) {
            if (!path[r][c]) {
                path[r][c] = true;
                curIdx++;
            } else return false;
        } else return false;
        if (curIdx == target.length())
            return true;

        for (int[] position : DIRECTION) {
            if (canFindWordFromBoard(board, r + position[0], c + position[1], curIdx, target, path))
                return true;
        }

        path[r][c] = false;
        return false;
    }

    private void clear(boolean[][] path, int row, int column) {
        for (int r = 0; r<row; r++) {
            for (int c = 0; c<column; c++) {
                if (path[r][c])
                    path[r][c] = false;
            }
        }
    }

}

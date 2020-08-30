package nums;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月30日 13:22
 */
public class P51 {

    @Test
    public void testFunc() {
        int input = 8;
        List<List<String>> res = solveNQueens(input);
        System.out.println(res.size());
        for (List<String> solve : res) {
            for (String line : solve) {
                System.out.println(line);
            }
            System.out.println("---------------------------------");
        }
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new LinkedList<>();
        solve(res, 0, new int[n], n);
        return res;

    }

    private void solve(List<List<String>> res, int curRow,
                    int[] paths, int maxEdge) {

        boolean flag;
        for (int i = 0; i<maxEdge; i++) {
            paths[curRow] = i;
            flag = check(paths, curRow, maxEdge);
            if (flag) {
                // 找到问题的一个解
                if (curRow == maxEdge - 1) {
                    res.add(makeSolve(paths, maxEdge));
                }
                // 当前位置暂时可用，递归继续求解
                else {
                    solve(res, curRow + 1, paths, maxEdge);
                }
            }
        }
    }

    private boolean check(int[] lines, int row, int maxEdge) {

        int pos = lines[row], gap;
        for (int r = 0; r<row; r++) {
            // 有其他皇后于当前的皇后处于同一竖线上，此位置无效
            if (lines[r] == pos)
                return false;
            gap = row - r;
            if (pos - gap >= 0 && lines[r] == (pos - gap))
                return false;
            if (pos + gap < maxEdge && lines[r] == (pos + gap))
                return false;
        }
        return true;
    }


    private static final StringBuffer sb = new StringBuffer();

    private List<String> makeSolve(int[] lines, int maxEdge) {
        List<String> res = new ArrayList<>();
        for (int line : lines) {
            res.add(makeLine(line, maxEdge));
        }
        return res;
    }

    /**
     * 按照题目要求将一个皇后摆放好
     * @param idx 皇后的数组实际下标
     * @param maxEdge 棋盘的边长
     * @return
     */
    private String makeLine(int idx, int maxEdge) {
        sb.setLength(0);
        for (int i = 0; i<maxEdge; i++) {
            if (i == idx) {
                sb.append('Q');
            } else {
                sb.append('.');
            }
        }

        return sb.toString();
    }

}

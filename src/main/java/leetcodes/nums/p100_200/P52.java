package leetcodes.nums.p100_200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月30日 16:05
 */
public class P52 {

    @Test
    public void testFunc() {
        System.out.println(totalNQueens(8));
    }

    public int totalNQueens(int n) {
        return solveNQueens(n);
    }

    public int solveNQueens(int n) {

        int[] resCount = {0};
        solve(resCount, 0, new int[n], n);
        return resCount[0];

    }

    private void solve(int[] resCount, int curRow,
                       int[] paths, int maxEdge) {

        boolean flag;
        for (int i = 0; i<maxEdge; i++) {
            paths[curRow] = i;
            flag = check(paths, curRow, maxEdge);
            if (flag) {
                // 找到问题的一个解
                if (curRow == maxEdge - 1) {
                    resCount[0]++;
                }
                // 当前位置暂时可用，递归继续求解
                else {
                    solve(resCount, curRow + 1, paths, maxEdge);
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
}

package leetcodes.nums.p201_400;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月08日 11:45
 */
public class P221 {

    @Test
    public void testFunc() {
        char[][] in = {
//                {'1', '0', '1', '0', '0'},
//                {'1', '0', '1', '1', '1'},
//                {'1', '1', '1', '1', '1'},
//                {'1', '0', '1', '1', '1'}
                {'1', '1'},
                {'1', '0'}
        };
        System.out.println(maximalSquare(in));
    }

    public int maximalSquare(char[][] matrix) {

        if (matrix == null || matrix.length == 0)
            return 0;
        if (matrix[0].length == 0)
            return 0;

        int row = matrix.length;
        int column = matrix[0].length;

        int maxLen = 0;
        for (int r = 0; r<row; r++) {
            for (int c = 0; c<column; c++) {
                if (matrix[r][c] == '1') {
                    // 尝试扩张
                    int curLen = 1;
                    while (r + curLen < row && c + curLen < column) {
                        curLen++;
                        boolean outBound = false;

                        // 检查右边界
                        int curC = c + curLen - 1;
                        for (int rightIdx = 0; rightIdx<curLen - 1; rightIdx++) {
                            if (matrix[r + rightIdx][curC] == '0') {
                                outBound = true;
                                break;
                            }
                        }

                        // 检查下边界
                        int curR = r + curLen - 1;
                        for (int downIdx = 0; downIdx<curLen; downIdx++) {
                            if (matrix[curR][c + downIdx] == '0') {
                                outBound = true;
                                break;
                            }
                        }

                        if (outBound) {
                            curLen--;
                            break;
                        }
                    }

                    if (curLen > maxLen)
                        maxLen = curLen;
                }
            }
        }

        return maxLen * maxLen;
    }

}

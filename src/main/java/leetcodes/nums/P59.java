package leetcodes.nums;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月19日 9:37
 */
public class P59 {

    @Test
    public void testFunc() {
        int[][] out = generateMatrix(3);
        for (int[] line : out) {
            System.out.println(Arrays.toString(line));
        }
    }

    public int[][] generateMatrix(int n) {
        if (n == 0)
            return new int[0][];
        if (n == 1)
            return new int[][] {{1}};
        int[][] matrix = new int[n][n];
        int count = n * n, cur = 1, start = 0;
        int len = n - 1;
        int r, c;

        while (cur <= count) {
            if (len <= 0 && count == cur) {
                int innerLen = matrix.length / 2;
                matrix[innerLen][innerLen] = count;
                break;
            }

            r = start; c = start;
            for (int i = 0; i<len; i++) {
                matrix[r][c + i] = cur++;
            }
            c = start + len;
            for (int i = 0; i<len; i++) {
                matrix[r + i][c] = cur++;
            }
            r = start + len;
            for (int i = 0; i<len; i++) {
                matrix[r][c - i] = cur++;
            }
            c = start;
            for (int i = 0; i<len; i++) {
                matrix[r - i][c] = cur++;
            }
            len -= 2;
            start += 1;
        }

        return matrix;
    }

}

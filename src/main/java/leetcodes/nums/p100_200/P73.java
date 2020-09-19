package leetcodes.nums.p100_200;

import org.junit.Test;

import java.util.*;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月10日 11:26
 */
public class P73 {

    @Test
    public void testFunc() {
        int[][] input = {
//                {1, 1, 1},
//                {1, 0, 1},
//                {1, 1, 1},
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        setZeroes(input);
        for (int[] line : input) {
            System.out.println(Arrays.toString(line));
        }
    }

    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();

        int r, c;
        // 扫描一遍矩阵，将矩阵中有0的位置记录下来
        for (r = 0; r<matrix.length; r++) {
            for (c = 0; c<matrix[0].length; c++) {
                if (matrix[r][c] == 0) {
                    rows.add(r);
                    columns.add(c);
                }
            }
        }

        // 将所有标记的行置为0
        for (Integer row : rows) {
            for (int i = 0; i<matrix[0].length; i++) {
                matrix[row][i] = 0;
            }
        }

        // 将所有标记的列置为0
        for (Integer column : columns) {
            for (int i = 0; i<matrix.length; i++) {
                matrix[i][column] = 0;
            }
        }
    }

}

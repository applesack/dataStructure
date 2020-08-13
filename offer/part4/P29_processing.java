package part4;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月07日 19:28
 */
public class P29_processing {

    @Test
    public void testFunc() {
        int[][] input_1 = {
                {1 , 2 , 3 , 4 },
                {5 , 6 , 7 , 8 },
                {9 , 10, 11, 12},
                {13, 14, 15, 16},
        };

        int[][] input_2 = {
                {1 , 2 , 3 , },
                {5 , 6 , 7 , },
                {9 , 10, 11, },
        };

        printMatrixClockWisely(input_1);
        printMatrixClockWisely(input_2);
    }

    private void printMatrixClockWisely(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;

        int column = matrix[0].length;
        int row = matrix.length;
        int start = 0;

        while (column > (start * 2) && row > (start * 2)) {
            printCircle(matrix, row, column, start);
            ++start;
        }
    }

    private void printCircle(int[][] matrix, int row, int  column, int start) {
        int endX = column - 1 - start;
        int endY = row - 1 - start;

        // 上
        for (int i = start; i<endX; i++) {
            System.out.print(matrix[row][i] + " ");
        }

        // 右
        if (start < endY) {
            for (int i = start + 1; i<=endY; i++) {
                System.out.print(matrix[i][endX] + " ");
            }
        }

        //

    }
}

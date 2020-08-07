package part4;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月07日 19:28
 */
public class P29 {

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

        int max_width, max_height, width, height;
        width  = max_width  = matrix[0].length;
        height = max_height = matrix.length;
        int x = 0, y = 0;

        while (true) {
            printCircle(matrix, width, height, x, y);

            if (x+1 >= max_width/2 && y+1 >= max_height/2)
                break;

            if (x+1 <= max_width/2) {
                x += 1;
                width -= 2;
            }

            if (y+1 <= max_height/2) {
                y += 1;
                height -= 2;
            }
        }

        System.out.println();
    }

    private void printCircle(int[][] matrix, int width, int height, int x, int y) {
        int end_x = x, end_y = y;

        // 打印上边，从最左边第一个坐标到最右边的坐标
        for (int i = 0; i<width; i++) {
            System.out.print(matrix[y][x++] + " ");
        }

        // 打印右边，从第一行最右一格下面一格开始，一直到底部
        y ++; x --;
        for (int i = 0; i<height-1; i++) {
            System.out.print(matrix[y++][x] + " ");
        }

        // 打印下面一条边
        x --; y--;
        for (int i = width; i>1; i--) {
            System.out.print(matrix[y][x--] + " ");
        }

        // 打印左边一条边
        x++;
        for (int i = height-1; i>1; i--) {
            System.out.print(matrix[--y][x] + " ");
        }

        // 打印一条空行
        System.out.println();
    }
}

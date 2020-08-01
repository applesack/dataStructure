package part2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月01日 16:17
 */
public class P4 {
    /**
     * 从右往左查
     * 检查每一列的第一个元素，找到目标值，返回结果
     * 假如这个元素大于目标值，则该列的的值都大于目标值，跳过这一列
     * 如果这一列的第一个元素小于目标值，则继续查这个列，
     * 在这一列中遇到比目标值大的数跳出，不继续查
     *
     * 查完整个数组仍没有结果，则目标值不在这个二维数组中
     */

    /**
     * 查找一个数是否在二维数组中
     * @param matrix 二维数组，同一列下方的元素比上方的大，同一行右边的比左边的大
     * @param target 要查找的数
     * @return 是否包含要查找的数
     */
    private boolean find(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        if (matrix[0].length == 0) return false;
        if (target < matrix[0][0] || target > matrix[matrix.length-1][matrix[matrix.length-1].length-1])
            return false;

        // r 行，   c 列
        for (int c = matrix[0].length-1; c>=0; c--) {
            if (target == matrix[0][c])
                return true;
            if (target < matrix[0][c])
                continue;

            for (int r = 0; r < matrix.length; r++) {
                System.out.println(r +"行, "+ c+"列: " + matrix[r][c]);
                if (target == matrix[r][c])
                    return true;
                if (target < matrix[r][c])
                    break;
            }
        }

        return false;
    }

    @Test
    public void Test() {
        int[][] input = {
                {1, 2, 8,  9 },
                {2, 4, 9,  12},
                {4, 7, 10, 13},
                {6, 8, 11, 15},
        };

        boolean res = find(input, 100);
        System.out.println(res);
    }
}

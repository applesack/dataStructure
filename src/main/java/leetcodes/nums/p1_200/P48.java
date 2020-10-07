package leetcodes.nums.p1_200;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月16日 22:00
 */
public class P48 {

    @Test
    public void testFunc() {
        int[][] in = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        rotate(in);

        for (int[] line : in) {
            System.out.println(Arrays.toString(line));
        }
    }

    public void rotate(int[][] matrix) {

        if (matrix.length <= 0)
            return;

        // 将矩形转为一维数组
        int count = matrix.length * matrix[0].length;
        int[] nums = new int[count];
        int idx = 0;

        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                nums[idx++] = ints[j];
            }
        }

        // 复位
        idx = 0;

        // 按照一定遍历顺序填充原数组
        for (int c = matrix[0].length - 1; c>=0; c--) {
            for (int r = 0; r<matrix.length; r++) {
                matrix[r][c] = nums[idx++];
            }
        }
    }

}

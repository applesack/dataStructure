package leetcodes.nums.p1_200;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月10日 12:52
 */
public class P74 {

    @Test
    public void testFunc() {
        int[][] matrix = {
                {1, 3}
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 50}
        };
        System.out.println(searchMatrix(matrix, 3));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length < 1) return false;
        int row = getRow(matrix, target);
        return find(matrix[row], target);
    }

    private int getRow(int[][] matrix, int target) {
        int top = 0, bottom = matrix.length - 1;
        int col = matrix[0].length - 1;
        while (top < bottom) {
            int mid = (top + bottom) / 2;
            if (matrix[mid][col] < target)
                top = mid + 1;
            else
                bottom = mid;
        }
        return top;
    }

    private boolean find(int[] data, int target) {
        int l = 0, r = data.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (data[mid] == target)
                return true;
            else if (data[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return false;
    }
}

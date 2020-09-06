package leetcodes.nums;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月30日 16:13
 */
public class P54 {

    @Test
    public void testFunc() {
        int[][] input_1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] input_2 = {
                {1, 2,  3,  4},
                {5, 6,  7,  8},
                {9, 10, 11, 12}
        };
        int[][] input_3 = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        int[][] input_4 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8}
        };

        System.out.println(spiralOrder(input_1));
        System.out.println(spiralOrder(input_2));
        System.out.println(spiralOrder(input_3));
        System.out.println(spiralOrder(input_4));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return list;

        // 设置上下左右边界
        int u = 0;
        int d = matrix.length - 1;
        int l = 0;
        int r = matrix[0].length - 1;

        while (true) {
            for (int i = l; i<=r; i++) list.add(matrix[u][i]); // 从左边界一直移动到有边界
            if (++u > d) break; // 更新上边界，若上边界大于下边界，则遍历完成
            for (int i = u; i<=d; i++) list.add(matrix[i][r]);
            if (--r < l) break;
            for (int i = r; i>=l; i--) list.add(matrix[d][i]);
            if (--d < u) break;
            for (int i = d; i>=u; i--) list.add(matrix[i][l]);
            if (++l > r) break;
        }
        return list;
    }

}

package leetcodes.nums.p401_600;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月23日 10:55
 */
public class P452 {

    @Test
    public void testFunc() {
        /**
         *    [2, 8]  [10, 16]
         * [1, 6],[7, 12]
         */
        int[][] in = {
//                {10, 16}, {2, 8}, {1, 6}, {7, 12}
//                {0, 20}, {2, 19}, {3, 18}, {4, 17}, {5, 16}
//                {1, 2}, {3, 4}
                {3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}
        };
        System.out.println(findMinArrowShots(in));
    }

    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1)
            return points.length;

        // 将这些坐标按照第一个下标的大小排序
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int end = points[0][1];
        int len = points.length;
        int count = 1;

        int[] curPoint;
        for (int i = 1; i<len; i++) {
            curPoint = points[i];
            // 是否和前一个坐标连续
            if (curPoint[0] <= end) {
                if (curPoint[1] < end)
                    end = curPoint[1];
            } else {
                count ++;
                end = curPoint[1];
            }
        }

        return count;
    }

}

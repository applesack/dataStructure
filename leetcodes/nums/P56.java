package nums;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月01日 7:38
 */
public class P56 {

    @Test
    public void testFunc() {
        int[][] intervals = {
//                {1,3}, {2, 6}, {8, 10}, {12, 15}, {15, 18}
                {1, 4}, {1, 4}
//                {1, 4}, {1, 5}
//                {1, 2}, {2, 3}, {4, 5}, {6, 10}
        };
        intervals = merge(intervals);
        for (int[] item : intervals) {
            System.out.println(Arrays.toString(item));
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return new int[][] { };
        // 将二维数组按照第0个下标排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> resList = new ArrayList<>();
        int len = intervals.length;
        int start, end, j;
        for (int i = 0; i<len; i++) {
            start  = intervals[i][0];
            end    = intervals[i][1];

            j = i + 1;
            while (j < len && intervals[j][0] <= end) {
                if (intervals[j][1] > end)
                    end = intervals[j][1];
                j++;
            }
            resList.add(new int[]{start, end});
            i = --j;
        }

        int[][] res = new int[resList.size()][];
        return resList.toArray(res);
    }

}

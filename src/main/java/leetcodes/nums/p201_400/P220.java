package leetcodes.nums.p201_400;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月27日 12:51
 */
public class P220 {

    @Test
    public void testFunc() {
        int[] in =
//                {-2147483648,2147483647};
                {1, 3, 6, 2};
        System.out.println(containsNearbyAlmostDuplicate(in, 1, 1));
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;

        if (len < 2)
            return false;

        int[][] rows = new int[len][];

        for (int i = 0; i<len; i++) {
            rows[i] = new int[]{nums[i], i};
        }

        Arrays.sort(rows, Comparator.comparingInt(a -> a[0]));

        for (int i = 1; i<len; i++) {
            long sub = (long) Math.max(rows[i][0], rows[i - 1][0]) - (long) Math.min(rows[i][0], rows[i - 1][0]);
            if (sub <= t) {
                if (Math.max(rows[i][1], rows[i - 1][1]) - Math.min(rows[i][1], rows[i - 1][1]) <= k)
                    return true;
            }
        }

        return false;
    }

}

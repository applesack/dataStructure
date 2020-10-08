package leetcodes.nums.p201_400;

import leetcodes.nums.p1_200.P20;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月07日 22:34
 */
public class P209 {

    @Test
    public void testFunc() {
        int[] in = {2, 5, 1, 2, 3, 4};
        int target = 7;
        System.out.println(minSubArrayLen(target, in));
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1 && nums[0] != s)
            return 0;

        int l = 0, len = nums.length, sum = 0, min = 0;
        for (int r = 0; r<len; r++) {
            sum += nums[r];
            while (sum >= s) {
                min = min == 0 ? r - l + 1 : Math.min(min, r - l + 1);
                sum -= nums[l++];
            }
        }

        return min;
    }

}

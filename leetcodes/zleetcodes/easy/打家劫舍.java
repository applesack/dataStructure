package zleetcodes.easy;

import zleetcodes.util.LeetCodes;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月22日 16:44
 */

@LeetCodes(
        id = 198,
        level = LeetCodes.LEVEL.EASY,
        status = LeetCodes.Status.FINISHED,
        tags = {"动态规划"},
        createDate = "2020/05/22",
        finishTime = "1h"
)
public class 打家劫舍 {

    // Case1
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;

        int[] values = new int[nums.length+1];

        values[0] = 0;
        values[1] = nums[0];
        for (int i = 2; i<values.length; i++) {
            values[i] = Math.max(values[i-2]+nums[i-1], values[i-1]);
        }

        return values[values.length-1];
    }

    @Test
    public void Run() {
//        int[] input = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
//        int[] input = {2,1,1};
        int[] input = {3,2};
        System.out.println("输入: " + Arrays.toString(input));
        System.out.println("输出: " + rob(input));
    }
}

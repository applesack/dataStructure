package leetcodes.medium;

import leetcodes.util.LeetCodes;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月22日 20:35
 */

@LeetCodes(
        id = 213,
        level = LeetCodes.LEVEL.MEDIUM,
        status = LeetCodes.Status.UN_START,
        tags = {"动态规划"},
        createDate = "2020/05/22",
        finishTime = "1h"
)
public class 打家劫舍II {

//    public int rob(int[] nums) {
//        if (nums.length <= 3)
//            return Arrays.stream(nums).max().orElse(0);
//
//        // [0,3,2,2,3]
//        int preTemp = 0;
//        int fixTemp = nums[0];
//        int temp;
//        int max = 0;
//        for (int i = 1; i<nums.length; i++) {
//            preTemp = fixTemp + nums[i];
//            fixTemp = max + nums[i-1];
//            temp = Math.max(preTemp, fixTemp);
//            max = Math.max(max, temp);
//        }
//
//        return max;
//    }

    @Test
    public void Run() {
//        int[] input = {3,2,2,3};
//        System.out.println("输入: " + Arrays.toString(input));
//        System.out.println("输出: " + rob(input));
    }
}

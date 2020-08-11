package zleetcodes.medium;

import zleetcodes.util.LeetCodes;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月21日 10:44
 */

@LeetCodes(
        id = 11,
        level = LeetCodes.LEVEL.MEDIUM,
        status = LeetCodes.Status.FINISHED,
        tags = {"数组", "双指针"},
        createDate = "2020/05/21",
        finishTime = "1h"
)
public class 盛水最多的容器 {

    public static int maxArea(int[] height) {

        int max = 0;

        int left = 0, right = height.length-1;

        while (left != right) {

            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
//            System.out.println(left + ", "+ right +", "+ max);

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

    @Test
    public void Run() {
        int[] input = {1,8,6,2,5,4,8,3,7};
        System.out.println("输入: " + Arrays.toString(input));
        System.out.println("输出: " + maxArea(input));
    }
}

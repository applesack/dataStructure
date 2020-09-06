package leetcodes.zleetcodes.medium;

import leetcodes.zleetcodes.util.LeetCodes;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月21日 15:51
 */

@LeetCodes(
        id = 15,
        level = LeetCodes.LEVEL.MEDIUM,
        status = LeetCodes.Status.FINISHED,
        tags = {"数组", "三指针"},
        createDate = "2020/05/21",
        finishTime = "1h"
)
public class 三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3) return ans;
        Arrays.sort(nums);

        for (int i = 0; i<len; i++) {
            // 因为数组是已经排序好了的，假如当前数字大于0，那么后面的数字也会大于0，所以不用继续比较
            if (nums[i] > 0) break;
            // 这是因为假如i与上一个数字相同，那么这个数字也已经判断过一遍，不用再判断
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int L = i+1; // 左指针 数组的下标
            int R = len-1; // 右指针 数组的下标

            while (L < R) { // 指针未相遇
                int sum = nums[i] + nums[L] + nums[R]; // 总和等于三个指针的下标对应的值相加
                if (sum == 0) { // 找到了目标
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));

                    // L或者R与自己将要判断的下一个数相等，那么这个数的可能性已经处理过一遍，则让指针对应的移动一格
                    while (L < R && nums[L] == nums[L+1]) L++;
                    while (L < R && nums[R] == nums[R-1]) R--;

                    L++;
                    R--;
                }

                /**
                 * 由于数组是已经排序过的，而且L和R分别是处于左右两边的指针
                 * 所以 L 必定小于L右边的下标，同理，R大于R左边的下标，
                 * 可以通过移动L和R来接近目标
                 */
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }

    @Test
    public void Run() {
        int[] input = {-1, 0, 1, 2, -1, -4};
        System.out.println("输入: " + Arrays.toString(input));
        System.out.println("输出: ");
        for (List<?> list : threeSum(input)) {
            System.out.println(list.toString());
        }
    }
}

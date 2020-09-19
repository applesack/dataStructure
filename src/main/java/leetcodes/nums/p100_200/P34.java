package leetcodes.nums.p100_200;

import offer.part2.P3;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月16日 22:24
 */
public class P34 {

    @Test
    public void testFunc() {

    }

    public int[] searchRange(int[] nums, int target) {
        int[] Does_Not_Exist = {-1, -1};
        if (nums == null || target < nums[0] || target > nums[nums.length - 1])
            return Does_Not_Exist;

        // 使用二分查找搜索target出现的位置
        int left = 0, right = nums.length - 1, mid;
        int target_idx = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                target_idx = mid;
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (target_idx == -1)
            return Does_Not_Exist;

        // 向左，一直找到第一个target
        int lest = target_idx;
//        for (int i = lest; i>=0; i--) {
//            if (i == 0 || )
//        }
        return Does_Not_Exist;
    }

}

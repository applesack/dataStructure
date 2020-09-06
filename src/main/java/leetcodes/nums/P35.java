package leetcodes.nums;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月25日 8:41
 */
public class P35 {

    @Test
    public void testFunc() {
        int[] input_1 = {1,3,5,6};
        int[] input_2 = {1,3,5,6};
        int[] input_3 = {1,3};
        System.out.println(searchInsert(input_1, 5));
        System.out.println(searchInsert(input_2, 2));
        System.out.println(searchInsert(input_2, 7));
        System.out.println(searchInsert(input_2, 0));
        System.out.println(searchInsert(input_3, 2));
    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;

        int len = nums.length;
        if (target < nums[0])
            return 0;
        if (target > nums[len - 1])
            return len;

        // 二分查找
        int left = 0, right = len - 1, mid = left;
        while (left <= right) {
            mid = (left + right) / 2;
            if (target == nums[mid])
                return mid;
            if (target < nums[mid]) {
                if (nums[mid - 1] < target)
                    return mid;
                right = mid - 1;
            } else {
                if (nums[mid + 1] > target)
                    return mid + 1;
                left = mid + 1;
            }
        }

        return mid;
    }
}

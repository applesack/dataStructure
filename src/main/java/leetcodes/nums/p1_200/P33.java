package leetcodes.nums.p1_200;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月25日 9:54
 */
public class P33 {

    @Test
    public void testFunc() {
        int[] input = {4,5,6,7,0,1,2};
        System.out.println(search(input, 0));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int  left  = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[left] == nums[right] && nums[right] == nums[mid])
                return Traverse(nums, left, right, target);
            if (nums[0] <= nums[mid]) {        // 向大端查找
                if (target >= nums[0] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {                         // 向小端查找
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    // 遍历数组
    public int Traverse(int[] data, int left, int right, int target) {
        for (int i = left; i<=right; i++) {
            if (data[i] == target)
                return i;
        }

        return -1;
    }
}

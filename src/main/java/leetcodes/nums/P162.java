package leetcodes.nums;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月17日 10:21
 */
public class P162 {

    @Test
    public void testFunc() {
        int[] in = {1, 2, 3, 1};
        System.out.println(findPeakElement(in));
    }

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        if (nums.length == 1)
            return 0;

        if (nums[0] > nums[1])
            return 0;
        if (nums[nums.length - 1] > nums[nums.length - 2])
            return nums.length - 1;

        for (int i = 1; i<nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] &&
                    nums[i] > nums[i + 1]) {
                return i;
            }
        }

        return -1;
    }

}

package leetcodes.nums;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月13日 14:21
 */
public class P215 {

    @Test
    public void testFunc() {
        int[] in =
//                {3, 2, 1, 5, 6, 4};
                {3, 2, 3, 1, 2, 4, 5, 5, 6}; // 1, 2, 3, 3, 4, 5, 5,
        System.out.println(findKthLargest(in, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length - k];
    }

}

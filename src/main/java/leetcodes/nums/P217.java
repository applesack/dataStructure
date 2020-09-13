package leetcodes.nums;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月13日 14:06
 */
public class P217 {

    @Test
    public void testFunc() {
        int[] in = {1, 2, 3, 1};
        System.out.println(containsDuplicate(in));
    }

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i<nums.length; i++) {
            if (nums[i] == nums[i - 1])
                return true;
        }

        return false;
    }

}

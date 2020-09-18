package leetcodes.nums;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月18日 18:17
 */
public class P268 {

    @Test
    public void testFunc() {
        int[] in = {0};
        System.out.println(missingNumber(in));
    }

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;
        for (int i = 0; i<len; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return len;
    }

}

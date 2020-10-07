package leetcodes.nums.p1_200;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月03日 20:46
 */
public class P136 {

    public int singleNumber(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        Arrays.sort(nums);

        if (nums[0] != nums[1])
            return nums[0];

        for (int i = 1; i<nums.length - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1])
                return nums[i];
        }

        return nums[nums.length - 1];
    }

}

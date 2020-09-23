package leetcodes.nums.p401_600;

import java.util.List;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月22日 20:38
 */
public class P561 {

    public int arrayPairSum(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.min(nums[0], nums[1]);

        int min = Integer.MAX_VALUE;
        int minSum = Integer.MIN_VALUE;

//        for (int i = 2; )
        return -1;
    }

    private static final Integer MAX = Integer.MAX_VALUE;
    private int getMin(int[] nums, int left, int right) {
        int MIN = MAX;
        if (right > nums.length - 1)
            right = nums.length - 1;
        for (int i = left; i<=right; i++) {
            if (MIN < nums[i])
                MIN = nums[i];
        }
        return MIN;
    }
}

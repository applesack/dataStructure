package leetcodes.nums.p401_600;

import demo.myImpl.sortAlgorithm.IntervalSort;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月20日 10:08
 */
public class P414 {

    @Test
    public void testFunc() {
        int[] in = {2, 2, 3};
        System.out.println(thirdMax(in));
    }

    public int thirdMax(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        long max_1 = Long.MIN_VALUE,
                max_2 = Long.MIN_VALUE,
                    max_3 = Long.MIN_VALUE;
        int curVal;
        for (int num : nums) {
            curVal = num;
            if (curVal > max_1) {
                max_3 = max_2;
                max_2 = max_1;
                max_1 = curVal;
            } else if (curVal < max_1 && curVal > max_2) {
                max_3 = max_2;
                max_2 = curVal;
            } else if (curVal < max_2 && curVal > max_3) {
                max_3 = curVal;
            }
        }

        return max_3 == Long.MIN_VALUE ?
                Long.valueOf(max_1).intValue() : Long.valueOf(max_3).intValue();
    }

}

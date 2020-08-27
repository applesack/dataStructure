package nums;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月27日 11:22
 */
public class P45 {

    @Test
    public void testFunc() {
//        int[] input = {2, 3, 1, 1, 4};
        int[] input = {1, 2};
        System.out.println(jump(input));
    }

    public int jump(int[] nums) {
        if (nums.length == 1)
            return 0;
        if (nums.length == 2)
            return 1;

        int index  = 0;
        int target = nums.length - 1;

        int minCount = 0;

        int curStep, maxVal, maxValIdx, tmp;
        while (index < target - 1) {
            curStep = nums[index];

            maxVal = -1; maxValIdx = index;
            for (int i = index + 1; i<target && i<=curStep; i++) {
                tmp = i + nums[i];
                if (tmp > maxVal) {
                    maxValIdx = i;
                    maxVal    = tmp;
                }
            }

            index = maxValIdx;
            minCount++;
        }

        return minCount;
    }

}

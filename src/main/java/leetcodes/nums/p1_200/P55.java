package leetcodes.nums.p1_200;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月01日 13:06
 */
public class P55 {

    @Test
    public void testFunc() {
        int[] input =
//                {2, 3, 1, 1, 4};
//                {3, 2, 2, 0, 4};
//                {2, 0};
                {4, 3, 2, 1, 0, 4};
        System.out.println(canJump(input));
    }

    public boolean canJump(int[] nums) {
        int curPos = 0;
        int target = nums.length - 1;

        int maxWeight, curWeight, curVal, maxStep;
        while (curPos < target) {
            curVal = nums[curPos];
            if (curVal == 0)
                return false;
            int end = Math.min(curPos + curVal, target) - curPos;

            maxWeight = Integer.MIN_VALUE;
            maxStep = curPos + 1;
            for (int i = 1; i<=end; i++) {
                curWeight = nums[curPos + i] + i;
                if (curWeight >= maxWeight) {
                    maxWeight = curWeight;
                    maxStep = i;
                }
            }

            curPos += maxStep;
            if (curPos >= target)
                return true;
        }
        return true;
    }
}

package leetcodes.nums;

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
//                {3, 2, 1, 0, 4};
//                {2, 0};
                {2, 5, 0, 0, 0};
        System.out.println(canJump(input));
    }

    public boolean canJump(int[] nums) {
        int curPos = 0;
        int target = nums.length - 1;

        int maxWeight, curWeight, curVal, maxStep;


        while (true) {
            curVal = nums[curPos];
            maxWeight = 0;
            maxStep   = curPos;

            if (curPos >= target)
                break;
            if (curVal == 0)
                return false;

            for (int i = curPos; i<curVal; i++) {
                curWeight = i + nums[i];
                if (curWeight > maxWeight) {
                    maxWeight = curWeight;
                    maxStep   = i;
                }
            }

            curPos += nums[maxStep];
        }

        return true;
    }
}

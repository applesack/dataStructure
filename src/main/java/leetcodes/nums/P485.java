package leetcodes.nums;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月12日 10:52
 */
public class P485 {

    @Test
    public void testFunc() {
        int[] in = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(in));
    }

    public int findMaxConsecutiveOnes(int[] nums) {

        int maxCount = 0;
        int curCount = 0;

        for (int i = 0; i<nums.length; i++) {
            if (nums[i] == 0) {
                if (curCount > maxCount) {
                    maxCount = curCount;
                }
                curCount = 0;
            } else {
                curCount += 1;
            }
        }

        return Math.max(maxCount, curCount);
    }

}

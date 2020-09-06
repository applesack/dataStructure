package offer.part6;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月21日 14:54
 */
public class P63 {

    @Test
    public void testFunc() {
        int[] input = {9,11,8,5,7,12,16,14};
        System.out.println(maxDiff(input));
    }

    public static void main(String[] args) {
        int[] input = {9,11,8,5,7,12,16,14};
        System.out.println(maxDiff(input));
    }

    private static int maxDiff(int[] nums) {
        if (nums == null || nums.length <= 1)
            return -1;
        if (nums.length == 2)
            return nums[1] - nums[0];

        int min = nums[0];
        int maxDiff = nums[1] - min;

        for (int i = 2; i<nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                continue;
            }

            int currentDiff = nums[i] - min;
            if (currentDiff > maxDiff)
                maxDiff = currentDiff;
        }

        return maxDiff;
    }
}

package leetcodes.nums.p201_400;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月10日 22:02
 */
public class P303 {

    @Test
    public void testFunc() {
        System.out.println(new NumArray(new int[]{-2, 0, 3, -5, 2, -1}).sumRange(0, 2));
    }

    static class NumArray {

        private int[] nums;
        private int[] sums;

        public NumArray(int[] nums) {
            this.nums = nums;
            this.sums = new int[nums.length];

            if (nums.length > 0)  {
                this.sums[0] = nums[0];
                for (int i = 1; i<nums.length; i++) {
                    sums[i] = nums[i] + sums[i - 1];
                }
            }
        }

        public int sumRange(int i, int j) {
            // 检查边界
            if (i > 0 || j > nums.length - 1)
                return 0;

            i -= 1;
            if (i == -1)
                return sums[j];
            return sums[j] - sums[i];
        }
    }

}

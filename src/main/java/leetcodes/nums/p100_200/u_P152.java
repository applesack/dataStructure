package leetcodes.nums.p100_200;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月25日 22:27
 */
public class u_P152 {

    public int maxProduct(int[] nums) {
        int max = 0;
        if (nums == null || nums.length <= 1)
            return max;
        if (nums.length == 2)
            return nums[0] * nums[1];

        int[] dp = new int[nums.length];
        return -1;
    }

}

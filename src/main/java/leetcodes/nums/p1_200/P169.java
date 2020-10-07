package leetcodes.nums.p1_200;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月23日 15:49
 */
public class P169 {

    @Test
    public void testFunc() {
        int[] in = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(in));
    }

    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 1;
        for (int i = 1; i< nums.length; i++) {
            if (nums[i] == res) {
                count ++;
            } else {
                count --;
                if (count == 0) {
                    res = nums[i + 1];
                }
            }
        }

        return res;
    }

}

package offer.part5;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月14日 15:15
 */
public class P39 {

    @Test
    public void testFunc() {
        int[] input = {2,3,2,2,2,5,6,7,1,3,2,2};
        System.out.println(moreThenHalfNum(input));
    }

    private int moreThenHalfNum(int[] nums) {
        if (nums == null)
            return -1;
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        Integer val = nums[0];
        for (int num : nums) {
            val = map.get(num);
            val = val == null ? 1 : val + 1;
            if (val > max)
                max = num;
            map.put(num, val);
        }

        return max;
    }
}

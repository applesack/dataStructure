package nums;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月24日 21:15
 */
public class P1 {

    @Test
    public void testFunc() {
        int[] input = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(input, 9)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i<nums.length; i++) {
            int idx = map.getOrDefault(target - nums[i], -1);
            if (idx != -1 || idx != i)
                return new int[] {i, idx};
        }

        return new int[0];
    }
}

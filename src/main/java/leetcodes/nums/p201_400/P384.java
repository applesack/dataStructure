package leetcodes.nums.p201_400;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月27日 16:54
 */
public class P384 {

    @Test
    public void testFunc() {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution(nums);
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
    }

    private static class Solution {

        int[] original;
        int[] res;
        LinkedList<Integer> array;
        Random random;

        public Solution(int[] nums) {
            original = nums;
            res = new int[nums.length];
            array = new LinkedList<>();
            random = new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return Arrays.copyOf(original, original.length);
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int pos = 0;
            array.clear();
            for (int num : original) {
                array.add(num);
            }
            while (array.size() > 0) {
                res[pos] = array.remove(random.nextInt(array.size()));
                pos++;
            }
            return res;
        }
    }

}

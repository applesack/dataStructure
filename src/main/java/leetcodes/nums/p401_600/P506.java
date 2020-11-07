package leetcodes.nums.p401_600;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年11月07日 11:24
 */
public class P506 {

    @Test
    public void testFunc() {
        int[] nums = {10, 3, 8, 9, 4};
        System.out.println(Arrays.toString(findRelativeRanks(nums)));
    }

    private static final String[] MEDALS = {
            "Gold Medal", "Silver Medal", "Bronze Medal"
    };

    public String[] findRelativeRanks(int[] nums) {
        int size = nums.length;
        int[][] factWhitIdx = new int[size][2];
        for (int i = 0; i<size; i++) {
            factWhitIdx[i][0] = nums[i];
            factWhitIdx[i][1] = i;
        }
        Arrays.sort(factWhitIdx, Comparator.comparingInt(a -> a[0]));
        String[] ans = new String[size];
        int value, idx;
        for (int i = 0; i<size; i++) {
            value = size - i;
            idx = factWhitIdx[i][1];
            ans[idx] = String.valueOf(value);
        }

        int first3 = Math.min(3, size);
        for (int i = size - 1; i>=(size - first3); i--) {
            idx = factWhitIdx[i][1];
            ans[idx] = MEDALS[size - i - 1];
        }

        return ans;
    }

}

package leetcodes.nums.p201_400;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月23日 9:59
 */
public class P228 {

    @Test
    public void testFunc() {
        int[] in =
//                {0, 1, 2, 4, 5, 7};
//                {0, 2, 3, 4, 6, 8, 9};
                {1, 2};
        System.out.println(summaryRanges(in));
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        if (nums.length == 1) {
            res.add(String.valueOf(nums[0]));
            return res;
        }

        StringBuilder sb = new StringBuilder();
        int start = 0, end = 0;

        int len = nums.length;
        for (int i = 1; i<len; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                end += 1;
            } else {
                if (start == end) {
                    res.add(String.valueOf(nums[start]));
                } else {
                    sb.append(nums[start]);
                    sb.append("->");
                    sb.append(nums[end]);
                    res.add(sb.toString());
                    sb.setLength(0);
                }
                end = start = i;
            }
        }

        if (nums[len - 1] - nums[len - 2] == 1) {
            sb.append(nums[start]);
            sb.append("->");
            sb.append(nums[end]);
            res.add(sb.toString());
            sb.setLength(0);
        } else {
            res.add(String.valueOf(nums[end]));
        }

        return res;
    }

}

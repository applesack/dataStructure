package leetcodes.nums.p1_200;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月17日 13:27
 */
public class P84 {

    @Test
    public void testFunc() {
        int[] input = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(input));
    }

    public int largestRectangleArea(int[] heights) {
        List<Integer> hList = Arrays.stream(heights)
                .boxed().distinct().collect(Collectors.toList());

        int max_value = 0, cur_value;
        int[] dp = new int[heights.length];
        for (int hei : hList) {

            dp[0] = heights[0] >= hei ? 1 : 0;

            for (int i = 1; i<heights.length; i++) {
                if (heights[i] >= hei)
                    dp[i] = dp[i - 1] + 1;
                else
                    dp[i] = 0;
            }

            cur_value = IntStream.of(dp).max().getAsInt() * hei;
            if (cur_value > max_value)
                max_value = cur_value;
        }

        return max_value;
    }

}

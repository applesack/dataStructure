package offer.part5;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月15日 16:40
 */
public class P42 {
    @Test
    public void testFunc() {
        int[] input = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(findGreatestSumOfSubArray(input));
        System.out.println(r_2(input));
    }

    private int findGreatestSumOfSubArray(int[] data) {
        if (data == null || data.length == 0)
            return -1;
        int len = data.length;
        int[] dp = new int[len + 1];

        dp[0] = data[0];
        int currentValue;
        for (int i = 1; i<len; i++) {
            currentValue = data[i];

            dp[i] = Math.max(currentValue,
                    currentValue + dp[i - 1]);
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    // 暴力解法
    private int r_2(int[] data) {
        if (data == null || data.length == 0)
            return -1;
        int len = data.length;
        int[] sums = new int[len];

        // 获取每个位置的元素累加的值
        sums[0] = data[0];
        for (int i = 1; i<len; i++) {
            sums[i] = data[i] + sums[i - 1];
        }

        int[] dp = new int[len];
        int sum, tmp, max;
        for (int i = len - 1; i>=0; i--) {
            sum = sums[i]; max = sum;
            for (int j = 0; j<i; j++) {
                tmp = sum - sums[j];
                if (tmp > max)
                    max = tmp;
            }
            dp[i] = max;
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}

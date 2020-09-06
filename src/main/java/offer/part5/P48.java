package offer.part5;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月16日 10:46
 */
public class P48 {

    @Test
    public void testFunc() {
        String input = "aca";
        System.out.println(longestSubstringWithoutDuplication(input));
    }

    // arabcacfr
    private int longestSubstringWithoutDuplication(String str) {
        if (str == null || str.length() == 0)
            return 0;

        int len = str.length();
        char[] chars = str.toCharArray();
        int[] dp = new int[len];
        dp[0] = 1;

        for (int i = 1; i<len; i++) {
            if (chars[i] != chars[i - dp[i - 1]])
                dp[i] = dp[i - 1] + 1;
            else
                dp[i] = 1;
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}

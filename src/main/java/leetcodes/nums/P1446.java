package leetcodes.nums;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月11日 9:52
 */
public class P1446 {

    @Test
    public void testFunc() {
        String in =
//                "leetcode";
                "abbcccddddeeeeedcba";
        System.out.println(maxPower(in));
    }

    public int maxPower(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int[] dp = new int[s.length()];
        char[] chars = s.toCharArray();

        dp[0] = 1;
        for (int i = 1; i<s.length(); i++) {
            if (chars[i] == chars[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }

        return IntStream.of(dp).max().getAsInt();
    }

}

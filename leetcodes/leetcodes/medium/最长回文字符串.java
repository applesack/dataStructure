package leetcodes.medium;

import leetcodes.util.LeetCodes;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月20日 10:02
 */

@LeetCodes(
        id = 5,
        level = LeetCodes.LEVEL.MEDIUM,
        status = LeetCodes.Status.FINISHED,
        tags = {"字符串", "动态规划"},
        createDate = "2020/05/20",
        finishTime = "57m"
)
public class 最长回文字符串 {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1)
            return s;

        int maxLen_index = 0;
        int maxLen = 1;
        int left;
        int right;
        int[][] dp = new int[s.length()][2];

        dp[0][0] = 0; // 初始值 左
        dp[0][1] = 1; // 初始值 右
        for (int i = 1; i<=s.length()-1; i++) {
            // 假如当前字符与上一个字符相等，则以这两个字符为中心向两边查找
            if (s.charAt(i) == s.charAt(i-1)) {
                left = i-1;
                right = i;
                while ((left >= 0 && right < s.length()) && (s.charAt(left) == s.charAt(right))) {
                    left--;
                    right++;
                }

                dp[i][0] = ++left;
                dp[i][1] = right;
            }

            // 假如当前字符的左右字符相等，则以当前字符的左右为中心两边查找
            if ((i+1 < s.length()) && s.charAt(i-1) == s.charAt(i+1)) {
                left = i;
                right = i;
                while ((left >= 0 && right < s.length()) && (s.charAt(left) == s.charAt(right))) {
                    left--;
                    right++;
                }

                if ((dp[i][1] - dp[i][0]) < (right - left)) {
                    dp[i][0] = ++left;
                    dp[i][1] = right;
                }
            }

            if ((dp[i][1] - dp[i][0]) > maxLen) {
                maxLen_index = i;
                maxLen = dp[i][1] - dp[i][0];
            }
        }

        return s.substring(dp[maxLen_index][0], dp[maxLen_index][1]);
    }

    @Test
    public void Run() {
        String input = "qsqwawdwdwdwasi";
        System.out.println("输入: " + input);
        System.out.println("输出: " + longestPalindrome(input));
    }
}

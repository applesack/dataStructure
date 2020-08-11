package zleetcodes.medium;

import zleetcodes.util.LeetCodes;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月18日 10:53
 */

@LeetCodes(
        id = 3,
        level = LeetCodes.LEVEL.MEDIUM,
        status = LeetCodes.Status.FINISHED,
        createDate = "2020/05/18"
)
public class 无重复字符串最长子串 {

    public static int lengthOfLongestSubstring(String s) {
        int index;
        int res = 0;

        int[] last = new int[128];

        int start = 0;

        for (int i = 0; i<s.length(); i++) {
            index = s.charAt(i);

            start = Math.max(start, last[index]);
            res = Math.max(res, i - start + 1);
            last[index] = i+1;
        }

        return res;
    }

    @Test
    public void Run() {
        System.out.println(lengthOfLongestSubstring("abcacbdfgt"));
    }
}

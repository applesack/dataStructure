package leetcodes.zleetcodes.easy;

import leetcodes.zleetcodes.util.LeetCodes;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年04月05日 21:28
 */

@LeetCodes(
        id = 28,
        status = LeetCodes.Status.FINISHED,
        createDate = "2020/04/05"
)
public class 实现strStr {

    public static int test(String haystack, String needle) {

        if (needle.length() == 0)
            return 0;
        else if (haystack==null || needle == null || haystack.length() < needle.length())
            return -1;

        for (int i = 0; i<haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0) &&
                    haystack.length()-i >= needle.length()) {
                boolean flag = true;
                for (int j=1; j<needle.length(); j++) {
                    if (haystack.charAt(i+j)!=needle.charAt(j)) {
                        flag = false;
                        break;
                    }
                    if (flag)
                        return i;
                }
            }
        }

        return -1;
    }

    @Test
    public void Run() {
        System.out.println(test("hello", "ll"));
        System.out.println(test("aaaaa", "bba"));
        System.out.println(test("aa", "bba"));
        System.out.println(test("aaaaa", ""));
    }
}

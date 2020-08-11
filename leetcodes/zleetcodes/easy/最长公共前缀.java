package zleetcodes.easy;

import zleetcodes.util.LeetCodes;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年04月06日 14:30
 */

@LeetCodes(
        id = 14,
        status = LeetCodes.Status.FINISHED,
        createDate = "2020/04/06"
)
public class 最长公共前缀 {

    public static String test(String[] strs) {

        if (strs.length == 0) return "";

        int i = 0;
        String prefix = "";
        String result;
        boolean broken = false;
        while (true) {
            i++;
            result = prefix;
            if (i > strs[0].length()) {
                break;
            }
            prefix = strs[0].substring(0, i);
            for (String word:strs) {
                if (i > word.length() || !word.startsWith(prefix)) {
                    broken = true;
                    break;
                }
            }
            if (broken) {
                break;
            }
        }

        return result;
    }

    @Test
    public void Run() {
        System.out.println(test(new String[]{"flower", "flow", "flight"}));
        System.out.println(test(new String[]{"dog", "racecar", "car"}));
        System.out.println(test(new String[]{"dog"}));
        System.out.println(test(new String[]{}));
    }
}

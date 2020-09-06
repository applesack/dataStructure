package leetcodes.zleetcodes.easy;

import leetcodes.zleetcodes.util.LeetCodes;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月17日 15:56
 */

@LeetCodes(
        id = 38,
        level = LeetCodes.LEVEL.EASY,
        status = LeetCodes.Status.FINISHED,
        createDate = "2020/04/17"
)
public class 外观数列 {

    private static String[] result;

    private static String test(int n) {
        StringBuffer str = new StringBuffer("1");
        StringBuffer temp = new StringBuffer();
        int count;
        while (n > 1) {
            str.append('#');
            count = 1;
            for (int i = 0; i<str.length()-1; i++) {
                if (str.charAt(i) == str.charAt(i+1)) {
                    count++;
                } else {
                    temp.append(count);
                    temp.append(str.charAt(i));
                    count = 1;
                }
            }
            str = temp;
            temp = new StringBuffer();
            n--;
        }
        return str.toString();
    }

    @Test
    public void Run() {
        System.out.println(test(2));
    }
}

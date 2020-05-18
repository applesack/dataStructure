package leetcodes.easy;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月17日 19:53
 */
public class 最后一个单词的长度 {

    public static int test(String s) {
        if (s.length() <= 0)
            return 0;

        int count = 0;
        int i = s.length()-1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        while (i >= 0 && s.charAt(i) != ' ') {
            count++;
            i--;
        }

        return count;
    }

    @Test
    public void Run() {
        System.out.println(test(" "));
    }
}

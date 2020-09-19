package leetcodes.nums.p401_600;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月17日 10:41
 */
public class P557 {

    @Test
    public void testFunc() {
        String in = "Let's take Leetcode contest";
        System.out.println(reverseWords(in));
    }

    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        StringBuilder tmp = new StringBuilder();

        char[] chars = s.toCharArray();

        for (int i = 0; i<s.length(); i++) {
            if (chars[i] == ' ') {
                tmp.reverse();
                res.append(tmp.toString());
                res.append(chars[i]);
                tmp.setLength(0);
            } else {
                tmp.append(chars[i]);
            }
        }

        if (tmp.length() > 0) {
            res.append(tmp.reverse().toString());
        }

        return res.toString();
    }

}

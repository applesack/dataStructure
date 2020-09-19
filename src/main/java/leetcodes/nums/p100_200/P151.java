package leetcodes.nums.p100_200;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月17日 22:47
 */
public class P151 {

    @Test
    public void testFunc() {
        String in = "the sky is blue";
        System.out.println(reverseWords(in));
    }

    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        StringBuilder tmp = new StringBuilder();

        int pos = 0;
        char[] chars = s.toCharArray();

        for (char that : chars) {
            if (that == ' ') {
                if (tmp.length() > 0) {
                    res.insert(0, tmp.toString());
                    res.insert(0, ' ');
                    tmp.setLength(0);
                }
            } else {
                tmp.append(that);
            }
        }

        if (tmp.length() > 0) {
            res.insert(0, tmp.toString());
            res.insert(0,' ');
        }

        res.delete(0, 1);
        return res.toString();
    }

}

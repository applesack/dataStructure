package leetcodes.nums.p401_600;

import org.junit.Test;

import java.nio.charset.Charset;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月11日 18:53
 */
public class P434 {

    @Test
    public void testFunc() {
        String in = "Hello, my name is John";
        System.out.println(countSegments(in));
    }

    public int countSegments(String s) {
        int count = 0;
        if (s == null || s.length() == 0)
            return count;

        int letterSize = 0;
        char curChar;
        int pos = 0;

        for (;pos<s.length(); pos++) {
            curChar = s.charAt(pos);
            if (curChar != ' ') {
                letterSize += 1;
            } else {
                if (letterSize > 0) {
                    count += 1;
                    letterSize = 0;
                }
            }
        }

        if (letterSize > 0)
            count += 1;
        return count;
    }

}

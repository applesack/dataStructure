package demo.util;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @author : flutterdash@qq.com
 * @since  : 2020年08月21日 10:52
 */
public class CharacterUtil {

    @Test
    public void testFunc() throws UnsupportedEncodingException {
        char[] c = {'一'};
        String unicode = new String(c);
        String gbk = new String(unicode.getBytes(), "GBK");
        System.out.println(gbk);
    }

    public static int getChineseCharacters(String str) {
        int count = 0;
        for (int i = 0; i<str.length(); i++) {
            int unicode = str.charAt(i);
            if (unicode >= 0x4E00 && unicode <= 0x9FFF)
                count++;
        }
        return count;
    }
}

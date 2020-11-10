package demo.util;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * 字符工具
 *
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

    // 获取字符串中中文字符的个数
    public static int getChineseCharacters(CharSequence str) {
        int count = 0;
        for (int i = 0; i<str.length(); i++) {
            int unicode = str.charAt(i);
            if (unicode >= 0x4E00 && unicode <= 0x9FFF)
                count++;
        }
        return count;
    }
}

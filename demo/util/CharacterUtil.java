package util;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月21日 10:52
 */
public class CharacterUtil {

    @Test
    public void testFunc() throws UnsupportedEncodingException {
        char[] c = {'一'};
        String unicode = new String(c);
        String gbk = new String(unicode.getBytes(), "GBK");
        System.out.println(gbk);
    }
}

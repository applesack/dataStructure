package leetcodes.nums.p201_400;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月26日 19:08
 */
public class P344 {

    @Test
    public void testFunc() {
        char[] s =
//                {'h', 'e', 'l', 'l', 'o'}
//                {'h', 'e', 'l', 'l'}
//                {'h', 'e', 'l'}
//                {'h', 'e'}
                {'h'}
                ;
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public void reverseString(char[] s) {
        int len = s.length - 1;
        int half = (s.length) >> 1;
        char tmp;
        for (int i = 0; i<half; i++) {
            tmp = s[i];
            s[i] = s[len - i];
            s[len - i] = tmp;
        }
    }

}

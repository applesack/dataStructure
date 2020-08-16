package part5;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月16日 16:06
 */
public class P50 {
    @Test
    public void testFunc() {
        String input = "abaccdeff";
        System.out.println(firstNotRepeatingChar(input));
    }

    private char firstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0)
            return ' ';

        int len = str.length();
        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        Integer count;
        for (int i = 0; i<len; i++) {
            count = map.get(chars[i]);
            if (count == null) {
                map.put(chars[i], 1);
            } else {
                map.put(chars[i], count + 1);
            }
        }

        int i = 0;
        while (i < len && map.get(chars[i]) != 1) {
            i++;
        }

        return i < len ? chars[i] : ' ';
    }
}

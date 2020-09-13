package leetcodes.nums;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月13日 16:02
 */
public class P242 {

    @Test
    public void testFunc() {
        String s = "rat";
        String t = "car";
        System.out.println(isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();

        char curChar;
        Integer curVal;
        for (int i = 0; i<s.length(); i++) {
            curChar = s.charAt(i);
            curVal = map.get(curChar);
            if (curVal == null) {
                map.put(curChar, 1);
            } else {
                map.put(curChar, curVal + 1);
            }
        }

        for (int i = 0; i<t.length(); i++) {
            curChar = t.charAt(i);
            curVal = map.get(curChar);
            if (curVal == null || curVal <= 0)
                return false;
            else {
                curVal -= 1;
                map.put(curChar, curVal);
            }
        }

        return true;
    }

}

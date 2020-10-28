package leetcodes.nums.p201_400;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : flutterdash@qq.com
 * @since  : 2020年09月20日 10:42
 */
public class P345 {

    @Test
    public void testFunc() {
        String in =
//                "hello"
//                "leetcode"
                "aA"
                ;
        System.out.println(reverseVowels(in));
    }

    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        char[] chars = s.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i<s.length(); i++) {
            if (set.contains(Character.toLowerCase(chars[i]))) {
                list.add(i);
            }
        }

        int len = list.size() - 1;
        int half = list.size() >> 1;
        char tmp;
        for (int i = 0; i<half; i++) {
            tmp = chars[list.get(i)];
            chars[list.get(i)] = chars[list.get(len - i)];
            chars[list.get(len - i)] = tmp;
        }

        return new String(chars);
    }

}

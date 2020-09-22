package leetcodes.nums.p201_400;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月20日 10:42
 */
public class P345 {

    @Test
    public void testFunc() {
        String in = "hello";
        System.out.println(reverseVowels(in));
    }

    public String reverseVowels(String s) {
        int l = 0, r = s.length() - 1;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        char[] chars = s.toCharArray();
        while (l < r) {
            while (l < s.length() && !set.contains(chars[l])) {
                l++;
            }
            while (r >= 0 && !set.contains(chars[r])) {
                r--;
            }
            if (l != r) {
                swap(chars, l, r);
            }
        }

        return s;
    }

    private void swap(char[] chars, int l, int r) {
        char tmp = chars[l];
        chars[l] = chars[r];
        chars[r] = tmp;
    }
}

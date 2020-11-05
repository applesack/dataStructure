package leetcodes.nums.p401_600;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年11月05日 18:41
 */
public class P409 {

    @Test
    public void testFunc() {
        String in = "abccccdd";
        System.out.println(longestPalindrome(in));
    }

    public int longestPalindrome(String s) {
        int size = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i<size; i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }
        int count = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value >= 2) {
                if (value % 2 == 0)
                    count += value;
                else
                    count += value - 1;
            }
        }

        return count < size ? count + 1 : count;
    }

}

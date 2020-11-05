package leetcodes.nums.p401_600;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年11月05日 19:39
 */
public class P520 {

    @Test
    public void testFunc() {
        String[] strings = {
                "USA",
                "FlaG",
                "Leetcode",
                "leetCode"
        };
        for (String s : strings)
            System.out.println(detectCapitalUse(s));
    }

    public boolean detectCapitalUse(String word) {
        int count = 0;
        int size = word.length();
        for (int i = 0; i<size; i++) {
            if (Character.isUpperCase(word.charAt(i)))
                count++;
        }

        if (Character.isUpperCase(word.charAt(0))) {
            return count == size || count == 1;
        } else {
            return count == 0;
        }
    }

}

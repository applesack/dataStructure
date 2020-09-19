package leetcodes.nums.p201_400;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月02日 11:34
 */
public class P392 {

    @Test
    public void testFunc() {
        String input = "ahbgc";
        System.out.println(isSubsequence(input, "abc"));
    }

    public boolean isSubsequence(String s, String t) {
        String tmp;
        tmp = t;
        t = s;
        s = tmp;

        if (s.length() < t.length())
            return false;

        int sIdx = 0;
        int tIdx = 0;

        int tmpIdx = 0;
        while (tIdx < t.length()) {
            if (sIdx > s.length() - 1)
                return false;

            tmpIdx = search(s, t.charAt(tIdx), sIdx);
            if (tmpIdx != -1) {
                sIdx = tmpIdx + 1;
                tIdx++;
            } else {
                return false;
            }
        }

        return true;
    }

    private int search(String s, char target, int start) {
        for (int i = start; i<s.length(); i++) {
            if (s.charAt(i) == target)
                return i;
        }
        return -1;
    }
}

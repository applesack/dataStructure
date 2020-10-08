package leetcodes.nums.p201_400;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月08日 10:37
 */
public class P205 {

    @Test
    public void testFunc() {
        String s = "ab";
        String t = "aa";
        System.out.println(isIsomorphic(s, t));
    }

    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.length() != t.length())
            return false;

        int len = s.length();
        if (len <= 1) return true;

        int[] s_template = getTemplate(s, len);
        int[] t_template = getTemplate(t, len);

        for (int i = 0; i<len; i++) {
            if (s_template[i] != t_template[i])
                return false;
        }

        return true;
    }

    private int[] getTemplate(String s, int len) {
        int[] template = new int[len];
        char[] sArr = s.toCharArray();
        for (int i = 1; i<len; i++) {
            char curChar = sArr[i];
            for (int j = 0; j<=i; j++) {
                if (curChar == sArr[j]) {
                    template[i] = j;
                    break;
                }
            }
        }
        return template;
    }
}

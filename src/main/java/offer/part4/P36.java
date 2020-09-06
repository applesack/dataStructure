package offer.part4;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月14日 9:30
 */
public class P36 {
    @Test
    public void testFunc() {
        String input = "abcdef";
        permutation(input);
    }

    private void permutation(String str) {
        if (str == null || str.length() == 0) return;

        permutationCore("", str, new StringBuffer());
    }

    private void permutationCore(String prefix, String suffix, StringBuffer tmp) {
        tmp.setLength(0);
        if (suffix.length() <= 1)
            System.out.println(tmp.append(prefix).append(suffix).toString());

        int len = suffix.length();
        if (len <= 1)
            return;

        char currentChar;
        for (int i = 0; i<len; i++) {
            tmp.setLength(0);
            currentChar = suffix.charAt(i);
            for (int j = 0; j<len; j++) {
                if (i != j) {
                    tmp.append(suffix.charAt(j));
                }
            }
            permutationCore(prefix + currentChar, tmp.toString(), tmp);
        }
    }
}

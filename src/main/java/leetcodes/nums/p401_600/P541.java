package leetcodes.nums.p401_600;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年11月07日 10:50
 */
public class P541 {

    @Test
    public void testFunc() {
        String in = "abcdefg";
        System.out.println(reverseStr(in, 2));
    }

    public String reverseStr(String s, int k) {
        int pos = 0;
        int size = s.length();
        StringBuilder sb = new StringBuilder();
        boolean flag = true;

        while (pos < size) {
            int r = Math.min(pos + k, size);
            if (flag) {
                for (int i = r - 1; i>=pos; i--) {
                    sb.append(s.charAt(i));
                }
                flag = false;
            } else {
                for (int i = pos; i<r; i++) {
                    sb.append(s.charAt(i));
                }
                flag = true;
            }
            pos += k;
        }

        return sb.toString();
    }

}

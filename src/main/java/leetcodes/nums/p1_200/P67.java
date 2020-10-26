package leetcodes.nums.p1_200;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月25日 22:56
 */
public class P67 {

    @Test
    public void testFunc() {
        System.out.println(addBinary("111111", "111111"));
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ca = 0, sum;
        // 从尾到头
        for (int aPos = a.length() - 1, bPos = b.length() - 1;
             aPos >= 0 || bPos >= 0;
             aPos--, bPos--) {

            sum = ca;
            sum += aPos >= 0 ? a.charAt(aPos) - '0' : 0;
            sum += bPos >= 0 ? b.charAt(bPos) - '0' : 0;
            sb.append(sum % 2);
            ca = sum >> 1;
        }

        if (ca != 0)
            sb.append('1');
        return sb.reverse().toString();
    }

}

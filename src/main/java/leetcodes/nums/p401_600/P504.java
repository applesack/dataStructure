package leetcodes.nums.p401_600;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年11月05日 19:51
 */
public class P504 {

    @Test
    public void testFunc() {
        System.out.println(convertToBase7(0));
    }

    public String convertToBase7(int num) {
        if (num == 0)
            return "0";

        String sign;
        if (num < 0) {
            sign = "-";
            num = -num;
        } else {
            sign = "";
        }

        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.insert(0, num % 7);
            num /= 7;
        }

        sb.insert(0, sign);
        return sb.toString();
    }

}

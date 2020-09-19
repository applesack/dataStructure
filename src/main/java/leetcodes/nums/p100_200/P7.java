package leetcodes.nums.p100_200;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月24日 9:29
 */
public class P7 {

    @Test
    public void testFunc() {
        int input = 1234567899;
        System.out.println(input);
        System.out.println(reverse(input));
    }

    public int reverse(int x) {
        StringBuffer sb = new StringBuffer();
        sb.append(x);

        // 是否是负数
        boolean flag = false;

        String resStr;
        if (sb.charAt(0) == '-') {
            flag = true;
            resStr = sb.reverse().substring(0, sb.length() - 1);
        } else {
            resStr = sb.reverse().toString();
        }

        int len = resStr.length();
        int resInt = 0;
        int tmp;
        for (int i = 0; i<len; i++) {
            tmp = resStr.charAt(i) - '0';
            resInt += tmp * Math.pow(10, len - i - 1);

            if (resInt >= Integer.MAX_VALUE)
                return 0;
        }

        return flag ? -resInt : resInt;
    }

    public static void main(String[] args) {
        
    }
}

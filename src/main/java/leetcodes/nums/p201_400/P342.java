package leetcodes.nums.p201_400;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月26日 11:28
 */
public class P342 {

    @Test
    public void testFunc() {
        System.out.println(isPowerOfFour(32));
    }

    public boolean isPowerOfFour(int num) {
        if (num == 1)
            return true;
        if (num < 4)
            return false;
        while (num > 4) {
            if (num % 4 != 0)
                return false;
            num >>= 2;
        }
        return num % 4 == 0;
    }

}

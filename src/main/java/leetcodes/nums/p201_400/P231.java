package leetcodes.nums.p201_400;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月26日 11:17
 */
public class P231 {

    @Test
    public void testFunc() {
        System.out.println(isPowerOfTwo(65));
    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        while (n > 1) {
            if (n % 2 != 0)
                return false;
            n >>= 1;
        }
        return true;
    }

}

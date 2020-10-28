package leetcodes.nums.p201_400;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月26日 11:35
 */
public class P326 {

    @Test
    public void testFunc() {
        System.out.println(isPowerOfThree(45));
    }

    public boolean isPowerOfThree(int n) {
        if (n <= 0)
            return false;
        while (n > 1) {
            if (n % 3 != 0)
                return false;
            n /= 3;
        }
        return true;
    }

}

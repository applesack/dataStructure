package leetcodes.nums.p201_400;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月27日 15:54
 */
public class P367 {

    @Test
    public void testFunc() {
        for (int i = 0; i<2000000; i++) {
            double sys = Math.sqrt(i);
            boolean sysRes = sys == (int) sys;
            boolean usrRes = isPerfectSquare(i);
            if (usrRes != sysRes)
                System.out.println("异常: " + i);
        }
    }

    public boolean isPerfectSquare(int num) {
        if (num < 0)
            return false;
        if (num <= 1)
            return true;

        // 二分查找
        long left = 0, right = num / 2;
        long res, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            res = mid * mid;
            if (res == num)
                return true;
            if (res > num) { // 向左查找
                right = mid - 1;
            } else {         // 向右查找
                left = mid + 1;
            }
        }

        return false;
    }

}

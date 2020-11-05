package leetcodes.nums.p401_600;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年11月05日 18:55
 */
public class P441 {

    @Test
    public void testFunc() {
        System.out.println(arrangeCoins(14));
    }

    public int arrangeCoins(int n) {
        int next = 0;
        while (n >= next) {
            n -= next;
            next++;
        }
        return --next;
    }

}

package leetcodes.nums.p401_600;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月15日 10:37
 */
public class P509 {

    @Test
    public void testFunc() {
        System.out.println(fib(5));
    }

    public int fib(int N) {
        if (N <= 0)
            return 0;
        if (N <= 2)
            return 1;
        int pre = 1, cur = 1, sum;
        for (int i = 2; i<N; i++) {
            sum = pre + cur;
            pre = cur;
            cur = sum;
        }

        return cur;
    }

}

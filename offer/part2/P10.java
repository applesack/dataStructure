package part2;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月03日 9:10
 */
public class P10 {

    @Test
    public void test_Fibonacci_solution_1() {
        for (int i = 0; i<10; i++) {
            System.out.println(Fibonacci_solution_1(i));
        }
    }

    // 斐波那契数列的循环方式实现
    private long Fibonacci_solution_1(int n) {
        if (n <= 2) return n;
        long[] res = {1,2};

        long sum;
        for (int i = 2; i<n; i++) {
            sum = res[0] + res[1];
            res[0] = res[1];
            res[1] = sum;
        }

        return res[1];
    }
}

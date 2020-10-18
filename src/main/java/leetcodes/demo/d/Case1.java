package leetcodes.demo.d;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月18日 19:53
 */
public class Case1 {

    @Test
    public void testFunc() {
        int[] salaries = {800, 1200, 3000, 5000, 10000, 12000};
        for (int sal : salaries) {
            getResSalary(sal);
        }
    }

    private static final double[] PROFIT_LIST = {0f, 0.1f, 0.15f, 0.2f, 0.25f};
    private static final Strategy[] STRATEGY_LIST = {
        (sal) -> inInterval(sal, 0, 1000),
        (sal) -> inInterval(sal, 1000, 2000),
        (sal) -> inInterval(sal, 2000, 5000),
        (sal) -> inInterval(sal, 5000, 10000),
        (sal) -> inInterval(sal, 10000, 100000)
    };

    public static void getResSalary(int salary) {
        for (int i = 0; i<STRATEGY_LIST.length; i++) {
            if (STRATEGY_LIST[i].interval(salary)) {
                System.out.printf("改员工当月最终工资为: %.2f\n", (salary * PROFIT_LIST[i] + salary));
                break;
            }
        }
    }

    private static boolean inInterval(int sal, int left, int right) {
        return sal > left && sal <= right;
    }

    interface Strategy {
        boolean interval(int sal);
    }

}

package leetcodes.demo.d;

import lombok.Data;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月18日 20:37
 */
@Data
public class Case2 {

    @Test
    public void testFunc() {
        System.out.println(getFactSum(1));
    }

    public static void main(String[] args) {
        // 要计算的阶乘和
        int n = 5; // 以5为例
        System.out.println(getFactSum(n));
    }

    public static int getFactSum(int n) {
        return getFactSum(1, n);
    }

    private static int getFactSum(int n, int target) {
        if (n == target)
            return getFactorial(1, target);
        return getFactorial(1, n) + getFactSum(n + 1, target);
    }

    private static int getFactorial(int n, int target) {
        if (n == target)
            return target;
        return n * getFactorial(n + 1, target);
    }

}

package offer.part3;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月04日 16:03
 */
public class P16 {

    @Test
    public void testPowerFunc() {
        double[][] input = {
                {1,2},
                {0.7,9},
                {9,9},
        };

        for (double[] item : input) {
            System.out.println(PowerWithUnsignedExponent(item[0], (int) item[1]));
        }
    }

    private double PowerWithUnsignedExponent(double base, int exponent) {

        // 检查输入有效性
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;

        // 递归计算 底数的(指数/2)次方，然后把这个结果相乘，减少计算次数
        double result = PowerWithUnsignedExponent(base, exponent >> 1);
        result *= result;

        // 检查当前的指数是否是奇数，因为 >> 操作会使奇数漏掉一次计算(损失精度)
        if ((exponent & 0x1) == 1)
            result *= base;

        return result;
    }

    @Test
    public void testBitOperation() {
        int a = 0;
        System.out.println((6 & 0x1) == 1);
    }
}

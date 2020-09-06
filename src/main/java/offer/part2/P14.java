package offer.part2;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月04日 9:30
 */
public class P14 {

    @Test
    public void test_solution_1() {
        int[] input = {1,2,3,4,5,6,7,8,9,10};
        for (int i = 0; i<input.length; i++) {
            System.out.println("index " +input[i]+ ":\t" + maxProductAfterCutting_solution_1(input[i]));
        }
    }

    /**
     * 动态规划的方式求解
     * @param length
     * @return
     */
    private int maxProductAfterCutting_solution_1(int length) {
        if (length <= 3) return length;

        int[] products = new int[length+1];

        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int sum, index, tempSum;
        for (int i = 4; i<products.length; i++) {
            sum = 0;
            for (int j = 1; j<=i/2; j++) {
                index = i - j;
                tempSum = products[index] * products[j];
                sum = Math.max(tempSum, sum);
            }
            products[i] = sum;
        }

        return products[length];
    }

    @Test
    public void testBitOperation() {
        int a = 31;
        System.out.println(a << 1);
    }
}

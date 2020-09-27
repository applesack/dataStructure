package leetcodes.nums.p100_200;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月27日 8:52
 */
public class P171 {

    @Test
    public void testFunc() {
        System.out.println(titleToNumber("AB"));
    }

    // 26进制
    public int titleToNumber(String s) {
        char[] raw = s.toCharArray();
        int sum = 0, weight = 1;

        for (int i = raw.length - 1; i>=0; i--) {

            sum += (raw[i] - 'A' + 1) * weight;

            weight *= 26;
        }

        return sum;
    }

}

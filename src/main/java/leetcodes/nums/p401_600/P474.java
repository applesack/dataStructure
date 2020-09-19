package leetcodes.nums.p401_600;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月02日 9:24
 */
public class P474 {

    @Test
    public void testFunc() {
        String[] input = {
//                "10", "0001", "111001", "1", "0"
                "10", "0", "1"
        };
//        System.out.println(findMaxForm(input, 5, 3));
        System.out.println(findMaxForm(input, 1, 1));
    }

    /**
     *
     * @param strs
     * @param m 0
     * @param n 1
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0)
            return 0;

        return Math.max(findMaxFormCore_0(strs, m, n,0,0),
                findMaxFormCore_0(strs, m, n,1,0));
    }

    // 二维数组动态规划
    public int findMaxFormCore_1(String[] strings, int m, int n) {
        return -1;
    }

    // 使用递归方式，超时
    private int findMaxFormCore_0(String[] strings, int m, int n, int idx, int count) {
        if (idx > strings.length - 1 || (m == 0 && n == 0))
            return count;

        int zero_count = 0, one_count = 0;
        char[] curArr = strings[idx].toCharArray();
        for (char item : curArr) {
            if (item == '0')
                zero_count++;
            else
                one_count++;
        }

        if (zero_count <= m && one_count <= n) {
            m -= zero_count;
            n -= one_count;
            count++;
        }

        return Math.max(findMaxFormCore_0(strings, m, n, idx + 1, count),
                findMaxFormCore_0(strings, m, n, idx + 2, count));
    }

}

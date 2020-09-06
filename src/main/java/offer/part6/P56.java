package offer.part6;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月20日 22:29
 */
public class P56 {
    @Test
    public void test() {
        int[] input = {1,1,2,3,3,4,5,5};
        int[] res = Sub_P1.s_1(input);
        System.out.println(Arrays.toString(res));
    }

    // 数组中只出现一次的两个数字
    private static class Sub_P1 {

        // 解法1: 排序
        private static int[] s_1(int[] data) {
            if (data == null || data.length <= 1 ||
                    (data.length == 2 && data[0] == data[1]))
                return new int[0];
            Arrays.sort(data);

            int[] res = new int[2];
            int currentIndex = 0;

            // 先检查首位是否符合条件
            if (data[0] != data[1])
                res[currentIndex++] = data[0];
            if (data[data.length - 1] != data[data.length - 2])
                res[currentIndex++] = data[data.length - 1];
            if (currentIndex == 2)
                return res;

            int pre, suf;
            for (int i = 1; i<data.length - 1; i++) {
                pre = i - 1;
                suf = i + 1;
                if (data[i] != data[pre] && data[i] != data[suf])
                    res[currentIndex++] = data[i];

                if (currentIndex == 2)
                    break;
            }
            return res;
        }
    }

    private class Sub_P2 {

    }
}

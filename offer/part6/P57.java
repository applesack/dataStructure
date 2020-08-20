package part6;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月20日 22:53
 */
public class P57 {

    @Test
    public void testS1Func() {
        int[] input = {1,2,4,7,11,15};
        int[] res = Sub_S1.findNumberWithSum_s1(input, 15);
        System.out.println(Arrays.toString(res));
    }

    private static class Sub_S1 {
        // 使用Map的方式，测试通过✔
        public static int[] findNumberWithSum_s1(int[] data, int sum) {
            if (data == null || data.length <= 1 ||
                    (data.length == 2 && data[0] + data[1] != sum))
                return new int[0];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i<data.length; i++)
                map.put(data[i], i);

            for (int i = 0; i<data.length; i++) {
                Integer remainder = map.getOrDefault(sum - data[i], null);

                if (remainder != null) {
                    int[] res = {data[i], data[remainder]};
                    return res;
                }
            }
            return new int[0];
        }


    }
}

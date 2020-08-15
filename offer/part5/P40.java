package part5;

import org.junit.Test;
import util.AUtil;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月15日 10:29
 */
public class P40 {

    @Test
    public void testFunc() {
        int[] input = {4,6,7,3,2,1};
        int k = 0;
        System.out.println(Arrays.toString(getLeastNumbers_r1(input, k)));
    }

    private int[] getLeastNumbers_r1(int[] data, int k) {
        if (data == null || data.length < k || k == 0)
            return new int[0];

        int start = 0;
        int end = data.length - 1;
        int index = AUtil.Partition(data, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = AUtil.Partition(data, start, end);
        }

        return Arrays.copyOfRange(data, 0, k);
    }
}

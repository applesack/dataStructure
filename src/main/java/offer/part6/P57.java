package offer.part6;

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
        int[] res = Sub_S1.findNumberWithSum_s2(input, 15);
        System.out.println(Arrays.toString(res));
    }

    // 数组中和为S的两个数
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

        // 根据排序数组的特性，使用双指针和二分查找的方法查找，测试通过✔
        public static int[] findNumberWithSum_s2(int[] data, int sum) {
            if (data == null || data.length <= 1 ||
                    (data.length == 2 && data[0] + data[1] != sum) ||
                    (data[0] > sum))
                return new int[0];

            int index = 0;      // 当前查找
            int left = index;   // 左边界
            int right;          // 有边界
            int mid;            // 中值的坐标
            int tmpSum;         // 临时的和

            while (index < data.length) {
                left  = index + 1;
                right = data.length - 1;

                while (left < right) {
                    mid = (left + right) / 2;
                    tmpSum = data[index] + data[mid];
                    if (tmpSum > sum) {          // 向右边的区间查找
                        left = mid;
                    } else if (tmpSum < sum) {   // 向左边的区间查找
                        right = mid;
                    } else {                     // 命中目标
                        return new int[] {data[index], data[mid]};
                    }
                }

                index++;
            }

            return new int[0];
        }
    }

    @Test
    public void testS2Func() {
        Sub_S2.findContinuousSequence(15);
    }

    // 和为s的正数序列
    private static class Sub_S2 {
        private static void findContinuousSequence(int sum) {
            if (sum <= 0)
                return;
            if (sum < 3) {
                PrintSequence(sum, sum);
                return;
            }

            int small = 1;
            int big   = 2;
            int middle = (1 + sum) / 2;
            int tmpSum = small + big;

            while (small < middle) {
                if (tmpSum == sum) {
                    PrintSequence(small, big);
                }
                while (tmpSum > sum && small < middle) {
                    tmpSum -= small;
                    small++;

                    if (tmpSum == sum)
                        PrintSequence(small, big);
                }

                big++;
                tmpSum += big;
            }
        }

        private static void PrintSequence(int form, int to) {
            System.out.print('[');
            for (int i = form; i<=to; i++) {
                System.out.print(i);
                if (i != to)
                    System.out.print(", ");
            }
            System.out.print(']');
            System.out.println();
        }
    }
}

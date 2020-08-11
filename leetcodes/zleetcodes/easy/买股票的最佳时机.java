package zleetcodes.easy;

import zleetcodes.util.LeetCodes;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月22日 16:10
 */

@LeetCodes(
        id = 121,
        level = LeetCodes.LEVEL.EASY,
        status = LeetCodes.Status.FINISHED,
        tags = {"动态规划"},
        createDate = "2020/05/22",
        finishTime = "1h"
)
public class 买股票的最佳时机 {

    // 暴力法
    public static int maxProfit(int[] prices) {

        if (prices.length <= 1) return 0;

        int max = 0;

        for (int i = 0; i<prices.length; i++) {
            for (int j = i+1; j<prices.length; j++) {
                max = Math.max(max, prices[j]-prices[i]);
            }
        }

        return max;
    }

    // 动态规划
    public static int maxProfit2(int[] prices) {

        if (prices.length <= 1) return 0;

        // 假定一个最小值
        int minVal = Integer.MAX_VALUE;
        // 最大收益
        int max = 0;

        for (int i = 0; i<prices.length; i++) {
            if (prices[i] < minVal) {
                minVal = prices[i];
            } else {
                max = Math.max(max, prices[i] - minVal);
            }
        }

        return max;
    }

    @Test
    public void Run() {
        int[] input = {7,1,5,3,6,4};
//        int[] input = {7,6,5,4,3,1};
//        int[] input = {1,7};
        System.out.println("输入: " + Arrays.toString(input));
        System.out.println("输出: " + maxProfit2(input));
    }
}

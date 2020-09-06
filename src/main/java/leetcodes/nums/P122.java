package leetcodes.nums;

import org.junit.Test;

import javax.swing.text.DefaultEditorKit;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月03日 20:53
 */
public class P122 {

    @Test
    public void testFunc() {
        int[] input =
//                {7, 1, 5, 3, 6, 4};
                {1, 2, 3, 4, 5};
        System.out.println(maxProfit(input));
    }

    public int maxProfit(int[] prices) {

        int sumVal = 0;
        int low = 0;
        int height = 0;
        int len = prices.length;

        while (low < len) {
            height = low;

            // 找到第一个峰谷
            for (int i = low; i<(len - 1); i++) {
                if (prices[i] < prices[i + 1]) {
                    low = i;
                    break;
                }
            }

            // 找到峰谷后的第一个峰顶
            for (int i = low + 1; i<len; i++) {
                if (prices[i] > prices[i - 1]) {
                    height = i;
                    break;
                }
            }

            if (prices[height] > prices[low])
                sumVal += (prices[height] - prices[low]);
            low++;
        }

        return sumVal;
    }

}

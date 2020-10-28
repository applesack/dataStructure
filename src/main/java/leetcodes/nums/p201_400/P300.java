package leetcodes.nums.p201_400;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月26日 11:38
 */
public class P300 {

    @Test
    public void testFunc() {
        int[] in = {10, 9, 2, 5, 100, 3, 4, 5, 6, 18};
        System.out.println(lengthOfLIS(in));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max_count = 1;
        for (int i = 1; i<nums.length; i++) {
            int max = 0;
            for (int j = 0; j<i; j++) {
                if (nums[j] < nums[i])
                    if (dp[j] > max)
                        max = dp[j];
            }
            max += 1;
            dp[i] = max;
            if (max > max_count)
                max_count = max;
        }
        return max_count;
    }

    @Test
    public void testPQ() {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(3);
        queue.add(2);
        System.out.println(queue.peek());
        queue.add(1);
        System.out.println(queue.peek());
        queue.poll();
        System.out.println(queue.peek());
    }

}

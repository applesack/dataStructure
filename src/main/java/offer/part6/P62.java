package offer.part6;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月21日 14:28
 */
public class P62 {

    @Test
    public void testFunc() {
        int[] input = {0,1,2,3,4};
        System.out.println(lastRemaining_s1(input, 3));
    }

    // 经典解法:通过队列模拟圆圈
    private int lastRemaining_s1(int[] nums, int step) {
        if (step <= 0 || nums == null || nums.length == 0)
            return -1;

        Deque<Integer> deque = new LinkedList<>();
        for (int num : nums) {
            deque.add(num);
        }

        while (deque.size() > 1) {
            for (int i = 0; i<step-1; i++) {
                deque.add(deque.pollFirst());
            }
            deque.pollFirst();
        }

        return deque.pop();
    }
}

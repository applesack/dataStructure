package leetcodes.nums.p401_600;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月20日 9:51
 */
public class P495 {

    @Test
    public void testFunc() {
        int[] in = {1, 5};
        System.out.println(findPoisonedDuration(in, 3));
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0)
            return 0;
        if (timeSeries.length == 1)
            return duration;

        int continuous_poisoning = timeSeries[0] + duration - 1;
        int sum = duration;

        for (int i = 1; i<timeSeries.length; i++) {
            int curTime = timeSeries[i];
            int ContinuedTo = curTime + duration - 1;
            if (curTime <= continuous_poisoning) {
                sum += ContinuedTo - continuous_poisoning;
            } else {
                sum += duration;
            }
            continuous_poisoning = ContinuedTo;
        }

        return sum;
    }

}

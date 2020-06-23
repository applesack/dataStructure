package leetcodes.medium;

import leetcodes.util.LeetCodes;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年06月22日 23:19
 */

@LeetCodes(
        id = 560,
        level = LeetCodes.LEVEL.MEDIUM,
        status = LeetCodes.Status.IN_PROGRESS,
        tags = {"滑动窗口"},
        createDate = "2020/06/22",
        finishTime = "NO"
)
public class 和为k的子数组 {

    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0)
            return 0;

        if (nums.length == 1) {
            return nums[0] == k ? 1 : 0;
        }

        int left = 0, right = 0;
        int sum = 0;
        int count = 0;

        while (right < nums.length) {

            sum += nums[right];

            if (sum < k) {
                while (left > 0 && sum <= k) {
                    sum += nums[--left];
                    if (sum == k)
                        count++;
                }
            } else if (sum > k) {
                while (left <= right && sum >= k) {
                    sum -= nums[left++];
                    if (sum == k)
                        count++;
                }
            } else {
                if (sum == k)
                    count++;
            }
            right += 1;
        }

        return count;
    }

    @Test
    public void Run() {
        int[] arr = new int[]{-1,-1,1};
        System.out.println(subarraySum(arr, 0));
    }
}

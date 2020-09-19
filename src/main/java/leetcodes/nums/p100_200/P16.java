package leetcodes.nums.p100_200;

import org.junit.Test;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月24日 14:39
 */
public class P16 {

    @Test
    public void  testFunc() {
        int[] input_1 = {-1, 2, 1, -4};
        int[] input_2 = {-3, -2, -5, 3, -4};
        int[] input_3 = {1, 1, 1, 0};
        int[] input_4 = {1, 0, 1, 2, -1, -4};
        int[] input_5 = {1, 6, 9, 14, 16, 70};
        int[] input_6 = {-1, 0, 1, 1, 55};
        System.out.println(threeSumClosest(input_1, 2) + ", 2");
        System.out.println(threeSumClosest(input_2, -100) + ", -12");
        System.out.println(threeSumClosest(input_3, 0) + ", 2");
        System.out.println(threeSumClosest(input_4, 2) + ", 2");
        System.out.println(threeSumClosest(input_5, 81) + ", 80");
        System.out.println(threeSumClosest(input_6, 3) + ", 2");
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int min_gap = Integer.MAX_VALUE, tmp_gap;
        int resVal  = 0;

        int left, mid, right, base;
        int len = nums.length;
        int tmpSum, tmpTarget, resTarget;
        for (int i = 0; i < len - 2; i++) {
            base  = nums[i];
            tmpTarget = target - base;

            for (int j = i + 1; j < len - 1; j++) {
                resTarget = tmpTarget - nums[j];
                tmpSum = getCloseValue(nums, j + 1, len - 1, resTarget);

                tmpSum += nums[i] + nums[j];
                tmp_gap = Math.abs(Math.max(tmpSum, target) - Math.min(tmpSum, target));
                if (tmp_gap < min_gap) {
                    min_gap = tmp_gap;
                    resVal  = tmpSum;
                }
            }
        }
        return resVal;
    }

    private int getCloseValue(int[] data, int left, int right, int target) {
        int o_l = left, o_r = right;

        if (data[left] < target)
            return data[left];
        if (data[right] > target)
            return data[right];

        int mid = left;
        while (left < right) {
            mid = (left + right) / 2;
            if (data[mid] == target )
                return target;
            if (mid > 1 && mid < data.length - 1) {
                if (data[mid - 1] < target && data[mid + 1] > target)
                    return data[mid];
            }

            if (data[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (mid > right)
            mid--;
        if (mid < left)
            mid++;

        return data[mid];
    }

    @Test
    public void testBinarySearchFunc() {
        int[] input = {-1, 0, 1, 1, 55};
        System.out.println(getCloseValue(input, 3, 4, 2));
    }
}

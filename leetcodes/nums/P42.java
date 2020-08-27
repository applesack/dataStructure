package nums;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月27日 9:48
 */
public class P42 {

    @Test
    public void testFunc() {
        //             0  1  2  3  4  5  6  7  8  9  10 11
        int[] input = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(input));
    }

    public int trap(int[] height) {
        int count = 0;
        int len   = height.length;

        int maxIdx = -1;
        int maxVal = -1;
        for (int i = 0; i<len; i++) {
            if (height[i] > maxVal) {
                maxIdx = i;
                maxVal = height[i];
            }
        }

        if (maxVal == 0)
            return count;

        int left = -1, right, tmpSum = 0;

        // 搜索左边的区间
        right = maxIdx;
        while (right > 0){
            left = getFarLeftMaxIdx(height, 0, right);

            tmpSum = 0;
            // 计算这一区间的实际容量
            for (int i = left; i<right; i++) {
                tmpSum += height[i];
            }

            count += (right - left) * height[left] - tmpSum;
            right = left;
        }

        // 搜索右边的区间
        left = maxIdx;
        while (left < len - 1) {
            right = getFarRightMaxIdx(height, left, len - 1);

            tmpSum = 0;
            for (int i = left + 1; i<=right; i++) {
                tmpSum += height[i];
            }

            count += (right - left) * height[right] - tmpSum;
            left = right;
        }

        return count;
    }

    // 在一个区间内，找到最靠左边的最大值的下标 [begin, end)
    private int getFarLeftMaxIdx(int[] data, int begin, int end) {
        int maxIdx = begin;
        int maxVal = -1;
        for (int i = end - 1; i>=begin; i--) {
            if (data[i] >= maxVal) {
                maxIdx = i;
                maxVal = data[i];
            }
        }

        return maxIdx;
    }

    // 在一个区间内，找到最靠右边的最大值的下标 (begin, end]
    private int getFarRightMaxIdx(int[] data, int begin, int end) {
        int maxIdx = end;
        int maxVal = -1;
        for (int i = begin + 1; i<=end; i++) {
            if (data[i] >= maxVal) {
                maxIdx = i;
                maxVal = data[i];
            }
        }

        return maxIdx;
    }
}

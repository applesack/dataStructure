package offer.part2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月03日 9:59
 */
public class P11 {

    /**
     * 获取旋转数组的最小值
     */
    @Test
    public void testGetMinFunc() {
        int[][] input = {
                {0,1,1,1,1},
                {1,1,1,0,1},
                {1,0,1,1,1},
                {1,2,3,4,5},
                {2,3,4,5,1},
                {3,4,5,1,2},
        };

        for (int[] arr : input) {
            System.out.println(getMinNum_case1(arr) +": "+ Arrays.toString(arr));
        }
    }

    /**
     * 使用二分查找的思路
     * @param arr
     * @return
     */
    private int getMinNum_case1(int[] arr) {
        if (arr.length == 0) return -1;
        if (arr.length == 1) return arr[0];

        // 左指针 右指针
        int left  = 0;
        int right = arr.length-1;
        int mid;

        // 假如最左边的元素小于最右边的元素，则代表该数组已经是一个排序数组了，而最左边的元素就是最小值
        if (arr[left] < arr[right])
            return arr[left];

        while (left < right) {
            if (left == right-1)
                return arr[right];

            mid = left + (right - left) / 2;

            if (arr[left] == arr[right] && arr[right] == arr[mid])
                return getMinFromArrayInterval(arr, left, right);

            // 缩小范围
            if (arr[left] <= arr[mid]) { // 最小值在右边
                left = mid;
            } else {                    // 最小值在左边
                right = mid;
            }
        }

        return -1;
    }

    private int getMinFromArrayInterval(int[] arr, int left, int right) {
        int min = Integer.MAX_VALUE;
        for (int i = left+1; i<right; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }
}

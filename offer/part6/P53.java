package part6;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月16日 17:30
 */
public class P53 {
    @Test
    public void testFunc() {
        int[] input = {4,5,6,7,7,7,7,7,7,8,9};
        System.out.println(getNumberOfK(input, 0));
    }

    private int getNumberOfK(int[] data, int k) {
        if (data == null || data.length == 0)
            return -1;
        int index = BinarySearch(data, 0, data.length - 1, k);
        if (index != -1) {
            int count = 0, pos;

            // 查找左边
            pos = index;
            while (pos >= 0 && data[pos--] == k)
                count++;

            // 查找右边
            pos = index + 1;
            while (pos < data.length && data[pos++] == k)
                count++;

            return count;
        } else {
            return 0;
        }
    }

    private int BinarySearch(int[] data, int left, int right, int target) {
        if (left <= right) {
            int mid = (left + right) / 2;
            if (data[mid] < target) {
                BinarySearch(data, mid + 1, right, target);
            } else if (data[mid] > target) {
                BinarySearch(data, left, mid - 1, target);
            } else {
                return mid;
            }
        }
        return -1;
    }
}

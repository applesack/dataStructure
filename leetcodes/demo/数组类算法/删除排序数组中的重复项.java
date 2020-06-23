package demo.数组类算法;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年06月23日 11:10
 */
public class 删除排序数组中的重复项 {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int count = 0;
        for (int i = 1; i<len; i++) {
            if (nums[i] == nums[i-1]) {
                count++;
            } else {
                nums[i-count] = nums[i];
            }
        }
        return len - count;
    }

    @Test
    public void Run() {
        int[] sort_arr = new int[]{1,1,2};
        int count = removeDuplicates(sort_arr);
        System.out.println(Arrays.toString(sort_arr)+", "+count);
    }
}

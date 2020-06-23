package demo.数组类算法;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年06月23日 10:39
 */
public class 移动0 {

    public void moveZeroes(int[] nums) {
        int zero_count = 0;
        int len = nums.length;
        for (int i = 0; i<len; i++) {
            if (nums[i] == 0) {
                zero_count++;
            } else {
                nums[i-zero_count] = nums[i];
            }
        }

        for (int i = len-zero_count; i<len; i++) {
            nums[i] = 0;
        }
    }

    @Test
    public void Run() {
        int[] arr = new int[]{0,0,1,2,0,3};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}

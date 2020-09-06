package leetcodes.demo.数组类算法.初始定义;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年06月23日 11:00
 */
public class 移除元素 {

    public int removeElement(int[] nums, int val) {

        int valCount = 0;
        int len = nums.length;
        for (int i = 0; i<len; i++) {
            if (nums[i] == val) {
                valCount++;
            } else {
                nums[i-valCount] = nums[i];
            }
        }
        return len-valCount;
    }

    @Test
    public void Run() {
        int[] arr = new int[]{3,2,3,4,6,7};
        int count = removeElement(arr, 3);
        System.out.println(Arrays.toString(arr)+", "+count);
    }
}

package demo.数组类算法.初始定义;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年06月23日 12:32
 */
public class 删除排序数组中的重复项II {

    /**
     * 移除重复的元素，每个元素最多重复两次
     * @param nums 一个有序数组
     * @return 有效的元素个数
     */
    public int removeDuplicates(int[] nums) {
        int len = nums.length;

        if (len == 0) return 0;

        int count = 0;             // 重复元素的个数
        int NotRepeatingCount = 0; // 当前不重复的元素个数
        int pre = nums[0];

        for (int i = 1; i<len; i++) {

            if (nums[i] == pre) {
                NotRepeatingCount++;
                if (NotRepeatingCount > 1)
                    count++;
                else
                    nums[i-count] = nums[i];
            } else {
                pre = nums[i];
                NotRepeatingCount = 0;
                nums[i-count] = nums[i];
            }
        }

        return len - count;
    }

    @Test
    public void Run() {
        int[] sort_arr = new int[]{0,1,1,1,1,2,2,2,2,3,3};
//        int[] sort_arr = new int[]{1,1,1,2,2,3};
        int count = removeDuplicates(sort_arr);
        System.out.println(Arrays.toString(sort_arr)+", "+count);
    }
}

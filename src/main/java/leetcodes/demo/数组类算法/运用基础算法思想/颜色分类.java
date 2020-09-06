package leetcodes.demo.数组类算法.运用基础算法思想;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年06月23日 16:40
 */
public class 颜色分类 {

    public void sortColors(int[] nums) {
        int zero_count = 0;
        int one_count  = 0;
        int two_count  = 0;

        for (int num : nums) {
            switch (num) {
                case 0:
                    zero_count++;break;
                case 1:
                    one_count++;break;
                case 2:
                    two_count++;break;
            }
        }

        int index = 0, target = 0;
        for (target += zero_count; index<target; index++) nums[index] = 0;
        for (target += one_count ; index<target; index++) nums[index] = 1;
        for (target += two_count ; index<target; index++) nums[index] = 2;
    }

    @Test
    public void Run() {
//        int[] arr = new int[]{0,0,2,2,1,1};
        int[] arr = new int[]{};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}

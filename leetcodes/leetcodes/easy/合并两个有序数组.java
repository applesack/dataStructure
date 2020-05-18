package leetcodes.easy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月18日 16:49
 */
public class 合并两个有序数组 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        // 新建一个数组num3保存之前m里的数据
        int[] nums3 = Arrays.copyOfRange(nums1, 0, m);

        int index = 0; // 目标数组的下标(nums1)

        while (m >= 1) {
            /**
             * 把小于nums3数组当前元素的nums2的元素放到nums1目标数组
             * 同时把对应表示数组剩余元素的长度后移(m,n)
             */
            while (n >= 1 && nums2[nums2.length - n] < nums3[nums3.length - m]) {
                nums1[index] = nums2[nums2.length - n];
                index++;
                n--;
            }

            // 当没有比nums2当前元素更小的nums2元素，就把当前的muns3元素放进去
            nums1[index] = nums3[nums3.length - m];
            index++;
            m--;
        }

        // 将num2数组剩余的元素放入num1
        if (n >= 1) {
            while (index < nums1.length) {
                nums1[index] = nums2[nums2.length - n];
                n--;
                index++;
            }
        }
    }

    @Test
    public void Run() {
        int[] arr1 = new int[]{4,5,6,0,0,0};
        int[] arr2 = new int[]{1,2,3};

        merge(arr1, 3, arr2, 3);

        System.out.println(Arrays.toString(arr1));
    }
}

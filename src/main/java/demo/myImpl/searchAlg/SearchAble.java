package demo.myImpl.searchAlg;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月12日 16:36
 */
public interface SearchAble {
    /**
     * 需要实现的功能，判断目标值是否存在于数组中
     * @param arr
     * @param target
     * @return 不存在于数组，返回-1，存在则返回对应的下标
     */
    int contain(int[] arr, int target);

    /**
     * 检验contain函数计算结果是否正确
     * @param arr
     * @param target
     * @return
     */
    default boolean check(int[] arr, int target) {
        int target_idx = contain(arr, target);
        if (target_idx != -1) {
            return arr[target_idx] == target;
        } else {
            for (int item : arr) {
                if (item == target)
                    return false;
            }
        }
        return true;
    }

    /**
     * 判断一个数组是否是由小到大增量排序的
     * @param arr
     * @return
     */
    default boolean isOrderly(int[] arr) {
        if (arr == null)
            return false;
        if (arr.length == 0 || arr.length == 1)
            return true;

        for (int i = 1; i<arr.length; i++) {
            if (arr[i] - arr[i - 1] < 0)
                return false;
        }
        return true;
    }
}
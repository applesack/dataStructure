package demo.myImpl.sortAlgorithm;

import com.sun.scenario.effect.impl.prism.PrReflectionPeer;
import org.junit.Test;
import demo.util.AUtil;
import demo.util.ProxyUtil;
import demo.util.RandomUtil;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月10日 20:51
 */
public class MyQuickSort implements Sortable {

    @Test
    public void testFunc() {
        MyQuickSort qs = (MyQuickSort) new ProxyUtil(this.getClass()).getInstance();
        int[] input = RandomUtil.getRandomArr(8000000, -100000, 2000000);
        AUtil.Partition(input);
    }

    @Override
    public int[] sort(int[] arr) {
        if (arr == null || arr.length == 0) return new int[0];
        int[] res = qSortCore(arr, 0, arr.length - 1);
        return res;
    }

    private int[] qSortCore(int[] arr, int left, int right) {
        int l = left;
        int r = right;

        int mid = arr[(l + r) / 2];
        int temp;
        while (l < r) {
            // 左坐标一直向右边移动，直到找到一个大于中间值的位置
            while (arr[l] < mid) {
                ++l;
            }

            // 右坐标一直向坐标移动，直到找到一个小于中间值的位置
            while (arr[r] > mid) {
                --r;
            }

            // 一圈下来之后，假如左坐标大于右坐标，表示当前数组序列已经满足左边大，右边小，则 退出进行下一轮
            if (l >= r) {
                break;
            }

            // 交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == mid) {
                --r;
            }
            if (arr[r] == mid) {
                ++l;
            }
        }

        if (l == r) {
            ++l;
            --r;
        }

        if (r > left) {
            qSortCore(arr, left, r);
        }
        if (l < right) {
            qSortCore(arr, l, right);
        }
        return arr;
    }
}

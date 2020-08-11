package myImpl.sortAlgorithm;

import org.junit.Test;
import util.ProxyUtil;
import util.RandomUtil;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月11日 15:57
 */
public class MyMergeSort implements Sortable {

    @Test
    public void testSortFunc() {
        MyMergeSort myMergeSort = (MyMergeSort) new ProxyUtil(MyMergeSort.class).getInstance();
        int[] input = RandomUtil.getRandomArr(-100000, 2000000, 10000000);
        myMergeSort.sort(input);
    }

    @Override
    public int[] sort(int[] arr) {
        splitArray(arr, 0, arr.length - 1, new int[arr.length]);
        return arr;
    }

    public void splitArray(int[] arr, int left, int right, int[] tmpArr) {
        if (left < right) {
            int midIdx = (left + right) / 2;
            // 分解左子数组
            splitArray(arr, left, midIdx, tmpArr);
            // 分解右子数组
            splitArray(arr, midIdx + 1, right, tmpArr);
            // 合并
            merge(arr, left, right, tmpArr, midIdx);
        }
    }

    public void merge(int[] arr, int left, int right, int[] tmpArr, int mid) {
        int l = left;
        int r = mid + 1;
        int t = 0;

        while (l <= mid && r <= right) {
            if (arr[l] < arr[r]) {
                tmpArr[t] = arr[l];
                l++;
            } else {
                tmpArr[t] = arr[r];
                r++;
            }
            t++;
        }

        while (l <= mid) {
            tmpArr[t] = arr[l];
            l++;
            t++;
        }

        while (r <= right) {
            tmpArr[t] = arr[r];
            r++;
            t++;
        }

        t = 0;
        int tmpLeft = left;
        while (tmpLeft <= right) {
            arr[tmpLeft] = tmpArr[t];
            t++;
            tmpLeft++;
        }
    }
}

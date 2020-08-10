package 查找算法.二分查找;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年04月24日 16:34
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,5,7,9,9,9,9,10,11};
//        System.out.println(binarySearch(arr, 0, arr.length-1, -17));

        List<Integer> resIndexList = binarySearch2(arr, 0, arr.length-1, 9);
        System.out.println(resIndexList.toString());
    }

    /**
     * 二分查找
     * @param arr 要被查找的数组
     * @param left 左边界
     * @param right 有边界
     * @param findVal 要查找的值
     * @return 值的下标，当值不存在则返回-1
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        // 每次传递left和right都会向一个区间缩小，当left大于right就表明当前数组已找完且没有发现目标
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) { // 向右递归
            return binarySearch(arr, mid+1, right, findVal);
        } else if (findVal < midVal) { // 向左递归
            return binarySearch(arr, left, mid-1, findVal);
        } else {
            return mid;
        }
    }

    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return new ArrayList<Integer>();
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) { // 向右递归
            return binarySearch2(arr, mid+1, right, findVal);
        } else if (findVal < midVal) { // 向左递归
            return binarySearch2(arr, left, mid-1, findVal);
        } else {
            List<Integer> resIndexList = new ArrayList<Integer>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp -= 1;
            }

            resIndexList.add(mid);
            temp = mid + 1;
            while (true) {
                if (temp > arr.length || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp += 1;
            }
            return resIndexList;
        }
    }
}

package demo.查找算法.插值查找;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年04月24日 20:38
 */
public class InsertValueSearch {

    public static void main(String[] args) {
        int[] arr = new int [100];
        for (int i = 0; i<100; i++) {
            arr[i] = i + 1;
        }

        // 测试
        System.out.println(insertValueSearch(arr, 0, arr.length-1, 99));
    }

    /**
     * 插值查找法,特点是当需要查找的数组数值分布越均匀效率越高
     * @param arr 一个有序数组
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {

        /**
         * 1. 如果arr数组都已经查完仍然没有找到
         * 2. 要查找的值小于数组的最小值
         * 3. 要查找的值大于数组最大的值
         */
        if (left > right || findVal < arr[0] || findVal > arr[arr.length -1]) {
            return -1;
        }

        // 中间值的下标
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);

        int midValue = arr[mid];

        if (findVal > midValue) { // 大于中间值，应该向右边递归

            return insertValueSearch(arr, mid+1, right, findVal);

        } else if (findVal < midValue) { // 小于中间值，应该向左边递归

            return insertValueSearch(arr, left, mid-1, findVal);

        } else { // midValue == findVal 表示已经找到，直接返回对于的下标
            return mid;
        }
    }
}

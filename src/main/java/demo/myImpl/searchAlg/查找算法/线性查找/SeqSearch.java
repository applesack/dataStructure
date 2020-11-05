package demo.myImpl.searchAlg.查找算法.线性查找;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年04月22日 22:32
 */
public class SeqSearch {

    public static void main(String[] args) {
        int[] arr = {-1, 43, 89, 90, 11, 43};

        int index = seqSearch(arr, 43);
        if (index == -1) {
            System.out.println("没找到");
        } else {
            System.out.println("找到了，下标是" + index);
        }
    }

    /**
     * 线性查找
     * @param arr 要被查找的数组
     * @param value 要匹配的值
     * @return 值在数组的出现第一次的下标，假如值在数组不存在，返回-1
     */
    public static int seqSearch(int[] arr, int value) {
        // 线性查找是逐一比对，发现有相同值，就返回下标

        for (int i = 0; i<arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}

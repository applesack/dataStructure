package myImpl.sortAlgorithm;

import org.junit.Test;
import util.ProxyUtil;
import util.RandomUtil;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月12日 9:30
 */
public class MyShellSort implements Sortable {

    @Test
    public void testSortFunc() {
        MyShellSort ss = (MyShellSort) new ProxyUtil(MyShellSort.class).getInstance();
        MyQuickSort qs = (MyQuickSort) new ProxyUtil(MyQuickSort.class).getInstance();
        int[] input = RandomUtil.getRandomArr(8000000, -100000, 2000000);
        ss.shellSort(input);  // 哈希
        qs.sort(input);       // 快排
    }

    @Override
    public int[] sort(int[] arr) {

        int len = arr.length, temp;
        for (int step = len/2; step>0; step /= 2) {
            for (int i = step; i < len; i++) {
                for (int j = i - step; j>=0; j -= step) {
                    if (arr[j] > arr[j + step]) {
                        // swap
                        temp = arr[j];
                        arr[j] = arr[j + step];
                        arr[j + step] = temp;
                    }
                }
            }
        }

        return arr;
    }

    public void shellSort(int []a){
        for(int i=a.length/2;i>0;i /=2){
            for(int j = i;j<a.length;j++){
                int k =j;
                int temp = a[j];
                for(;k>=i && a[k-i] > temp; k -=i){
                    a[k] = a[k-i];
                }
                if(j != i){
                    // 小幅度优化
                    a[k] = temp;
                }

            }
        }
    }

}

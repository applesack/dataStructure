package demo.myImpl.searchAlg;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月12日 16:59
 */
public class SeqSearch implements SearchAble {
    @Test
    public void testFunc() {
    }

    @Override
    public int contain(int[] arr, int target) {
        for (int i = 0; i<arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }
}

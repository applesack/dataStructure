package leetcodes.demo.d;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月19日 20:22
 */
public class Case3 {

    @Test
    public void testFunc() {
        System.out.println(getMax(3.0d, 1.0d, 2.0d));
        System.out.println(getMax(3f, 1.0f, 2f));
        System.out.println(getMax(3, 1, 2));
    }

//    public int getMax(int n1, int n2, int n3) {
//        int[] arr = new int[3];
//        arr[0] = n1;
//        arr[1] = n2;
//        arr[2] = n3;
//        int max = arr[0];
//        for (int num : arr)
//            if (num > max)
//                max = num;
//        return max;
//    }

    @SafeVarargs
    public static <T extends Comparable<? super T>> T getMax(T ... values) {
        T max = values[0];
        for (T type : values)
            if (type.compareTo(max) > 0)
                max = type;
        return max;
    }

}

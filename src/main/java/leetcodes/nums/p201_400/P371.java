package leetcodes.nums.p201_400;

import java.util.stream.IntStream;

import org.junit.Test;

/**
 * @author  flutterdash@qq.com
 * @date    2020/09/06 13:49
 */
public class P371 {
   
    @Test
    public void testFunc() {
        
    }

    public static void main(String[] args) {
        System.out.println(getSum(1, 2));
    }

    public static int getSum(int a, int b) {
        return IntStream.of(a, b).sum();
    }

}

package leetcodes.nums.p401_600;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月23日 15:20
 */
public class P406 {

    @Test
    public void testFunc() {
        int[][] in = {
                {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
        };
        for (int[] x : reconstructQueue(in)) {
            System.out.println(Arrays.toString(x));
        }
    }

    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, Comparator.comparingInt(a -> (a[0] + a[1])));
        return people;

    }

}

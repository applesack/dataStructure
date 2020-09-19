package leetcodes.nums.p401_600;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月12日 10:30
 */
public class P455 {

    @Test
    public void testFunc() {
        int[] in_1 = {1, 2, 3};
        int[] in_2 = {2, 2, 1};

        System.out.println(findContentChildren(in_1, in_2));
    }

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;

        int i = 0, j = 0;

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i++;
                count++;
            }
            j++;
        }

        return count;
    }

}

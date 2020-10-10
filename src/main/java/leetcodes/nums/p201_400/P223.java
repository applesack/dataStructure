package leetcodes.nums.p201_400;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月10日 10:45
 */
public class P223 {

    @Test
    public void testFunc() {
        System.out.println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // 宽度从左到右，高度从下到上
        int[] rectA_wid = {A, C};
        int[] rectA_hei = {B, D};

        int[] rectB_wid = {E, G};
        int[] rectB_hei = {F, H};

        // 计算两个矩形的面积总和
        int sum_area =
                (rectA_wid[1] - rectA_wid[0]) * (rectA_hei[1] - rectA_hei[0]) +
                        (rectB_wid[1] - rectB_wid[0]) * (rectB_hei[1] - rectB_hei[0]);

        // 计算重叠部分
        int overlapping_part =
                getInterval(rectA_wid, rectB_wid) *
                        getInterval(rectA_hei, rectB_hei);

        return sum_area - overlapping_part;
    }

    // 计算两个线段的相交部分
    private int getInterval(int[] rectA, int[] rectB) {
        int[][] rect0 = {rectA, rectB};
        Arrays.sort(rect0, Comparator.comparingInt(rect_a -> rect_a[0]));
        if (rect0[0][1] <= rect0[1][0])
            return 0;
        int[] line = {rectA[0], rectA[1], rectB[0], rectB[1]};
        Arrays.sort(line);
        return line[2] - line[1];
    }

    @Test
    public void testGetInterval() {
        int[] rA = {-3, 0};
        int[] rB = {0, 9};
        System.out.println(getInterval(rA, rB));
    }

}
